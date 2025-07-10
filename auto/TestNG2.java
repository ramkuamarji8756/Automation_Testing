package com.auto;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNG2 
{
	
	@Test
	public void assertionChek() 
	{
		
		String expectedMessage="Log In";
		String actualMessage="Loooog In";
		try {
		Assert.assertEquals(actualMessage, expectedMessage);
		
		}catch(Error e) 
		{
			e.printStackTrace();
			System.out.println(e);
		}
		System.out.println("  Verification is Successfull...");
	}

}
