package com.company.converters;

import com.company.nodes.Node;

import java.util.HashMap;
import java.util.List;

public class TableCreator {
	private final HashMap<Character, String> map = new HashMap<>();

	private TableCreator() {
	}

	public HashMap<Character, String> createMappedTable(List<Node> listForMap) {
		for (Node node : listForMap) {
			map.put(node.getSymbol(), node.getCode());
		}
		return this.map;
	}


	public static TableCreator run() {
		return new TableCreator();
	}
}
