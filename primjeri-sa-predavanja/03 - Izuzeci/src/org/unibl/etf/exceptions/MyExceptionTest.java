package org.unibl.etf.exceptions;

public class MyExceptionTest {
	public static void main(String args[]) { // 1
		try { // 2
			second(); // 3
		} catch (MyException e) { // 4
			System.out.println("Catch " + e);
		}
	}
	public static void second() throws MyException { // 5
		first(); // 6
	}
	public static void first() throws MyException { // 7
		throw new MyException("Exception message...");
	}
}
