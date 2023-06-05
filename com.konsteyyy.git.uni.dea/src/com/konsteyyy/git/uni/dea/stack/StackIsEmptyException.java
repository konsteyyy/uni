package com.konsteyyy.git.uni.dea.stack;

public class StackIsEmptyException extends Exception {

		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StackIsEmptyException() {
		super("Stack is empty, you can't pop it!");
	}
}
