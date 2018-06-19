package com.company.fileManager;

import com.company.nodes.Node;

import java.io.*;
import java.util.HashSet;

public class WriteManager {
	private WriteManager() {
	}

	public void writeTable(HashSet<Node> tableList, String fileName) {
		try (FileWriter fileWriter = new FileWriter(new File(fileName))) {
			for (Node node : tableList) {
				fileWriter.write(node.getSymbol() + ":" + node.getCode() + "\n");
				fileWriter.flush();
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	public void writeString(String tablePath, String outputFileName) {
		final StringBuilder result = new StringBuilder();
		try (
			BufferedReader reader = new BufferedReader(new FileReader(tablePath));
			BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))
		) {
			while ((reader.read()) > -1) {
				result.append(reader.readLine().replaceAll("[^0-9]", "")).append(" ");
			}

			writer.write(result.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static WriteManager run() {
		return new WriteManager();
	}
}
