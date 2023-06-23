package com.konsteyyy.git.uni.dea.radixsort;

public class Queue<T> {
	
	protected QueueNode<T> front; // Zeiger auf erstes Element
	protected QueueNode<T> back; // Zeiger auf letztes Element
	protected int len; // aktuelle Länge der Queue
	
	public void enqueue(T d) {
		back.setNext(new QueueNode<T>(d));
		len++;
	}
	// ans Ende der Queue
	public void dequeue() {
		front = front.getNext();
		len--;
	}
	public T first() {
		return front.getData();
	}
	
	// ersten Items, ohne die Datenstruktur zu verändern
	public boolean isEmpty() {
		return front == null;
	}
	// Liefert wahr, falls Queue leer ist
	public int length() {
		return len;
	}
}
