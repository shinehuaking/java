package com.huaking;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PrintFilesTest {
	
	public static void main(String[] args) {
		Path startingDir = Paths.get("/images");
		PrintFiles pf = new PrintFiles();
		try {
			Files.walkFileTree(startingDir, pf);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
