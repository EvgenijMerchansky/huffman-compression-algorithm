package com.company;

import com.company.converters.QueueCreator;
import com.company.converters.Strings;
import com.company.helpers.Names;
import com.company.nodes.Node;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import static com.company.converters.SymbolMapper.converter;

class Application { // shift + fn + f6 (fast editing)
	private Application() {
	}

	void run(String[] args) {
		final String mode = args[0];
		final String file = args[1];
		final String COMPRESS = "--compress";
		final String DECOMPRESS = "--decompress";
		final String OUTPUT_FILE_NAME = Names.run().createOutputFileName(file);
		final String TABLE_FILE_PATH = Names.run().getMetaTablePath();

		switch (mode) {
			case COMPRESS:
				// todo: make Qap list {key: value}
				final Map<Character, Integer> charactersListWithFrequency = converter().toCharacters(file);
				// todo: make PriorityQueue for Leafs {symbol: weight} - should be sorted z -> a
				final PriorityQueue<Node> nodes = QueueCreator.run().createQueue(charactersListWithFrequency);
				// todo: make Binary tree witch return nodes list NODE { getKey() // z, getCode // 1001101 }
				final List<Node> listForTable = Tree.run().getListForTable(nodes);
				// todo: make mapped table from nodes list
				final HashMap<Character, String> mappedTable = Table.run().convertToMap(listForTable);
				// todo: write mapped table to separate file
				WriteManager.run().writeTable(mappedTable, TABLE_FILE_PATH);
				// todo: make binary string from mapped table and write it in separate file
				String compressedFile = WriteManager.run().writeString(TABLE_FILE_PATH, OUTPUT_FILE_NAME);

				break;
			case DECOMPRESS:
				// todo: make instance for file unpacking
				String decompressedString = Strings.converter().toString(file);
				System.out.println(decompressedString);
				// can use toBytesArray method for getting bytes array from `compressed file`.
				break;
			default:
				System.out.println("Invalid flag parameter");
		}
	}

	static Application instance() {
		return new Application();
	}
}
