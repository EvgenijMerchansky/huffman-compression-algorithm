package com.company;

import com.company.converters.Strings;

import java.util.List;

import static com.company.converters.Bytes.converter;

class Application {
	private Application() {
	}

	void run(String[] args) {
		final String mode = args[0];
		final String file = args[1]; // for `decompress` will be another file.
		switch (mode) {
			case "--compress":
				// todo: make instance for file compress
				List<Byte> bytesList = converter().toBytes(file);
				System.out.println(bytesList);
				break;
			case "--decompress":
				// todo: make instance for file unpacking
				String decompressedString = Strings.converter().toString(file);
				System.out.println(decompressedString);
				// can use toBytesArray method for getting bytes array from `compressed file`.
				break;
		}
	}

//	private List<Byte> toBytesArray(String path) {
//
//	}

	static Application instance() {
		return new Application();
	}
}
