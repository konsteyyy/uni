package com.konsteyyy.git.uni.dea.list;

public class ListElement<T> {
	private T data;
	private ListElement<T> next;
	
	public ListElement() {
		
	}
	public ListElement(T data) {
		this.data = data;
	}
	
	public ListElement(T data, ListElement<T> next) {
		this.data = data;
		this.next = next;
	}
	
	public T getData() {
		return this.data;
	}
	
	public ListElement<T> getNext() {
		return this.next;
	}
	
	public void setData(T data) {
		this.data = data;
	}
	
	public void setNext(ListElement<T> next) {
		this.next = next;
	}
}
