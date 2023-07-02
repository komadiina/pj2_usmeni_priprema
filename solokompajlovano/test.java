package test;

import java.io.*;

public class test {
	public static void main(String[] args) throws Exception {
		E e1 = new E();
		S s1 = new S();
		
		ObjectOutputStream cout = 
			new ObjectOutputStream(new FileOutputStream("test.out"));

		cout.writeObject(e1);
		cout.writeObject(s1);
	
		ObjectInputStream cin = 
			new ObjectInputStream(new FileInputStream("test.out"));

		E e11 = (E)cin.readObject();
		S s11 = (S)cin.readObject();

		cin.close();
		cout.close();
	}
}




