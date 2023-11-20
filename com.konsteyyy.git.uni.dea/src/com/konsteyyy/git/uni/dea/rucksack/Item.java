package com.konsteyyy.git.uni.dea.rucksack;

public class Item implements Comparable<Item>{
	private double weight;
	private double value;
	private double ratio;
	
	public Item(double value, double weight) {
		this.value = value;
		this.weight = weight;
		this.ratio = value/weight;
	}

	public double getWeight() {return weight;}

	public void setWeight(double weight) {this.weight = weight;}

	public double getValue() {return value;}

	public void setValue(double value) {this.value = value;}

	public double getRatio() {return ratio;}
	
	public void setRatio(double ratio) {this.ratio = ratio;}
	
	@Override
	public int compareTo(Item o) {
		return Double.compare(ratio, o.ratio);
	}
}
