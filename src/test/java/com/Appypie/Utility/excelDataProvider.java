package com.Appypie.Utility;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelDataProvider {
	
	XSSFWorkbook wb;
	
	public excelDataProvider() {
		File src=new File("./TestData/testData.xlsx");
		try {
			FileInputStream fis=new FileInputStream(src);
			wb=new XSSFWorkbook(fis);
		} catch (Exception e) {
			System.out.println("Unable to connect to workbook"+e.getMessage());
		}
	}
	
	public String getStringData(String sheetname,int row,int col) {
		return wb.getSheet(sheetname).getRow(row).getCell(col).getStringCellValue();
	}
	
	public double getNumericData(String sheetname,int row, int col) {
		return wb.getSheet(sheetname).getRow(row).getCell(col).getNumericCellValue();
	} 
	
	public String getStringData(int sheetindex,int row,int col) {
		return wb.getSheetAt(sheetindex).getRow(row).getCell(col).getStringCellValue();
	}
  
	public String getappysearchtext(String sheetname,int row,int col) {
		return wb.getSheet(sheetname).getRow(row).getCell(col).getStringCellValue();
	}
}
