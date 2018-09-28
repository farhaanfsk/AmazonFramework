/**
 * 
 */
package com.epam.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author Farhaan_Shaik
 *
 */
public class ExcelReader {
	public static Object[][] getData(){
		Object data[][] = null;
		DataFormatter formatter = new DataFormatter();
		FileInputStream fileInputStream;
		try {
			fileInputStream = new FileInputStream("C:\\Users\\Farhaan_Shaik\\eclipse-workspace\\AmazonFramework\\src\\resources\\SearchData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream); 
		XSSFSheet worksheet = workbook.getSheet("Sheet1");
		XSSFRow Row = worksheet.getRow(0); 

		int RowNum = worksheet.getPhysicalNumberOfRows();
		int ColNum = Row.getLastCellNum(); 

		data = new Object[RowNum - 1][ColNum]; 

		for (int i = 0; i < RowNum - 1; i++)
		{
			XSSFRow row = worksheet.getRow(i + 1);

			for (int j = 0; j < ColNum; j++)
			{
				if (row == null)
					data[i][j] = "";
				else {
					XSSFCell cell = row.getCell(j);
					if (cell == null)
						data[i][j] = "";
					else {
						String value = formatter.formatCellValue(cell);
						data[i][j] = value; 
					}
				}
			}
		}
		workbook.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
		return data;	
	} 
}
