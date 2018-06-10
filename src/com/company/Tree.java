package com.company;

import java.util.PriorityQueue;

class Tree {
	PriorityQueue<Node> makeTree(PriorityQueue<Node> nodes) {
		boolean iterator = nodes.size() != 0;
		int count = 0;
		while (iterator) {
			if (nodes.size() > 1) {
				final Node lastNode = nodes.poll();
				final Node preLastNode = nodes.poll();

				nodes.add(makeNewNode(count, lastNode, preLastNode));
			} else {
				iterator = false;
			}
		}
		return nodes;
	}

	private Node makeNewNode(int count, Node left, Node right) { // todo: make this one with symbol key and '1001011' - value
//		new Table().makeTable(count,new Node(
//			left,
//			right,
//			left.getWeight() + right.getWeight()
//		));
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
