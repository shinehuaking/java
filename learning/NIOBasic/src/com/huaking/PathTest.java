package com.huaking;

import java.io.IOException;
import java.net.URI;
import java.nio.file.FileSystems;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathTest {
	public static void main(String[] args) {
		Path p1 = Paths.get("/work/../java");
		System.out.println(p1.toString());
//		Path p2 = Paths.get(args[0]);
		Path p3 = Paths.get(URI.create("file:///work/java"));
		System.out.println("path:" + p3.toString() + ",fileName:" + p3.getFileName() + ",getName:" + p3.getName(0) + ",getNameCount:" + p3.getNameCount()
				+ ",getParent:" + p3.getParent() + ",getRoot:" + p3.getRoot());
		System.out.println(FileSystems.getDefault());
		Path p4 = FileSystems.getDefault().getPath("/work/java");
		System.out.println(p4.toUri());
		Path p5 = Paths.get("PathTest.java");
		System.out.println(p5.toAbsolutePath());
		Path p6 = Paths.get("/work/java");
		System.out.println("p6: " + p6.resolve("p1"));
	}
}
