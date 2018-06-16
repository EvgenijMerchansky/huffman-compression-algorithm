package com.company;

import java.io.*;
import java.util.HashMap;

class DecompressedFile {
	void compareWithTable(String tablePath, String compressedStringPath) {

		try (
			BufferedReader reader = new BufferedReader(new FileReader(tablePath));
			BufferedReader stream = new BufferedReader(new FileReader(new File(compressedStringPath)))
		) {
			HashMap<Character, String> mapa = new HashMap<>();

			while ((reader.read()) > -1) {
				String[] a = reader.readLine().split("=", 2);
				mapa.put((char) a[0].indexOf(0), a[1]);

//				System.out.println(mapa);
//				for (Character c: mapa.keySet()) {
//					String value = mapa.get(c);
//					System.out.println(value);
//				}
			}

			System.out.println(stream.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static DecompressedFile run() {
		return new DecompressedFile();
	}
}
