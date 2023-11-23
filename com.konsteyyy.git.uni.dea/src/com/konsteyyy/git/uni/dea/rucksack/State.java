package com.konsteyyy.git.uni.dea.rucksack;

public class State implements Comparable<State> {
	private int profit;
	private int weight;
	private int bound;
	private int level;
	
	public State() {}
	
	public State(State other) {
		this(other.getProfit(), other.getWeight(), other.getBound(), other.getLevel());
	}
	
	public State(int profit, int weight, int bound, int level) {
		this.profit = profit;
		this.weight = weight;
		this.bound = bound;
		this.level = level;
	}

	public int getProfit() {
		return profit;
	}

	public void setProfit(int profit) {
		this.profit = profit;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getBound() {
		return bound;
	}

	public void setBound(int bound) {
		this.bound = bound;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	@Override
	public int compareTo(State o) {
		return Double.compare(this.bound, o.getBound());
	}
	
}
