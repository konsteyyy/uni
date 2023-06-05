package com.konsteyyy.git.uni.dea.list;

public class DListElement<T> {
	private T data;
	private DListElement<T> prev;
	private DListElement<T> next;
	
	public DListElement() {
		
	}
	public DListElement(T data) {
		this.data = data;
	}
	
	public DListElement(T data, DListElement<T> prev, DListElement<T> next) {
		this.data = data;
		this.prev = prev;
		this.next = next;
	}
	
	public T getData() {
		return this.data;
	}
	
	public DListElement<T> getNext() {
		return this.next;
	}
	
	public DListElement<T> getPrev() {
		return this.prev;
	}
	
	public void setData(T data) {
		this.data = data;
	}
	
	public void setNext(DListElement<T> next) {
		this.next = next;
	}
	
	public void setPrev(DListElement<T> prev) {
		this.prev = prev;
	}
}
