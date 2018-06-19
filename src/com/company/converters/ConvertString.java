package com.company.converters;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConvertString {
	private ConvertString() {
	}

	public List<String> toArray(String path) {
		List<String> codes = new ArrayList<>();
		try (BufferedReader stream = new BufferedReader(new FileReader(new File(path)))) {
			String[] codesArray = stream.readLine().split(" ");
			codes.addAll(Arrays.asList(codesArray));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return codes;
	}

	public static ConvertString converter() {
		return new ConvertString();
	}
}
