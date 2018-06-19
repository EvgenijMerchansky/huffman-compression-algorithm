package com.company.baseClasses;

import com.company.nodes.InnerNode;
import com.company.nodes.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Tree {
	private Tree() {
	}

	List<Node> getListForTable(PriorityQueue<Node> nodes) {
		final List<Node> tableValues = new ArrayList<>();
		while (nodes.size() > 1) {
			Node first = nodes.poll();
			Node second = nodes.poll();
			Character symbol = null;
			if (nodes.peek() != null) {
				symbol = nodes.peek().getSymbol();
			}
			Node parentNode = new InnerNode(symbol, first, second);
			nodes.add(parentNode);
			tableValues.add(parentNode);
		}

		Node root = nodes.poll();
		assert root != null;
		root.createCode("");
		nodes.add(root);

		return tableValues;
	}

	static Tree run() {
		return new Tree();
	}
}
