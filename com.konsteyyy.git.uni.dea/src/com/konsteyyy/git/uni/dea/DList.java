package com.konsteyyy.git.uni.dea;

public class DList<T> implements IList<T> {

	private DListElement<T> head;
	private DListElement<T> tail;
	
	public DList() {
		super();
	}
	
	public DList(DListElement<T> head, DListElement<T> tail) {
		this.head = head;
		this.tail = tail;
	}
	
	@Override
	public boolean empty() {
		// TODO Auto-generated method stub
		return head==null && tail==null;
	}

	@Override
	public void clear() {
		head = null;
		tail = null;
	}
	
	@Override
	public void append(T el) {
		DListElement<T> newElement = new DListElement<T>(el);
		if(empty()) {
			head=newElement;
			tail=newElement;
		} else {
			tail.setNext(newElement);
			tail.getNext().setPrev(tail);
			tail=newElement;
		}
	}
	
	@Override
	public void insert(T el, int pos) {
	    DListElement<T> newElement = new DListElement<T>(el);
	    
	    //if pos==0, then new element is head
	    if (pos == 0) {
	    	newElement.setNext(head);
	    	if(empty())
	    		append(el);
	    	else
	    		head.setPrev(newElement);
		        head = newElement;
	    } else {
	    	DListElement<T> current = head;
	    	while(current!=null && pos>1) {
	    		current = current.getNext();
	    		pos--;
	    	}
	    	
	    	if (current != null) {
	    		// new Element gets pos-1 und pos as new prev and next
	            newElement.setNext(current.getNext());
	            newElement.setPrev(current);
	            if (current.getNext() != null) {
	                current.getNext().setPrev(newElement);
	            }
	            current.setNext(newElement);
	            if (current == tail) {
	                tail = newElement;
	            }
	        } else {
	            throw new IndexOutOfBoundsException("Ungültige Position: " + pos);
	        }
	    }
	}


	@Override
	public void delete(int pos) {
		if(pos == 0) {
			head = head.getNext();
			if(head != null)
				head.setPrev(null);
			if(size() == 1)
				tail = null;
		} else if (pos == size()-1) {
			tail = tail.getPrev();
			tail.setNext(null);
		} else {
			DListElement<T> current = head;
			while(current!= null && pos >1) {
				current.getNext();
				pos--;
			}
			if(current!=null) {
				current.getPrev().setNext(current.getNext());
				current.getNext().setPrev(current.getPrev());
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
		DListElement<T> current = head;
		while(current != null) {
			DListElement<T> temp = current.getNext();
			current.setNext(current.getPrev());
			current.setPrev(temp);
			current = temp;
		}
		
		DListElement<T> temp = head;
		head = tail;
		tail = temp;
	}

	@Override
	public T get(int pos) {
		DListElement<T> current = head;
		for(int i =pos; i>0; i--) {
			if(current != tail)
				current = current.getNext();
			else
				throw new IndexOutOfBoundsException("Ungültige Position: " +pos);
		}
		return current.getData();
	}

	@Override
	public int size() {
		int len=0;
		DListElement<T> current =head;
		while(current != null) {
			len++;
			current = current.getNext();
		}
		return len;
	}

	@Override
	public String toString() {
		String string = "[";
		DListElement<T> current = head;
		while(current != null) {
			string+=current.getData();
			current = current.getNext();
			string += current != null? ",":"";
		}
		string += "]";
		return string;
	}

}
