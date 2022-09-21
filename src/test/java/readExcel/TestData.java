package readExcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestData {
	
	
	public String[][] readExcel(String filePath,String fileName,String sheetName) throws IOException{

	    //Create an object of File class to open xlsx file

	    File file =    new File(filePath+"\\"+fileName);

	    //Create an object of FileInputStream class to read excel file

	    FileInputStream inputStream = new FileInputStream(file);

	    Workbook TWorkbook = null;

	    //Find the file extension by splitting file name in substring  and getting only extension name

	    String fileExtensionName = fileName.substring(fileName.indexOf("."));

	    //Check condition if the file is xlsx file

	    if(fileExtensionName.equals(".xlsx")){

	    //If it is xlsx file then create object of XSSFWorkbook class

	    TWorkbook = new XSSFWorkbook(inputStream);

	    }

	    //Check condition if the file is xls file

	    else if(fileExtensionName.equals(".xls")){

	        //If it is xls file then create object of HSSFWorkbook class

	        TWorkbook = new HSSFWorkbook(inputStream);

	    }

	    //Read sheet inside the workbook by its name

	    Sheet TSheet = TWorkbook.getSheet(sheetName);

	    //Find number of rows in excel file

	    int rowCount = TSheet.getLastRowNum()-TSheet.getFirstRowNum();
		 System.out.println("total number of rows in the sheet1 excel is "+ rowCount);

	    //Create a loop over all the rows of excel file to read it
	    int cellCount = TSheet.getRow(0).getLastCellNum();
	     System.out.println("total number of columns in the sheet1 excel is "+ cellCount);

	    String data[][] = new String[rowCount][cellCount];
	    for (int i = 1; i <= rowCount; i++) {

	        Row r = TSheet.getRow(i);

	        //Create a loop to print cell values in a row

	        for (int j = 0; j<=cellCount; j++) {
	        	Cell c = r.getCell(j);
	        	try {
	        	data[i - 1][j] = c.getStringCellValue();

	            //Print Excel data in console

	            System.out.print(r.getCell(j).getStringCellValue());
	        	} catch (Exception e) {
	        		
	        	}
	        }

	        System.out.println();
	    }
	    
	    //this to return data to the calling method
		return data ; 

	    }  


}
