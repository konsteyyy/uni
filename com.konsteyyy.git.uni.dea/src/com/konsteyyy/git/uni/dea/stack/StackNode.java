package com.konsteyyy.git.uni.dea.stack;

public class StackNode<T> {
	private T data;
	private StackNode<T> next;
	
	public StackNode() {
		
	}
	
	public StackNode(T data) {
		this.setData(data);
	}
	
	public StackNode(T data, StackNode<T> next) {
		this.setData(data);
		this.setNext(next);
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public StackNode<T> getNext() {
		return next;
	}

	public void setNext(StackNode<T> next) {
		this.next = next;
	}
}
