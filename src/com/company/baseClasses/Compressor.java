package com.company.baseClasses;

import com.company.fileManager.WriteManager;
import com.company.annotations.Collections;
import com.company.annotations.CompressorAnnotation;
import com.company.converters.QueueCreator;
import com.company.helpers.NodeChecker;
import com.company.nodes.Node;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import static com.company.converters.SymbolMapper.converter;


public class Compressor {
	private Compressor() {
	}

	@CompressorAnnotation(description = "Method witch compress input file")
	public void compress(
		String file,
		String TABLE_FILE_PATH,
		String OUTPUT_FILE_NAME
	) {
		@Collections(description = "make Qap list {key: value}")
		final Map<Character, Integer> charactersListWithFrequency = converter().toCharacters(file);

		@Collections(description = "make PriorityQueue for Leafs {symbol: weight} - should be sorted z -> a")
		final PriorityQueue<Node> nodes = QueueCreator.run().createQueue(charactersListWithFrequency);

		@Collections(description = "make Binary tree witch return nodes list NODE { getKey() // z, getCode // 1001101 }")
		final List<Node> listForTable = Tree.run().getListForTable(nodes);

		@Collections(description = "check all nodes(parents and child)")
		final HashSet<Node> checkedList = NodeChecker.run().checkNodes(listForTable);

		WriteManager.run().writeTable(checkedList, TABLE_FILE_PATH);
		WriteManager.run().writeString(TABLE_FILE_PATH, OUTPUT_FILE_NAME);
	}

	public static Compressor run() {
		return new Compressor();
	}
}
