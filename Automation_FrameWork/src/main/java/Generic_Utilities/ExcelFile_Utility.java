package Generic_Utilities;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class consists of generic method related to excel file
 * 
 * @author SHAIK AFREED AHAMAD
 */

public class ExcelFile_Utility {
	/**
	 * this method will read data from excel file and return the value to caller
	 * 
	 * @param sheetName
	 * @param rowIndex
	 * @param celIndex
	 * @return
	 * @throws Throwable
	 */

	public String readDataFromExcelFile(String sheetName, int rowIndex, int celIndex) throws Throwable {
		FileInputStream fis = new FileInputStream(".//src/test/resources/TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String value = wb.getSheet(sheetName).getRow(rowIndex).getCell(celIndex).getStringCellValue();
		return value;

	}
}
