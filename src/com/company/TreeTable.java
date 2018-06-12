package com.company;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class TreeTable {
	private final HashMap<Character, String> hmap = new HashMap<>();
	private final String OUTPUT_FILE_NAME = "test.compressed.txt"; // fix this

	private TreeTable() {
	}

	public void makeTable(Character character, String code) {
		hmap.put(character, code);
		compressToString(); // make table for decompress mode
	}

	private void compressToString() {
		FileOutputStream fos = null;
		ByteArrayOutputStream baos = null;
		DataOutputStream dos = null;

		for (Map.Entry<Character, String> entry : hmap.entrySet()) {
			byte[] cArray = entry.getValue().getBytes();

			try {
				fos = new FileOutputStream(OUTPUT_FILE_NAME);
				baos = new ByteArrayOutputStream();
				dos = new DataOutputStream(baos);

				for (byte b : cArray) {
					for (byte m = 1; m != 0; m <<= 1) {
						int bit = ((b & m) != 0) ? 1 : 0;
						dos.writeByte(bit);
					}
				}

				dos.flush();
				dos.close();

				for (byte b : baos.toByteArray()) {
					fos.write(b);
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static TreeTable run() {
		return new TreeTable();
	}
}
