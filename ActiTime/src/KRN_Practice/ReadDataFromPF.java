package KRN_Practice;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadDataFromPF {

	public static void main(String[] args) throws Throwable {

		FileInputStream fis = new FileInputStream(".\\files\\Commondata.properties");
		Properties p = new Properties();
		p.load(fis);
		String value = p.getProperty("password");
		System.out.println(value);

	}

}
