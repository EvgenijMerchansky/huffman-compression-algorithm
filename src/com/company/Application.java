package com.company;

import com.company.converters.QueueCreator;
import com.company.converters.Strings;
import com.company.nodes.Node;

import java.util.Map;
import java.util.PriorityQueue;

import static com.company.converters.SymbolMapper.converter;

class Application { // shift + fn + f6 (fast editing)
	private Application() {
	}

	void run(String[] args) {
		final String COMPRESS = "--compress";
		final String DECOMPRESS = "--decompress";

		final String mode = args[0];
		final String file = args[1]; // for `decompress` will be another file.
		switch (mode) {
			case COMPRESS:
				// todo: make Qap list {key: value}
				final Map<Character, Integer> charactersListWithFrequency = converter().toCharacters(file);
				// todo: make PriorityQueue for Leafs {symbol: weight} - should be sorted z -> a
				final PriorityQueue<Node> nodes = QueueCreator.run().createQueue(charactersListWithFrequency);
				// todo: make Binary tree with our leafs
				final PriorityQueue<Node> tree = Tree.run().makeTree(nodes);
				System.out.println(tree + " : tree");
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
