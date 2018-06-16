package com.company.converters;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ListCreator {

	public List<Character> createList(String path) {
		List<Character> eachSymbol = new ArrayList<>();
		try (BufferedReader stream = new BufferedReader(new FileReader(new File(path)))) {
			int ch;
			while ((ch = stream.read()) > -1) {
				char ch1 = (char) ch;
				eachSymbol.add(ch1);
			}
		} catch (IOException e) {
			System.out.println(e + " - ERROR");
		}
		return eachSymbol;
	}

	public static ListCreator converter() {
		return new ListCreator();
	}
}
