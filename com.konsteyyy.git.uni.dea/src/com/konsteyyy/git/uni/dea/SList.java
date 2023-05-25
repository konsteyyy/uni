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
		return (head == null);
	}

	@Override
	public void clear() {
		//Garbage collector frees all other elements
		head = null;
	}

	@Override
	public void append(T el) {
		ListElement<T> newElement = new ListElement<T>(el);
		if(empty())
			head = newElement;
		else {
			ListElement<T> current = head;
			while(current.getNext() != null) {
				current = current.getNext();
			}
			current.setNext(newElement); 
		}
	}

	@Override
	public void insert(T el, int pos) {
		ListElement<T> newElement = new ListElement<T>(el);
		if(pos == 0) {
			//new element is the new head
			newElement.setNext(head);
			head = newElement;
		}
		else {
			ListElement<T> current = head;
			//iterate through list until iterator is an element after list or right position reached
			while(current != null && pos >1) {
				current = current.getNext();
				pos--;
			}
			if(current != null) {
				newElement.setNext(current.getNext());
				current.setNext(newElement); 
			} else {
				throw new IndexOutOfBoundsException("Ungültige Position: " + pos);
			}
		}
	}

	@Override
	public void delete(int pos) {
		if(pos == 0) {
			//new element is the new head
			head = head.getNext();
		}
		else {
			ListElement<T> current = head;
			while(current.getNext() != null && pos >1) {
				current = current.getNext();
				pos--;
			}
			if(current.getNext() != null) {
				//garbage collector automatically frees old element
				current.setNext(current.getNext().getNext());
			} else {
				throw new IndexOutOfBoundsException("Ungültige Position: " + pos);
			}
		}
		
	}

	@Override
	public void deleteLast() {
		delete(size()-1);
	}

	@Override
	public void reverse() {
		ListElement<T> prev = null;
		ListElement<T> current = head;
		
		while(current != null) {
			ListElement<T> temp = current.getNext();
			current.setNext(prev);
			prev = current;
			current = temp;
		}
		
		head = prev;
	}

	@Override
	public T get(int pos) {
		ListElement<T> current = head;
		for(int i = pos; i>0; i--) {
			if(current.getNext() != null)
				current = current.getNext();
			else
				throw new IndexOutOfBoundsException("Ungültige Position: " + pos);
		}
		return current.getData();
	}
	
	//method that does exactly the same as get, but returns the object instead of the data
	public ListElement<T> getElement(int pos) {
		ListElement<T> current = head;
		for(int i = pos; i>0; i--) {
			if(current.getNext() != null)
				current = current.getNext();
			else
				throw new IndexOutOfBoundsException("Ungültige Position: " + pos);
		}
		return current;
	}

	@Override
	public int size() {
		int len = 0;
		ListElement<T> current = head;
		while(current != null) {
			current = current.getNext();
			len++;
		}
		return len;
	}
	
	@Override
	public String toString() {
		String string = "[";
		ListElement<T> current = head;
		while(current != null) {
			string+=current.getData();
			current = current.getNext();
			string += current != null? ",":"";
		}
		string += "]";
		return string;
	}
	
}
