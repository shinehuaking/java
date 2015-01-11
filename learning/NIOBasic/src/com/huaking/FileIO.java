package com.huaking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileIO {
	
	public static void main(String[] args) {
		Charset charset = Charset.forName("utf-8");
		Path srcP = Paths.get("asset/source.txt");
		Path destP = Paths.get("asset/dest.txt");
		try {
			BufferedReader reader = Files.newBufferedReader(srcP, charset);
			BufferedWriter writer = Files.newBufferedWriter(destP, charset,StandardOpenOption.APPEND);
			String line = null;
			while((line = reader.readLine()) != null) {
				System.out.println(line);
				writer.write(line);
				writer.newLine();
			}
			reader.close();
			writer.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
