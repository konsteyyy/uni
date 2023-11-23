package com.konsteyyy.git.uni.dea.rucksack;

public class Item implements Comparable<Item>{
	private int weight;
	private int value;
	private double ratio;
	
	public Item(int value, int weight) {
		this.value = value;
		this.weight = weight;
		this.ratio = (double) value/weight;
	}

	public int getWeight() {return weight;}

	public void setWeight(int weight) {this.weight = weight;}

	public int getValue() {return value;}

	public void setValue(int value) {this.value = value;}

	public double getRatio() {return ratio;}
	
	public void setRatio(double ratio) {this.ratio = ratio;}
	
	@Override
	public int compareTo(Item o) {
		return Double.compare(ratio, o.ratio);
	}
}
