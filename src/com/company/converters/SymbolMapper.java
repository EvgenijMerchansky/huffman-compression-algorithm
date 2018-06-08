package com.company.converters;

import java.io.*;
import java.util.*;
import java.lang.Character;

public class SymbolMapper {
	private SymbolMapper() {
	}

	public Map<Character, Integer> toCharacters(String path) {
		Map<Character, Integer> map = new HashMap<>();

		try (BufferedReader stream = new BufferedReader(new FileReader(new File(path)))) {
			int ch;
			while ((ch = stream.read())> -1) {
				char ch1 = (char) ch;

				if (map.containsKey(ch1)) {
					map.put(ch1, map.get(ch1) + 1);
				} else {
					map.put(ch1, 1);
				}
			}
		} catch (IOException e) {
			System.out.println(e + " - ERROR");
		}

		return map;
	}

	public static SymbolMapper converter() {
		return new SymbolMapper();
	}
}
