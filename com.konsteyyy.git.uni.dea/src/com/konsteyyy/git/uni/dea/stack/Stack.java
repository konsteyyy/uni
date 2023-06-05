package com.konsteyyy.git.uni.dea.stack;

public class Stack<T> {
	
	private StackNode<T> topElement;
	private int counter;
	
	public Stack() {
		this.counter=0;
	}
	
	public Stack(StackNode<T> topElement) {
		this.topElement = topElement;
		this.counter=0;
	}
	
	public void push(T t) {
		StackNode<T> newElement = new StackNode<T>(t);
		newElement.setNext(topElement);
		newElement = topElement;
		counter++;
	}
	
	public void pop() throws StackIsEmptyException {
		if(!isEmpty()) {
			topElement = topElement.getNext();
			counter--;
		} else {
			throw new StackIsEmptyException();
		}
	}
	
	public T top() {
		return topElement.getData();
	}
	
	public boolean isEmpty() {
		return topElement == null;
	}
	
	public int size() {
		return counter;
	}
}
