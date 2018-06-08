package com.company.converters;

import com.company.Leaf;

import java.util.Map;
import java.util.PriorityQueue;

public class QueueCreator {
	private final PriorityQueue<Leaf> leafsQueue = new PriorityQueue<>();

	private QueueCreator() {
	}

	public PriorityQueue<Leaf> createQueue(Map<Character, Integer> mapWithFrequency) {
		for (Map.Entry<Character, Integer> entry : mapWithFrequency.entrySet()) {
			Leaf leaf = new Leaf(entry.getKey(), entry.getValue());
			this.leafsQueue.add(leaf);
		}

		return this.leafsQueue;
	}

	public static QueueCreator run() {
		return new QueueCreator();
	}
}
