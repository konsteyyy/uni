package com.konsteyyy.git.uni.dea.rucksack;

import java.util.Arrays;

public class RucksackProblem {
	float upperBound;
	float lowerBound;
	
	public void solveProblem(int[] werte, int[] gewichte, int K) {
		if(werte == null||gewichte==null||K<=0) return;
		
		double[] ratio = new double[werte.length];
		for(int i=0; i<ratio.length; i++) {
			ratio[i] = werte[i] / gewichte[i];
		}
		
		Arrays.sort(ratio);
	}
}
