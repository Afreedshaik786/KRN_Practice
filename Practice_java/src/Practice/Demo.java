package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Demo {

	public static void main(String[] args) throws Throwable {

		/*
		 * FileOutputStream fos = new
		 * FileOutputStream("C:\\Users\\SHAIK AFREED AHAMAD\\Desktop\\demo.txt");
		 * PrintWriter pw = new PrintWriter(fos); pw.println("i love u daddy");
		 * pw.flush(); System.out.println("data written");
		 */

		try {
			FileInputStream fis = new FileInputStream("C:\\Users\\SHAIK AFREED AHAMAD\\Desktop\\demo.txt");
			try {
				int ch = fis.read();
				while (ch != -1) {
					System.out.print((char) ch);
					ch = fis.read();
				}
			} catch (IOException e) {
				System.out.println("IOException is handled");
			}
		} catch (FileNotFoundException e) {
			System.out.println("path not found");
		}

	}

}
