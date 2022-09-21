package readExcel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestDataGuruDemo {
	
	public String[][] readExcel(String filePath,String fileName,String sheetName) throws IOException
	{
		 FileInputStream inputStream = new FileInputStream("C:\\Java Eclipse\\Workspace\\demoguru\\testDataDemoG\\testDataDGuru.xlsx");
		 
		 XSSFWorkbook wb = new XSSFWorkbook(inputStream);
		 XSSFSheet sheet =wb.getSheet("Sheet1");
		 int rowCount = sheet.getLastRowNum()+1;
		 System.out.println("total number of rows in the sheet1 excel is "+ rowCount);
		 
		 int colCount =  sheet.getRow(0).getLastCellNum();  //returns column/cell count
	     System.out.println("total number of columns in the sheet1 excel is "+ colCount);
		 
	     String data[][] = new String[rowCount][colCount];

	      for(int i=1; i<rowCount; i++)
	      {
	    	XSSFRow currentRow = sheet.getRow(i);                
	    	for(int j=0; j<colCount; j++)
	    	{
	    	 
	    	XSSFCell c =currentRow.getCell(j);
	    	
	    	System.out.print("   " + c.toString()); 
	    	
	        }
	    	 System.out.println(); 
     	  }
		 
	      return data;
	     
	   
		 
		 
	}

}
