package com.company.nodes;

import com.company.TreeTable;

import java.util.HashMap;

import static java.lang.Integer.compare;

public class Node implements Comparable<Node> {
	private HashMap<Character, String> hmap = new HashMap<>();
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

	private String getCode() {
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
		TreeTable.run().makeTable(this.getSymbol(), this.getCode()); // in separate method!
	}

	@Override
	public int compareTo(Node node) {
		return compare(this.getWeight(), node.getWeight());
	}
}