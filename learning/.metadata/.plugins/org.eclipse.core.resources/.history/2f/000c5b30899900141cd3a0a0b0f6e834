package com.huaking;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

//按照字节复制一个个字节读取效率比较低
public class CopyBytes {
	public static void main(String[] args) throws IOException {
		FileInputStream in = null;
		FileOutputStream out = null;
		
		try {
			in = new FileInputStream("asset/in.txt");
			out = new FileOutputStream("asset/out.txt");
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
