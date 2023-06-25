package com.konsteyyy.git.uni.dea.radixsort;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class RadixSort {

    public static void sort(int[] A) {
    	
    	//1. Schritt: Richte eine Queue Q ein und füge A1, . . . , An in Q ein.
        Queue<Integer> queue = new LinkedList<>();

        for (int a : A) {
            queue.add(a);
        }

        //2. Schritt: Richte ein Array Bucket von N Buckets ein (wie beim einfachen Bucketsort).
        int N = Arrays.stream(A).max().getAsInt();
        int[][] buckets = new int[N + 1][0];
        
        //3. Schritt: for Stelle r ← k downto 1 do
        int k = 32;
        for (int r = k; r > 0; r--) {

            // 3.1 alle Buckets leeren
            for (int i = 0; i <= N; i++) {
                buckets[i] = new int[0];
            }
            
            // 3.2 while Q nicht leer ist do
            while (!queue.isEmpty()) {
            	// sei A_j das erste Element in Q
                int currentInteger = queue.peek();
                
                //entferne A_j aus Q
                queue.poll();
                int bucketIndex = selectBitAtPosition(currentInteger, r);

                // füge in die entsprechenden Buckets ein
                int[] temp = new int[buckets[bucketIndex].length + 1];
                System.arraycopy(buckets[bucketIndex], 0, temp, 0, buckets[bucketIndex].length);
                temp[temp.length - 1] = currentInteger;
                buckets[bucketIndex] = temp;
            }
            
            // 3.3 Konkateniere die nichtleeren Buckets in die queue
            for (int[] bucket : buckets) {
                if (bucket != null) {
                    for (int j : bucket) {
                        queue.add(j);
                    }
                }
            }
        }
        
        // schreib den Inhalt der queue zurück in den Array
        int index = 0;
        while (!queue.isEmpty()) {
            A[index++] = queue.poll();
        }
    }

    public static int selectBitAtPosition(int a, int i) {
        return (a >> (32 - i - 1)) & 1;
    }

    public static void main(String[] args) throws FileNotFoundException {
        String file = args[0];
        ArrayList<Integer> list = new ArrayList<>();

        // scan file and add all int to list
        Scanner sc = new Scanner(new File(file));
        while (sc.hasNextInt()) {
            list.add(sc.nextInt());
        }

        // convert the list into an array
        int[] array = new int[list.size()];
        for (int i = 0; i < array.length; i++) {
            array[i] = list.get(i);
        }

        long start = System.currentTimeMillis();
        sort(array);
        long ende = System.currentTimeMillis();

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

        System.out.println("Benötigte Zeit:" + (ende - start));
    }
}
