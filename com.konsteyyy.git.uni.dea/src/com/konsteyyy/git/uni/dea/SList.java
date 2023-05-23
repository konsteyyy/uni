package com.konsteyyy.git.uni.dea;

public class SList<T> implements IList<T> {
	
	private ListElement<T> head;
	
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
		return (size() == 0);
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
		
		
	}

	@Override
	public void reverse() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T get(int pos) {
		ListElement<T> current = head;
		for(int i = pos; i>=0; i--) {
			if(current.getNext() != null)
				current = current.getNext();
			else
				return null;
		}
		return current.getData();
	}

	@Override
	public int size() {
		int len = 0;
		ListElement<T> current = head;
		while(current.getNext() != null) {
			current = current.getNext();
			len++;
		}
		return len;
	}
	
	@Override
	public String toString() {
		return "";
	}
	
}
