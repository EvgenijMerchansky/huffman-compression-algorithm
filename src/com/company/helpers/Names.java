package com.company.helpers;

public class Names {
	private final String tableFileName = "meta.table.txt";
	private final String outputPathWithPrefix = "/Users/admin/Desktop/algorithmHuffman/src/com/company/output/compressed.";
	private final String metaTablePath = "/Users/admin/Desktop/algorithmHuffman/src/com/company/meta/meta.table.txt";

	private Names() {
	}

	public String createOutputFileName(String path) {
		return this.outputPathWithPrefix +  path.substring(path.lastIndexOf('/') + 1);
	}

	public String getTableFileName() {
		return this.tableFileName;
	}

	public String getMetaTablePath() {
		return this.metaTablePath;
	}

	public static Names run() {
		return new Names();
	}
}
