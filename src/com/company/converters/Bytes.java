package com.company.converters;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Bytes {
	private Bytes() {
	}

	public List<Byte> toBytes(String path) {
		List<Byte> bytesArray = new ArrayList<>();
		String str;

		try (BufferedReader bufReader = new BufferedReader(new FileReader(new File(path)))) {
			while ((str = bufReader.readLine()) != null) {
				byte[] bytes = str.getBytes();

				for (byte aByte : bytes) {
					bytesArray.add(aByte);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return bytesArray;
	}

	public static Bytes converter() {
		return new Bytes();
	}
}
