package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XcelReader {

	public String getExcelValue(String sheetName, int RowNum, int CellNum) throws FileNotFoundException, InvalidFormatException {
		String retval = null;
		String filepath = "E:\\Balaji\\Balaji\\Testing Software\\Automation\\iMedicor\\iMedicor\\excel\\Login_Scenerio.xlsx";
		try {
			FileInputStream fis = new FileInputStream(filepath);
			Workbook wb = new XSSFWorkbook(fis);
			Sheet sh = wb.getSheet(sheetName);
			Row r = sh.getRow(RowNum);
			Cell c = r.getCell(CellNum);
			retval = c.getStringCellValue();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return retval;
	}
	
	public int getRowCount(String sheetName) throws InvalidFormatException {
		int retval=0;
		String filepath = "E:\\Balaji\\Balaji\\Testing Software\\Automation\\iMedicor\\iMedicor\\excel\\Login_Scenerio.xlsx";
		try {
			FileInputStream fis = new FileInputStream(filepath);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh=wb.getSheet(sheetName);
			retval=sh.getLastRowNum();
		} catch(IOException e) {
			e.printStackTrace();
		}
		return retval;
	}
	
	public void setExcelValue(String sheetName, int RowNum, int CellNum, String val) throws InvalidFormatException {
		String filepath = "E:\\Balaji\\Balaji\\Testing Software\\Automation\\iMedicor\\iMedicor\\excel\\Login_Scenerio.xlsx";
		try {
			FileInputStream fis = new FileInputStream(filepath);
			Workbook wb= WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(sheetName);
			Row r = sh.getRow(RowNum);
			Cell c = r.createCell(CellNum);
			//c.setCellType(Cell.CELL_TYPE_STRING);
			c.setCellValue(val);
			FileOutputStream fos = new FileOutputStream(filepath);
			wb.write(fos);
			fos.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
