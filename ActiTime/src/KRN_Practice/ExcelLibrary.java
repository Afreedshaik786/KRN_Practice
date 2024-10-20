package KRN_Practice;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelLibrary {

	public String getExcelData(String sheetName, int rowNum, int cellNum) throws Throwable {
		String retval = null;
		FileInputStream fis = new FileInputStream("C:\\Users\\SHAIK AFREED AHAMAD\\Desktop\\Testdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cel = row.getCell(cellNum);
		retval = cel.getStringCellValue();
		return retval;

	}

	public int getLastRowNum(String sheetName) throws Throwable {
		int retval = 0;
		FileInputStream fis = new FileInputStream("C:\\Users\\SHAIK AFREED AHAMAD\\Desktop\\Testdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheetName);
		retval = sheet.getLastRowNum();
		return retval;

	}
}
