package com.company.converters;

import com.company.Node;

import java.util.Map;
import java.util.PriorityQueue;

public class QueueCreator {
	private final PriorityQueue<Node> leafsQueue = new PriorityQueue<>();

	private QueueCreator() {
	}

	public PriorityQueue<Node> createQueue(Map<Character, Integer> mapWithFrequency) {
		for (Map.Entry<Character, Integer> entry : mapWithFrequency.entrySet()) {
//			System.out.println(entry.getKey());
			Node node = new Node(entry.getKey(), entry.getValue());
//			System.out.println(node.getSymbol());
			this.leafsQueue.add(node);
		}

		return this.leafsQueue;
	}

	public static QueueCreator run() {
		return new QueueCreator();
	}
}
