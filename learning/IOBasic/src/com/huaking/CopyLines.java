package com.huaking;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

//把字符流放到缓冲区
//BufferedInputStream和BufferedOutputStream创建字节流缓冲区
//BufferedReader和BufferedWriter创建字符流缓冲区
public class CopyLines {
	public static void main(String[] args) throws IOException {
		BufferedReader in = null;
		PrintWriter out = null;
		
		try {
			in = new BufferedReader(new FileReader("asset/in.txt"));
			out = new PrintWriter(new FileWriter("asset/out.txt"));
			String c;
			while((c = in.readLine()) != null) {
				out.println(c);
			}
		} finally {
			if(in != null) {
				in.close();
			}
			if(out != null) {
				out.close();
			}
		}
	}
}
