package com.company.nodes;

import static java.lang.Integer.compare;

public class Node implements Comparable<Node> {
	private int weight;
	private Character symbol;
	private String code;

	public Node(Character symbol, int weight) {
		this.symbol = symbol;
		this.weight = weight;
	}

	Node(int weight) {
		this.weight = weight;
	}

	private void setCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	int getWeight() {
		return weight;
	}

	public Character getSymbol() {
		return symbol;
	}

	public void createCode(String code) {
		setCode(code);
	}

	@Override
	public int compareTo(Node node) {
		return compare(this.getWeight(), node.getWeight());
	}
}