package com.company;

import java.util.PriorityQueue;

class Tree {
	private Tree() {
	}

	PriorityQueue<Leaf> treeMaker(PriorityQueue<Leaf> leafs) {
		boolean iterator = leafs.size() != 0;
		while (iterator) {
			final Leaf lastNode = leafs.poll();
			final Leaf preLastNode = leafs.poll();
			// todo: fix getSymbol() (with exception) and getWeight() (with exception);
			if (leafs.size() > 0) {
				Character parentSymbol = leafs.poll().getSymbol();
				leafs.add(new Leaf(parentSymbol, lastNode.getWeight() + preLastNode.getWeight()));
			} else {
				leafs.add(new Leaf('^', lastNode.getWeight() + preLastNode.getWeight()));
				iterator = false;
			}
		}

		return leafs;
	}

	static Tree run() {
			return new Tree();
	}
}
