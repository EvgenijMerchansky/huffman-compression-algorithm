package com.company;

public class Node implements Comparable<Node> {
	private Node left;
	private Node right;
	private int weight;
	private Character symbol;
	private String code;

	Node(Node left, Node right, int weight, Character symbol) {
		this.left = left;
		this.right = right;
		this.weight = weight;
		this.symbol = symbol;
	}

	Node(Node left, Node right, int weight) {
		this.left = left;
		this.right = right;
		this.weight = weight;
	}

	public Node(Character symbol, int weight) { // todo: add count property
		this.weight = weight;
		this.symbol = symbol;
	}

	Character getSymbol() {
		try {
			return symbol;
		} catch (NullPointerException e) {
			System.out.println("OOps");
			return '0';
		}
	}

	void setCode(String code) {
		this.code = code;
	}

	public void setSymbol(Character symbol) {
		this.symbol = symbol;
	}

	int getWeight() {
		return weight;
	}

	Node getLeft() {
		return left;
	}

	Node getRight() {
		return right;
	}

	@Override
	public int compareTo(Node node) {
		return Integer.compare(this.getWeight(), node.getWeight());
	}
}
