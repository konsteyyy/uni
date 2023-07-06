package com.konsteyyy.git.uni.dea.hashmap;

public class Entry<Key, Value> {
	private Key key;
    private Value value;

    public Entry(Key key, Value value) {
        this.key = key;
        this.value = value;
    }

    public Key getKey() {
        return key;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }
}
