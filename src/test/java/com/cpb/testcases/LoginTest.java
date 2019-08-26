package com.cpb.testcases;
import java.io.IOException;
import java.util.Hashtable;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.*;

import com.cpb.base.TestBase;
import com.cpb.pages.MainPage;
import com.cpb.utilities.Utilities;
import com.cpb.pages.LoginPage;
public class LoginTest extends TestBase {
	//@Test
	//public void check() {
		//System.out.println("new");
	//}
	//LoginPage loginPage;
	MainPage mainPage;
	LoginPage login;
	public LoginTest(){
		super();
		//loginPage = new LoginPage();
	}
	
	@BeforeMethod
	public void setUpMetod(){
		initialization();
			
	}
	
	@DataProvider
    public Object [][] passData() throws IOException
    {
	 Object NewTestData[][] =Utilities.xcelreder("LoginTest");
	 return NewTestData;
    }
	
	@Test(dataProvider ="passData")
	public void testlogin(String Row_id,String username,String password) throws IOException
	{
		System.out.println("Row_ID is "+Row_id);
		login=new LoginPage();
		login.loginCredential(username,password);
	}
	
	/*@Test(dataProviderClass=Utilities.class,dataProvider="dp")
	//public void loginTest(String Username , String Password) throws InterruptedException{
		public void loginTest(Hashtable<String,String> data) throws InterruptedException{
		if((Utilities.isTestRunnable("LoginTest", excel))){
			if((Utilities.isTestSheetRowRunnable("LoginTest", "LoginTest",excel))){
				loginPage.login(data.get("username"), data.get("password"));
			}
			//throw new SkipException("Skipping the test "+"LoginTest".toUpperCase()+ "as the Run mode is NO");
		}
		//if(!data.get("runmode").equals("Y")){
			
			//throw new SkipException("Skipping the test case as the Run mode for data set is NO");
		//}
		  //loginPage.login(data.get("username"), data.get("password"));
		}*/
	//@Test(priority=2)
	////public void loginPageTitleTest(){
		//String title = loginPage.validateLoginPageTitle();
		//Assert.assertEquals(title, "#1 Free CRM for Any Business: Online Customer Relationship Software");
	//}
	
	//@Test(priority=3)
	//public void loginTest(){
		//type("firstname_CSS",data.get("firstname"));
		//mainPage = loginPage.login(data.get("username"), data.get("password"));
	//}
	
	
	
	@AfterMethod
	public void tearDownMethod(){
		driver.quit();
	}
	
	
}

