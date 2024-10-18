package Practice;

import Generic_Utilities.ExcelFile_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.PropertyFile_Utility;

public class GenericMethodPractice {

	public static void main(String[] args) throws Throwable {

		// property file uttility
		PropertyFile_Utility p = new PropertyFile_Utility();
		String value = p.readDataFromPropertyFile("url");
		System.out.println(value);
		
		// Excel file uttility
		ExcelFile_Utility e = new ExcelFile_Utility();
		String Value = e.readDataFromExcelFile("Contacts", 1, 2);
		System.out.println(Value);
		
		// java file uttility
		Java_Utility j = new Java_Utility();
		String date = j.getSystemDate();
		System.out.println(date);

	}

}
