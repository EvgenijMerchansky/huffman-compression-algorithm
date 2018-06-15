package com.company;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

class WriteManager {
	private WriteManager() {
	}

	void writeTable(HashMap<Character, String> mappedTable, String fileName) {
		try (FileWriter fileWriter = new FileWriter(new File(fileName))){
			for (Map.Entry<Character, String> entry : mappedTable.entrySet()) {
				fileWriter.write(entry + "\n");
				fileWriter.flush();
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	String writeString(String tablePath, String outputFileName) {
		final StringBuilder result = new StringBuilder();
		try (
			BufferedReader reader = new BufferedReader(new FileReader(tablePath));
			BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))
		) {

			while ((reader.read()) > -1) {
				result.append(reader.readLine().replaceAll("[^0-9]", ""));
			}

			writer.write(result.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return result.toString(); // todo: rebuild this one to bytes!

//		for (Map.Entry<Character, String> entry : mappedTable.entrySet()) {
//			try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {
//				final StringBuilder result = new StringBuilder();
//				final byte[] cArray = entry.getValue().getBytes();
//
//				for (byte b : cArray) {
//					for (int i = 0; i < 8; i++) {
//						result.append((b >> (8 - (i + 1)) & 0x0001));
//					}
//					writer.write(result.toString());
//				}
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
	}

	static WriteManager run() {
		return new WriteManager();
	}
}
