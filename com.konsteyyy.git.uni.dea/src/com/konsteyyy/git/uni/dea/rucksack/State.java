package com.konsteyyy.git.uni.dea.rucksack;

public class State implements Comparable<State> {
	private double[] x;
	private double upperBound;
	
	public State() {}
	
	public State(double upperBound) {
		this.upperBound = upperBound;
	}

	public double[] getX() {
		return x;
	}

	public void setX(double[] x) {
		this.x = x;
	}
	
	public double getUpperBound() {
		return upperBound;
	}

	public void setUpperBound(double upperBound) {
		this.upperBound = upperBound;
	}

	@Override
	public int compareTo(State o) {
		return Double.compare(this.upperBound, o.getUpperBound());
	}
	
}
