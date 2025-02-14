package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	// Method to get data from Excel
	public static Object[][] getExcelData(String filePath, String sheetName) throws IOException {
		// Initialize 2D array to store data
		String[][] data = null;
		
		//To read Excel file
		FileInputStream fileInputStream = new FileInputStream(filePath);
		//Open the excel workbook
		XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
		//Access sheet from workbook
		XSSFSheet excelsheet = workbook.getSheet(sheetName);
		
		int totalRow = excelsheet.getLastRowNum() + 1;
		//TOtal no of column in first row .
		int totalCell = excelsheet.getRow(0).getLastCellNum();

		//Arraly to store data for each row and cell
		data = new String[totalRow - 1][totalCell];

		//used to handle different type data of cell. finally convert data into string . ex . ID is numeric 
		DataFormatter dataFormatter = new DataFormatter();

		//Loop through each row .exluding first row 
		for (int i = 1; i < totalRow; i++) {
		//loop through each cell of row
			for (int p = 0; p < totalCell; p++) {
				//Get the cell value & convert into string 
				data[i - 1][p] = dataFormatter.formatCellValue(excelsheet.getRow(i).getCell(p));

			}
		}
		//close workbook
		workbook.close();
		return data;
	}
}