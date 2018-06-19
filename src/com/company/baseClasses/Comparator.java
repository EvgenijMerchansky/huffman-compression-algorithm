package com.company.baseClasses;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;

public class Comparator {
	private Comparator() {
	}

	void compareStringWithTable(List<String> string, HashSet<String> table) {
		try (FileWriter fileWriter = new FileWriter(new File("decompressed.test.txt"))) {
			for (String aString : string) {
				for (String tableItem : table) {
					String[] splittedItem = tableItem.split(":");
					if (splittedItem.length > 1) {
						String code = splittedItem[1];
						String symbol = splittedItem[0];
						String codeFromString = aString;
						if (code.equals(codeFromString)) {
							try {
								fileWriter.write(symbol);
								fileWriter.flush();
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					} else {
						fileWriter.write(splittedItem[0]);
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Comparator run() {
		return new Comparator();
	}
}
