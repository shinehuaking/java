package com.huaking;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class ScanFile {
	public static void main(String[] args) {
		Scanner s = null;
		
		try {
			s = new Scanner(new FileReader("asset/in.txt"));
			s.useDelimiter(",");
			while(s.hasNext()) {
				System.out.println(s.next());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			s.close();
		}
	}
}
