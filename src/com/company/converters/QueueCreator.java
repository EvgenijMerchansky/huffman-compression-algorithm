package com.company.converters;

import com.company.nodes.Node;

import java.util.Map;
import java.util.PriorityQueue;

public class QueueCreator {
	private final PriorityQueue<Node> leafsQueue = new PriorityQueue<>();

	private QueueCreator() {
	}

	public PriorityQueue<Node> createQueue(Map<Character, Integer> mapWithFrequency) {
		for (Map.Entry<Character, Integer> entry : mapWithFrequency.entrySet()) {
			Node node = new Node(entry.getKey(), entry.getValue());

			this.leafsQueue.add(node);
		}

		return this.leafsQueue;
	}

	public static QueueCreator run() {
		return new QueueCreator();
	}
}
