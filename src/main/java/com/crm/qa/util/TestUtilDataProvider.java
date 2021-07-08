package com.crm.qa.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

public class TestUtilDataProvider {

    private static XSSFSheet ExcelWSheet;

    private static XSSFWorkbook ExcelWBook;

    private static XSSFCell Cell;

    private static XSSFRow xRow;
    
    public static final String Path_TestData = "C:\\Karabi\\WhiteBoxLearning\\Documents\\CodeWBL\\Automation\\src\\main\\java\\com\\crm\\qa\\data\\";
    		 
    public static final String File_TestData = "contactList.xlsx";
    
    // C:\Karabi\WhiteBoxLearning\Documents\CodeWBL\Automation\src\main\java\com\crm\qa\data\contactList.xlsx
    
    
    public static void setExcelFile(String Path,String SheetName) throws Exception {
    	 
        try {
  
            // Open the Excel file
  
  FileInputStream ExcelFile = new FileInputStream("C:\\Karabi\\WhiteBoxLearning\\Documents\\CodeWBL\\Automation\\src\\main\\java\\com\\crm\\qa\\data\\contactList.xlsx");
  
  // Access the required test data sheet
  
  ExcelWBook = new XSSFWorkbook("contactList.xlsx");
  
  ExcelWSheet = ExcelWBook.getSheet("contacts");
//  FileInputStream ExcelFile = new FileInputStream(Path);
//  
//  // Access the required test data sheet
//  
//  ExcelWBook = new XSSFWorkbook(ExcelFile);
//  
//  ExcelWSheet = ExcelWBook.getSheet(SheetName);
  
  System.out.println("ExcelWSheet : "+ExcelWSheet +"ExcelWBook "+ExcelWBook + " ");
  
  } catch (Exception e){
  
  throw (e);
  
  }
  
  }
  
    
    //This method is to read the test data from the Excel cell, in this we are passing parameters as Row num and Col num
    
    public static String getCellData(int RowNum, int ColNum) throws Exception{

  try{

      Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);

      String CellData = Cell.getStringCellValue();

      return CellData;

      }catch (Exception e){

return"";

      }

}

    //This method is to write in the Excel cell, Row num and Col num are the parameters
    
    public static void setCellData(String Result,  int RowNum, int ColNum) throws Exception {

      try{

          xRow  = ExcelWSheet.getRow(RowNum);

Cell = xRow.getCell(ColNum, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);

if (Cell == null) {

Cell = xRow.createCell(ColNum);

Cell.setCellValue(Result);

} else {

Cell.setCellValue(Result);

}
// Constant variables Test Data path and Test Data file name

FileOutputStream fileOut = new FileOutputStream(Path_TestData + File_TestData);

ExcelWBook.write(fileOut);

fileOut.flush();

fileOut.close();

}catch(Exception e){

throw (e);

}

}
    
    
}
