package Generic_Utilities;

import java.util.Date;

/**
 * This class consists of generic method related to java
 * 
 * @author SHAIK AFREED AHAMAD
 */

public class Java_Utility {
	/**
	 * this method is used to capture the current system date
	 * 
	 * @return
	 */

	public String getSystemDate() {

		Date d = new Date();
		String[] dArr = d.toString().split(" ");

		String date = dArr[2] + "-" + dArr[1] + "-" + dArr[5] + "_" + dArr[3].replace(":", "-");
		return date;

	}
}
