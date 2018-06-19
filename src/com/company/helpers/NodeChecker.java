package com.company.helpers;

import com.company.nodes.Node;

import java.util.HashSet;
import java.util.List;

public class NodeChecker {
	private final HashSet<Node> nodesForTable = new HashSet<>();

	private NodeChecker() {
	}

	public HashSet<Node> checkNodes(List<Node> nodeList) {
		for (Node q : nodeList) {
			checkChild(q);
		}

		return this.nodesForTable;
	}

	private void checkChild(Node childForChecking) {

		if (childForChecking.getRightChild() != null) {
			Node currentChild = childForChecking.getRightChild();
			this.nodesForTable.add(currentChild);

			checkChild(currentChild);
		}

		if (childForChecking.getLeftChild() != null) {
			Node currentChild = childForChecking.getLeftChild();
			this.nodesForTable.add(currentChild);

			checkChild(currentChild);
		}
	}

	public static NodeChecker run() {
		return new NodeChecker();
	}
}
