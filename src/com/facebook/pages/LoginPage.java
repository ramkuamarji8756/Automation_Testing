package com.facebook.pages;

import com.facebook.genericPage.MasterPage;

public class LoginPage extends MasterPage
{

	public LoginPage() throws Exception {
		super();
	}
	
	// click email or phone 
	public void clickEmailOrPhone() 
	{
		click("EmailOrPhone");
		
	}
	
	// Enter UserName
	public void enterUsername() 
	{
	
		enterData("EmailOrPhone","data1");
	}
	
	// click password 
		public void clickPassword() 
		{
			click("Password");
			
		}
		
		// Enter Password
		public void enterPassword() 
		{
		
			enterData("Password","data2");
		}
		
		// click Login Button
		public void clickLoginButton() 
		{
		
			click("LoginButton");
		}
		
	

}
