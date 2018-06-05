package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Application {
	private Application() {
	}

	void run(String[] args) {
		String mode = args[0];
		String filePath = args[1]; // for `uncompress` will be another file.
		switch (mode) {
			case "--compress":
				// todo: make instance for file compress
				List<Byte> bytesFromFile = toBytesArray(filePath);
				System.out.println(bytesFromFile);
				break;
			case "--uncompress":
				// todo: make instance for file unpacking
				// can use toBytesArray method for getting bytes array from `compressed file`.
				break;
		}
	}

	private List<Byte> toBytesArray(String path) {
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

	static Application instance() {
		return new Application();
	}
}
