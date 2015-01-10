package com.huaking;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataStreamTest {
	static final String dataFile = "asset/dataFile.txt";
	static final double[] prices = {19.99, 9.99, 15.99, 3.99, 4.99};
	static final int[] units = {12, 8, 13, 29, 50};
	static final String[] descs = {
		"Java T-shirt",
		"Java Mug",
		"Duke Juggling Dolls",
		"Java Pin",
		"Java Key Chain"
	};
	public static void main(String[] args) throws IOException {
		DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(dataFile)));
		for(int i = 0; i < prices.length; i++) {
			out.writeDouble(prices[i]);
			out.writeInt(units[i]);
			out.writeUTF(descs[i]);
			out.flush();
		}
		DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(dataFile)));
		try {
			while(true) {
				double price = in.readDouble();
				int unit = in.readInt();
				String desc = in.readUTF();
				System.out.format("your ordered %d" + " units of %s at $%.2f%n", unit, desc, price);
			}
		} catch(EOFException e) {
			//DataStreams判断文件结束通过捕获EOF异常
		}
		finally {
			if(in != null) {
				in.close();
			}
			if(out != null) {
				out.close();
			}
		}
		
	}
}
