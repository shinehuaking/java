package com.huaking;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileIO {
	
	public static void main(String[] args) {
//		UseBuffered();
//		UseStream();
		
	}
	public static void UseBuffered() {
		Charset charset = Charset.forName("utf-8");
		Path srcP = Paths.get("asset/source.txt");
		Path destP = Paths.get("asset/dest.txt");
		try {
			
//			文件很小的时候可以用这个方法
//			Files.readAllBytes(srcP);
//			Files.readAllBytes(srcP);
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
	public static void UseStream() {
		Charset charset = Charset.forName("utf-8");
		Path srcP = Paths.get("asset/source.txt");
		Path destP = Paths.get("asset/dest.txt");
		try {
			InputStream in = Files.newInputStream(srcP);
		    BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		    
		    OutputStream out = new BufferedOutputStream(Files.newOutputStream(destP));
		    String line = null;
		    while ((line = reader.readLine()) != null) {
		        System.out.println(line);
		        byte data[] = line.getBytes();
		        out.write(data, 0, data.length);
		    }
		    in.close();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
