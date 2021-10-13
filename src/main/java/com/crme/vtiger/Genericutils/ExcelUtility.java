package com.crme.vtiger.Genericutils;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



public class ExcelUtility {
	
public String getExcelData(String sheetName, int rownum,int cellnum) throws Throwable {
		
		FileInputStream file=new FileInputStream(IPathConstant.EXCELPATH);
		Workbook wb =WorkbookFactory.create(file);
		Sheet sheet = wb.getSheet(sheetName);
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		
		return cell.getStringCellValue();
           }

}
