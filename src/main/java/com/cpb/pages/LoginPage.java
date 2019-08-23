package com.cpb.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cpb.base.TestBase;

public class LoginPage extends TestBase {
		
		//Page Factory - OR:
		@FindBy(name="email")
		WebElement username;
		
		@FindBy(name="password")
		WebElement password;
		
		//@FindBy(xpath="//input[@type='Login']")
		//@FindBy(className="ui fluid large blue submit button")
		//WebElement loginBtn;
		
		
		//Initializing the Page Objects:
		public LoginPage(){
			PageFactory.initElements(driver, this);
		}
		
		//Actions:
		public String validateLoginPageTitle(){
			return driver.getTitle();
		}
		//<div class="ui fluid large blue submit button">Login</div>
		
		public void login(String un, String pwd){
			username.sendKeys(un);
			password.sendKeys(pwd);
			//loginBtn.click();
			    	//JavascriptExecutor js = (JavascriptExecutor)driver;
			    	//js.executeScript("arguments[0].click();", loginBtn);
			    	
			//return new MainPage();
		}
		
}
