package com.company;

import com.company.converters.TableCreator;
import com.company.nodes.Node;

import java.util.HashMap;
import java.util.List;

class Table {
	private Table() {
	}

	HashMap<Character, String> convertToMap(List<Node> list) {
		return TableCreator.run().createMappedTable(list);
	}

	static Table run() {
		return new Table();
	}
}
