package com.company.converters;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Strings {
	private Strings() {
	}

	public String toString(String file) {
//		List<Byte> bytesArray = new ArrayList<>();
//		String str;
//
//		try (BufferedReader bufReader = new BufferedReader(new FileReader(new File(path)))) {
//			while ((str = bufReader.readLine()) != null) {
//				byte[] bytes = str.getBytes();
//
//				for (byte aByte : bytes) {
//					bytesArray.add(aByte);
//				}
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

		return file;
	}

	public static Strings converter() {
		return new Strings();
	}
}
