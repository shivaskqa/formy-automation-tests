package com.qa.testng;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData {

	
	private static FileInputStream fis;
	private static XSSFWorkbook workbook;
	private static XSSFSheet sheet;
	private static XSSFCell cell;
	private static XSSFRow row;
    
	
	public String[][] readExcel(String path,String sheetname)throws IOException
	{
		
	 	fis=new FileInputStream(path);
		workbook=new XSSFWorkbook(fis);
		sheet=workbook.getSheet(sheetname);
		int lastrow=sheet.getLastRowNum();
		int lastcol=sheet.getRow(0).getLastCellNum();
		
		String data[][]=new String[lastrow][lastcol];
		
		System.out.println("Last row in the excel is "+lastrow);
		for(int i=1;i<=lastrow;i++)
		{ 
			row=sheet.getRow(i);
			int lastcellnum=row.getLastCellNum();
			System.out.println(" Last cell number "+lastcellnum);
			 for(int j=0;j<lastcellnum;j++) 
			 {
				 cell=row.getCell(j);
			       String celldata=cell.getStringCellValue();
			       data[i-1][j]=celldata;
			      
			 }
			 System.out.println();
		}
		System.out.println(data);
		return data;
		
	  
}	
	
}
