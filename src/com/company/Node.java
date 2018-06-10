package com.company;

public class Node implements Comparable<Node> {
	private Node left;
	private Node right;
	private int weight;

	Node(Node left, Node right, int weight) {
		this.left = left;
		this.right = right;
		this.weight = weight;
	}

	public Node(Character symbol, int weight) {
		this.weight = weight;
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
