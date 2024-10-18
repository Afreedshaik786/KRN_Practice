
package Practice;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadDataFromPropertyFile {

	public static void main(String[] args) throws Throwable {
		// step1;-open the docuemt in java readable format
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");

		Properties p = new Properties();

		// step3;-load the fis into properties class
		p.load(fis);

		// step4;-provide key and read the value
		String value = p.getProperty("url");
		System.out.println(value);
	}

}
