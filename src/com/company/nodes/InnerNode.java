package com.company.nodes;

public class InnerNode extends Node {
	private final Node leftChild;
	private final Node rightChild;
	private final Character symbol;
	private String code;

	public InnerNode(Character symbol, Node left, Node right) {
		super(left.getWeight() + right.getWeight());
		this.leftChild = left;
		this.rightChild = right;
		this.symbol = symbol;
	}

	@Override
	public String getCode() {
		return code;
	}

	@Override
	public Character getSymbol() {
		return symbol;
	}

	@Override
	public Node getLeftChild() {
		return this.leftChild;
	}

	@Override
	public Node getRightChild() {
		return this.rightChild;
	}

	@Override
	public void createCode(String code) {
		super.createCode(code);
		this.code = code;
		this.leftChild.createCode(code + "0");
		this.rightChild.createCode(code + "1");
	}
}