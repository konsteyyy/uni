package com.konsteyyy.git.uni.dea.stack;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class IdentifyBrackets {
	public static void main(String[] args) throws FileNotFoundException {
		String file = args[0];
		Scanner sc = new Scanner(new File(file));
		
		ArrayList<Character> list = new ArrayList<Character>();
		
		for(int i = 0; sc.hasNext(); i++) {
			list.add(sc.next().charAt(0));
		}
		
	}
}
