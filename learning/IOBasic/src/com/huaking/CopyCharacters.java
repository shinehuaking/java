package com.huaking;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//按照字符复制
public class CopyCharacters {
	public static void main(String[] args) throws IOException {
		FileReader in = null;
		FileWriter out = null;
		
		try {
			in = new FileReader("asset/in.txt");
			out = new FileWriter("asset/out.txt");
			int c;
			while((c = in.read()) != -1) {
				out.write(c);
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
