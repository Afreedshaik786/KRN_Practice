package Generic_Utilities;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * This class consists of generic method related to property file
 * 
 * @author SHAIK AFREED AHAMAD
 */

public class PropertyFile_Utility {

	/**
	 * this method will read data from property file and return the value to caller
	 * 
	 * @param key
	 * @return
	 * @throws Throwable
	 */

	public String readDataFromPropertyFile(String key) throws Throwable {

		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p = new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;

	}
}
