package com.cpb.utilities;

import java.io.File;
import com.aventstack.extentreports.*;
//import com.aventstack.extentreports.*;
//import com.aventstack.extentreports.DisplayOrder;
import com.aventstack.extentreports.ExtentReports;

public class ExtentManager {
	
	private static ExtentReports extent;
	
	
	public static ExtentReports getInstance(){
		
		if(extent==null){
			
			
			//extent = new ExtentReports(System.getProperty("user.dir")+"\\target\\surefire-reports\\html\\extent.html",true,DisplayOrder.OLDEST_FIRST);
			//extent.loadConfig(new File(System.getProperty("user.dir")+"\\src\\test\\resources\\com\\cpb\\extentconfig\\ReportsConfig.xml"));
			
		}
		
		return extent;
		
	}

}
