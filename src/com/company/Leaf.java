package com.company;

public class Leaf implements Comparable<Leaf> {
	private Character symbol;
	private int weight;

	public Leaf(Character symbol, int weight) {
		this.symbol = symbol;
		this.weight = weight;
	}

	Character getSymbol() throws NullPointerException {
		return symbol;
	}

	int getWeight() throws NullPointerException {
		return weight;
	}

	@Override
	public int compareTo(Leaf leaf) {
		return Integer.compare(this.getWeight(), leaf.getWeight());
	}
}
