package com.huaking;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileIO {
	
	public static void main(String[] args) {
//		UseBuffered();
//		UseStream();
		UseChannel();
//		createFile();
//		createTemporary();
		
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
	public static void UseChannel() {
		Path srcP = Paths.get("asset/source.txt");
		Path destP = Paths.get("asset/dest.txt");
		try {
			SeekableByteChannel sbc = Files.newByteChannel(srcP);
			ByteBuffer buf = ByteBuffer.allocate(5);
			String encoding = System.getProperty("file.encoding");
			while(sbc.read(buf) > 0) {
				buf.rewind();
				System.out.println(Charset.forName(encoding).decode(buf));
				buf.flip();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void createFile() {
		Path srcP = Paths.get("asset/source.txt");
		try {
			//如果文件已经存在，会抛出文件已经存在的错误
			Files.createFile(srcP);
		} catch (IOException e) {
			System.err.format("createFile error: %s%n", e);
		}
	}
	public static void createTemporary() {
		try {
			Path tempFile = Files.createTempFile(null, ".temp");
			System.out.format("The temporary file" +
			        " has been created: %s%n", tempFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
