package com.company.converters;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class ConvertTable {
	public HashSet<String> convert(String tablePath) {
		HashSet<String> table = new HashSet<>();
		try (BufferedReader br = new BufferedReader(new FileReader(new File(tablePath)))) {
			String line;
			while((line = br.readLine()) != null){
				String[] arrays = line.split(":");
				if (arrays.length == 1) {
					table.add(" ");
				}  else {
					table.add(arrays[0] + ":" + arrays[1]);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return table;
	}

	public static ConvertTable run() {
		return new ConvertTable();
	}
}
