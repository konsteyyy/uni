package com.konsteyyy.git.uni.dea;

public class ListTest {

	public static void main(String[] args) {
		SList<Integer> test = new SList<Integer>();
		test.append(10);
		test.append(12);
		test.append(35);
		
		System.out.println(test.toString());
		
		test.delete(2);
		System.out.println(test.toString());
		
		
	}

}
