package org.unibl.etf.javalangclasses;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class RuntimeTest {

	public static void main(String[] args) throws IOException, AWTException {
		Runtime runtime = Runtime.getRuntime();
		String psArgs[] = { "notepad.exe", "results.txt" };
		Process notepad = runtime.exec(psArgs);				// 1
		Process calc = runtime.exec("calc.exe");			// 2
		System.out.println(runtime.totalMemory());			// 3
		System.out.println(runtime.maxMemory());			// 4
		System.out.println(runtime.freeMemory());			// 5
		System.out.println(notepad.pid());
		try {
			notepad.waitFor();
			calc.waitFor();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		System.out.println(notepad.exitValue());
//		runtime.exit(0);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Runtime.getRuntime().exec("notepad");
		writeString("Pozdrav! Ja sam Robot koji zapisuje zanimljive stvari...");
	}
	
	private static void writeString(String s) throws AWTException {
		Robot robot = new Robot();
	    for (int i = 0; i < s.length(); i++) {
	        char c = s.charAt(i);
	        if (Character.isUpperCase(c)) {
	            robot.keyPress(KeyEvent.VK_SHIFT);
	        }
	        switch(c) {
	        	case '!':
	        		robot.keyPress(KeyEvent.VK_SHIFT);
	        		robot.keyPress(KeyEvent.VK_1);
	        		robot.keyRelease(KeyEvent.VK_1);
	        		robot.keyRelease(KeyEvent.VK_SHIFT);
	        		break;
	        	case '.':
	        		robot.keyPress(KeyEvent.VK_PERIOD);
	        		robot.keyRelease(KeyEvent.VK_PERIOD);
	        		break;
	        	default:
	    	        robot.keyPress(Character.toUpperCase(c));
	    	        robot.keyRelease(Character.toUpperCase(c));
	        }
	        if (Character.isUpperCase(c)) {
	            robot.keyRelease(KeyEvent.VK_SHIFT);
	        }
		    robot.delay((int) (100 + Math.random()*400));
	    }
	}
}