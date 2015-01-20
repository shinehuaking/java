package com.huaking;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LegacyCode {
	
	public static void main(String[] args) {
		//Java 6
		File file = new File("Readme.TXT");
		//Java 7
		Path path = Paths.get("Readme.TXT");
		//transform File to Path:
		Path p = new File("README.TXT").toPath();
	}
}
