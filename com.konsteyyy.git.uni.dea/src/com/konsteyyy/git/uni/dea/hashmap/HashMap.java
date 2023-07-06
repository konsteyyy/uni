package com.konsteyyy.git.uni.dea.hashmap;

import java.util.ArrayList;
import java.util.LinkedList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class HashMap<Key, Value> {

	private int m;
	private ArrayList<LinkedList<Entry<Key, Value>>> hashtable;

	public HashMap() {
		this.m = 997;
		this.hashtable = new ArrayList<>(this.m);
		for (int i = 0; i < this.m; i++) {
            hashtable.add(new LinkedList<>());
        }
	}

	public void put(Key key, Value value) {
		LinkedList<Entry<Key, Value>> liste = this.hashtable.get(h(key));
		Entry<Key, Value> entry = searchForEntryWithKey(key);
		
		if(entry != null)
			entry.setValue(value);
		else
			liste.add(new Entry<>(key, value));
	}

	public boolean contains(Key key) {
		Entry<Key, Value> entry = searchForEntryWithKey(key);
		return entry != null;
	}

	public Value get(Key key) {
		Entry<Key, Value> entry = searchForEntryWithKey(key);
		return entry.getValue();
	}

	public void delete(Key key) {
		LinkedList<Entry<Key, Value>> liste = this.hashtable.get(h(key));
		Entry<Key, Value> entry = searchForEntryWithKey(key);
		
		if(entry != null)
			liste.remove(entry);
	}
	
	private int h(Key key) {
		// Hashfunktion mit Hilfe der Divisionsmethode
		return Math.abs(key.hashCode()) % this.m;
	}
	
	private Entry<Key,Value> searchForEntryWithKey(Key key) {
		//Hilfsfunktion um durch die Hash Tabelle durch zu iterieren
		LinkedList<Entry<Key, Value>> liste = this.hashtable.get(h(key));
		
		for (Entry<Key, Value> entry : liste) {
			if (entry.getKey().equals(key)) {
				return entry;
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		
		String filePath = args[0];
		
		try(BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			HashMap<String, Integer> wordCountMap = new HashMap<>();
			while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+"); // Teile die Zeile in Wörter auf

                for (String word : words) {
                    // Entferne Satzzeichen und Leerzeichen am Anfang/Ende des Wortes
                    word = word.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

                    if (!word.isEmpty()) {
                    	if(wordCountMap.contains(word)) {
	                        // Zähle das Wort in der Map
	                        int count = wordCountMap.get(word);
	                        wordCountMap.put(word, count + 1);
                    	} else {
                    		wordCountMap.put(word, 0);
                    	}
                    }
                }
                HashMap<Integer, String> top10 = new HashMap<>();
                for (String word : words) {
                    // Entferne Satzzeichen und Leerzeichen am Anfang/Ende des Wortes
                    word = word.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

                    if (!word.isEmpty()) {
                    	top10.put(wordCountMap.get(word), word);
                    }
                    
                }
            }
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
