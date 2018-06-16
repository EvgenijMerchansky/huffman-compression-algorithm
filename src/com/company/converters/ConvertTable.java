package com.company.converters;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class ConvertTable {
	public Map<String, String> compareWithTable(String tablePath) {
		Map<String, String> table = new HashMap<>();
		File file = new File(tablePath);
		try (FileReader fr = new FileReader(file)) {
			BufferedReader br = new BufferedReader(fr);
			String line;
			while((line = br.readLine()) != null){
				String[] arrays = line.split("=");
				if (arrays.length > 1) {
					table.put(arrays[0], arrays[1]);
				}
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return table;
	}

	public static ConvertTable run() {
		return new ConvertTable();
	}
}
