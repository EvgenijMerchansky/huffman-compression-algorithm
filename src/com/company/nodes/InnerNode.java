package com.company.nodes;

public class InnerNode extends Node {
	private final Node leftChild;
	private final Node rightChild;
	private final Character symbol;

	public InnerNode(Character symbol, Node left, Node right) {
		super(left.getWeight() + right.getWeight());
		this.leftChild = left;
		this.rightChild = right;
		this.symbol = symbol;
	}

	@Override
	public Character getSymbol() {
		return symbol;
	}

	@Override
	public void createCode(String code) {
		super.createCode(code);
		this.leftChild.createCode(code + "0");
		this.rightChild.createCode(code + "1");
	}
}