package com.huaking;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DirectoryFilter {
	
	public static void main(String[] args) {
		
		//过滤文件可以用glob
		Path path = Paths.get("/work/document/java");
		DirectoryStream<Path> stream0 = null;
		DirectoryStream<Path> stream = null;
		try {
			stream0 = Files.newDirectoryStream(path, "*.{pdf}");
			for (Path entry: stream0) {
//			     System.out.println(entry.getFileName());
			}
			stream0.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		//文件过滤器，如果是文件夹不过滤，如果是文件过滤掉。
		DirectoryStream.Filter<Path> filter = new DirectoryStream.Filter<Path>() {
			@Override
			public boolean accept(Path entry) throws IOException {
				return Files.isDirectory(entry);
			}
			
		};
		
		try {
			stream = Files.newDirectoryStream(path, filter);
			for(Path file:stream) {
				System.out.println(file.getFileName());
			}
			stream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
