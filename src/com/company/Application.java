package com.company;

import com.company.baseClasses.Compressor;
import com.company.baseClasses.Decompressor;
import com.company.helpers.Names;

class Application { // shift + fn + f6 (fast editing)
	private Application() {
	}

	void run(String[] args) {
		final String mode = args[0];
		final String file = args[1];
		final String COMPRESS = "--compress";
		final String DECOMPRESS = "--decompress";
		final String OUTPUT_FILE_NAME = Names.run().createOutputFileName(file);
		final String TABLE_FILE_PATH = Names.run().getMetaTablePath();

		switch (mode) {
			case COMPRESS:
				Compressor.run().compress(
					file,
					TABLE_FILE_PATH,
					OUTPUT_FILE_NAME
				);
				break;

			case DECOMPRESS:
				Decompressor.run().decompress(
					file,
					TABLE_FILE_PATH
				);
				break;
			default:
				System.out.println("Invalid flag parameter");
		}
	}

	static Application instance() {
		return new Application();
	}
}
