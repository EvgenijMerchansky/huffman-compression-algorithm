package com.company;

public class Node {
	private int weight;
	private String symbol;

	Node(String symbol, int weight) {
		this.symbol = symbol;
		this.weight = weight;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
}
