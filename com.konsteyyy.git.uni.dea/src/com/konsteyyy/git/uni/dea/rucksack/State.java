package com.konsteyyy.git.uni.dea.rucksack;

import java.util.LinkedList;

public class State implements Comparable<State> {
	private LinkedList<Item> items;
	private int weight; 
	private double upperBound;
	private int level; //gibt an wieviele Objekte bereits betrachtet wurden
	private boolean validSolution;
	
	public State() {}
	public State(LinkedList<Item> items) {
		this.items = items;
		this.weight =0;
		this.upperBound =0;
		for(Item i:items) {
			this.weight+=i.getWeight();
			this.upperBound+=i.getValue();
		}
	}

	public LinkedList<Item> getItems() {
		return items;
	}
	public void setItems(LinkedList<Item> items) {
		this.items = items;
	}
	
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public double getUpperBound() {
		return upperBound;
	}
	public void setUpperBound(double upperBound) {
		this.upperBound = upperBound;
	}
	
	public boolean isValidSolution() {
		return validSolution;
	}
	public void setValidSolution(boolean validSolution) {
		this.validSolution = validSolution;
	}
	
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	@Override
	public int compareTo(State o) {
		return Double.compare(this.upperBound, o.getUpperBound());
	}
	
}
