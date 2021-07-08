package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase {

	public static long PAGE_LOAD_TIME_OUT = 15;
	public static long IMPLICIT_WAIT =10 ;
	public static String TEST_DATA_SHEET_PATH="C:\\Karabi\\WhiteBoxLearning\\Documents\\CodeWBL\\Automation\\src\\main\\java\\com\\crm\\qa\\data\\contactList.xlsx";
	static Workbook book;// import org.apache.poi.ss.usermodel.Workbook;
	static Sheet sheet; //import org.apache.poi.ss.usermodel.Sheet;
	
	/*...
	 * 
	 */


    
	
	public void switchToFrame(String frameName) {
		driver.switchTo().frame("frameName");
	}
	
	/* data from xls File */
	/*apache POI*/
	
	public static Object[][] getTestData(String sheetName){
		FileInputStream file  = null;
		 try {
			 file = new FileInputStream(TEST_DATA_SHEET_PATH);
		 
		 }catch(FileNotFoundException e) {
			 e.printStackTrace();
		 }
		 
		 try {
			 
			 book=WorkbookFactory.create(file);
			 
//		 }catch(InvalidFormatException e) {
//			 e.printStackTrace();
		 }catch(IOException e) {
			 e.printStackTrace();
		 }
		 
		 sheet = book.getSheet(sheetName);
		 Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		 for(int i=0;i<sheet.getLastRowNum();i++) {
			 for(int k=0;k<sheet.getRow(0).getLastCellNum();k++) {
				 data[i][k]=sheet.getRow(i+1).getCell(k).toString();
			 }
			 
		 }
		return data;
		
	}
	
	
	
	
	/* take screenshot */
	public static void takeScreenshotAtEndOfTest() throws IOException{
		File srcFile=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				String currentDir = System.getProperty("user.dir");
//		if(osName.startWith("Mac")) {
//			FileUtils.copyFile(srcFile, new File(currentDir+"/screenshotd/"+System.currentTimeMillis()+".png"));
//		}
//		else {
			FileUtils.copyFile(srcFile, new File(currentDir+"\\screenshotd\\"+System.currentTimeMillis()+".png"));
//		}
		
	}
	
	
	
	
	
	
}
