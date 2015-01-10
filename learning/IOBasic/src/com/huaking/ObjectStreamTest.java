package com.huaking;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectStreamTest {
	static final String dataFile = "asset/dataFile.txt";

	public static void main(String[] args) throws IOException {
		Student stu1 = new Student("jack01", 10, 1);
		Student stu2 = new Student("jack02", 20, 1);
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(
				dataFile));
		out.writeObject(stu1);
		out.writeObject(stu2);
		out.close();
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(
				dataFile));
		Student s;
		try {
			while (true) {
				System.out.println(in.readObject());
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (EOFException e) {

		}

	}
}
