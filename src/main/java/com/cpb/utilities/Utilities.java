package com.cpb.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Hashtable;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;

import com.cpb.base.TestBase;

public class Utilities extends TestBase {

	public static String screenshotPath;
	public static String screenshotName;

	public static void captureScreenshot() throws IOException {

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		Date d = new Date();
		screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";

		FileUtils.copyFile(scrFile,
				new File(System.getProperty("user.dir") + "\\target\\surefire-reports\\html\\" + screenshotName));

	}

	@DataProvider(name="dp")
	public Object[][] getData(Method m) {

		String sheetName = m.getName();
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);

		Object[][] data = new Object[rows - 1][1];
		
		Hashtable<String,String> table = null;

		for (int rowNum = 2; rowNum <= rows; rowNum++) { // 2

			table = new Hashtable<String,String>();
			
			for (int colNum = 0; colNum < cols; colNum++) {

				// data[0][0]
				table.put(excel.getCellData(sheetName, colNum, 1), excel.getCellData(sheetName, colNum, rowNum));
				data[rowNum - 2][0] = table;
			}

		}

		return data;

	}
	
	
	public static boolean isTestRunnable(String testName, ExcelReader excel){
		
		String sheetName="test_suite";
		int rows = excel.getRowCount(sheetName);
		
		
		for(int rNum=2; rNum<=rows; rNum++){
			
			String testCase = excel.getCellData(sheetName, "TCID", rNum);
			
			if(testCase.equalsIgnoreCase(testName)){
				
				String runmode = excel.getCellData(sheetName, "Runmode", rNum);
				
				if(runmode.equalsIgnoreCase("Y"))
					return true;
				else
					return false;
			}
			
			
		}
		return false;
	}
	
public static boolean isTestSheetRowRunnable(String RowId, String sheetName, ExcelReader excel){
		
		//String sheetName="test_suite";
		int rows = excel.getRowCount(sheetName);
		boolean blnResult = false;
		
		for(int rNum=2; rNum<=rows; rNum++){
			
			String testCase = excel.getCellData(sheetName, RowId, rNum);
			
			if(testCase.equalsIgnoreCase(RowId)){
				
				String runmode = excel.getCellData(sheetName, "Runmode", rNum);
				
				if(runmode.equalsIgnoreCase("Y"))
					blnResult = true;
					//return true;
				else
					blnResult = false;
			}
			
			
		}
		return blnResult;
	}
	


	public static Object[][] xcelreder(String SheetName) throws IOException

	{
		FileInputStream fi = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\com\\cpb\\testdata\\testdata.xlsx");
		XSSFWorkbook TestBook = new XSSFWorkbook(fi);
		XSSFSheet TestSheet = TestBook.getSheet(SheetName);
		Object[][] TestDataObject = new Object[TestSheet.getLastRowNum()][TestSheet.getRow(0).getLastCellNum()];
		for (int i = 0; i < TestSheet.getLastRowNum(); i++) {
			for (int j = 0; j < TestSheet.getRow(0).getLastCellNum(); j++) {
				TestDataObject[i][j] = TestSheet.getRow(i + 1).getCell(j).toString();
			}
		}

		return TestDataObject;
	}
	
	public static Object[][] SingleRowreder(String SheetName, int Row_ID) throws IOException

	{
		FileInputStream fi = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\com\\cpb\\testdata\\testdata.xlsx");
		XSSFWorkbook TestBook = new XSSFWorkbook(fi);
		XSSFSheet TestSheet = TestBook.getSheet(SheetName);
		int columnLength = TestSheet.getRow(0).getLastCellNum();
	
		Object[][] TestDataObject = new Object[1][columnLength];
		for (int i = 0; i < columnLength; i++)
		{
			TestDataObject[0][i] = TestSheet.getRow(Row_ID).getCell(i).toString();
		}
		
		

		return TestDataObject;
	}

}
