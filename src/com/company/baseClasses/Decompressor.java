package com.company.baseClasses;

import com.company.annotations.Collections;
import com.company.annotations.DecompressorAnnotation;
import com.company.converters.ConvertString;
import com.company.converters.ConvertTable;

import java.util.HashSet;
import java.util.List;

public class Decompressor {
	private Decompressor() {
	}
	@DecompressorAnnotation(description = "General method witch decompresse compressed file")
	public void decompress(String file, String TABLE_FILE_PATH) {

		@Collections(description = "split compressed string to separate symbol codes")
		List<String> decodedString = ConvertString.converter().toArray(file);

		@Collections(description = "decompress (key: value) table from text file")
		HashSet<String> tableFromFile = ConvertTable.run().convert(TABLE_FILE_PATH);

		Comparator.run().compareStringWithTable(decodedString, tableFromFile);
	}

	public static Decompressor run() {
		return new Decompressor();
	}
}
