package com.huaking;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DirectoryOperaction {
	
	public static void main(String[] args) {
		//打印文件系统的根目录
		Iterable<Path> dirs = FileSystems.getDefault().getRootDirectories();
		for(Path name:dirs) {
			System.out.println(name);
		}
		//如果不存在，就创建
		try {
			Files.createDirectories(Paths.get("/work/bar"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		//列出一个文件夹的内容
		Path path = Paths.get("/work/document/java");
		try {
			DirectoryStream<Path> stream = Files.newDirectoryStream(path);
			for(Path file:stream) {
				System.out.println(file.getFileName());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
