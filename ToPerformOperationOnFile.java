package com.filehandling;

import java.io.File;

public class ToPerformOperationOnFile {
	public static boolean deleteFolder(File file) {
		for (File subFile : file.listFiles()) {
			if (subFile.isDirectory()) {
				deleteFolder(subFile);
			}
			else {
				subFile.delete();
			}
		}
		return file.delete();
	}
}