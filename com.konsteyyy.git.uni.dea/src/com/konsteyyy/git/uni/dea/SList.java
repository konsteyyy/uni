package com.konsteyyy.git.uni.dea;

public class SList<T> implements IList<T> {
	
	private ListElement<T> head;
	private int len;
	//overloaded, to create a List without head
	public SList() {
		super();
	}
	
	public SList(ListElement<T> head) {
		this.head = head;
	}
	
	@Override
	public boolean empty() {
		//if the list length is zero, it is empty
		return (len == 0);
	}

	@Override
	public void clear() {
		ListElement<T> current = head;
		while(current.getNext() != null) {
			current = null;
			current = current.getNext();
		}
		current = null;
	}

	@Override
	public void append(T el) {
		ListElement<T> current = head;
		while(current.getNext() != null) {
			current = current.getNext();
		}
		current.setNext(new ListElement<T>(el));
	}

	@Override
	public void insert(Object el, int pos) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int pos) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteLast() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reverse() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T get(int pos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.len;
	}
	
	@Override
	public String toString() {
		return "";
	}
	
}
