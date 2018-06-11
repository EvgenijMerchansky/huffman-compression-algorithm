package com.company;

import java.util.PriorityQueue;

class Tree {
	PriorityQueue<Node> makeTree(PriorityQueue<Node> nodes) {
		boolean iterator = nodes.size() != 1;
		int count = 0;

		while (iterator) {
			boolean sizeCondition = nodes.size() > 2;

			final Node last1 = nodes.poll();
			final Node last2 = nodes.poll();
			final Node parent = nodes.peek();
			assert parent != null;

			if (sizeCondition && last1 != null && last2 != null) {
				nodes.add(makeNewNode(count, last1, last2, parent.getSymbol()));
			} else {
				nodes.add(makeRootNode(count, last1, last2));
			}

			if (!sizeCondition) iterator = false;
		}

		return nodes;
	}

	private Node makeNewNode(int count, Node left, Node right, Character symbol) { // todo: make this one with symbol key and '1001011' - value
		left.setCode("0");
		right.setCode("1");
// 		new Table().makeTable(count,new Node(
//			left,
//			right,
//			left.getWeight() + right.getWeight()
//		));
		return new Node(
			left,
			right,
			left.getWeight() + right.getWeight(),
			symbol
		);
	}

	private Node makeRootNode(int count, Node left, Node right) {
		left.setCode("0");
		right.setCode("1");

		return new Node(
			left,
			right,
			left.getWeight() + right.getWeight()
		);
	}

	private Tree() {
	}

	static Tree run() {
		return new Tree();
	}
}
