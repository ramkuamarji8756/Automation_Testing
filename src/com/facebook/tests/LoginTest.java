package com.facebook.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.facebook.genericPage.MasterPage;
import com.facebook.pages.LoginPage;

public class LoginTest
{
	@Test
	public void doLogin() throws Exception 
	{
		LoginPage lp = new  LoginPage();
		lp.clickEmailOrPhone();
		lp.enterUsername();
		lp.clickEmailOrPhone();
		lp.enterPassword();
		lp.clickPassword();
		lp.clickLoginButton();
	}

	@AfterClass
	public  void closeLoginPage() 
	{
 
		//MasterPage.driver.close();
		 if (MasterPage.driver != null) {
		        MasterPage.driver.close();
		    }
	}
	
}
