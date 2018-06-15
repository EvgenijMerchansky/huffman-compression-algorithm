package com.company;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

class WriteManager {
	private WriteManager() {
	}

	void writeTable(HashMap<Character, String> mappedTable, String fileName) {
		try (FileWriter fileWriter = new FileWriter(new File(fileName))){
			String str = "";

			for (Map.Entry<Character, String> entry : mappedTable.entrySet()) {
				str = str + entry.getValue();
				fileWriter.write(entry + "\n");
				fileWriter.flush();
			}

			System.out.println(str);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	void writeString(HashMap<Character, String> mappedTable, String outputFileName) {

		for (Map.Entry<Character, String> entry : mappedTable.entrySet()) {
			try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {
				final StringBuilder result = new StringBuilder();
				final byte[] cArray = entry.getValue().getBytes();

				for (byte b : cArray) {
					for (int i = 0; i < 8; i++) {
						result.append((b >> (8 - (i + 1)) & 0x0001));
					}
					writer.write(result.toString());
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	static WriteManager run() {
		return new WriteManager();
	}
}
