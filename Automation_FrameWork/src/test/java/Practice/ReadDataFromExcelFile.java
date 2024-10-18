package Practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelFile {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// step1;-open the doc in java readable format
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");

		// step2;-create a work book
		Workbook wb = WorkbookFactory.create(fis);

		// step3;-navigate to required sheet
		Sheet sh = wb.getSheet("Contacts");

		// step4;-navigate to required row
		Row row = sh.getRow(1);

		// step5;-navigate to required cell
		Cell cel = row.getCell(2);

		// step6;-capture the value in the cell
		String value = cel.getStringCellValue();
		System.out.println(value);

		// step7;-close the work book
		wb.close();
	}

}
