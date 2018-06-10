package com.company;

import com.company.converters.QueueCreator;
import com.company.converters.Strings;

import java.util.Map;
import java.util.PriorityQueue;

import static com.company.converters.SymbolMapper.converter;

class Application {
	private Application() {
	}

	void run(String[] args) {
		final String mode = args[0];
		final String file = args[1]; // for `decompress` will be another file.
		switch (mode) {
			case "--compress":
				// todo: make Qap list {key: value}
				final Map<Character, Integer> mapWithFrequency = converter().toCharacters(file);
				// todo: make PriorityQueue for Leafs {symbol: weight} - should be sorted z -> a
				final PriorityQueue<Node> sortedNodes = QueueCreator.run().createQueue(mapWithFrequency);
				// todo: make Binary tree with our leafs
				PriorityQueue<Node> nodes = Tree.run().makeTree(sortedNodes); // 1 element (ONE NODE)
				for (Node node : nodes) {
					System.out.println(node.getWeight());
				}
				// todo: print tree:


				break;
			case "--decompress":
				// todo: make instance for file unpacking
				String decompressedString = Strings.converter().toString(file);
				System.out.println(decompressedString);
				// can use toBytesArray method for getting bytes array from `compressed file`.
				break;
		}
	}

//	void makeTree(){
//		System.out.println(this.);
//	}

	static Application instance() {
		return new Application();
	}
}
