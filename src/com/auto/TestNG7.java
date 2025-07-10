package com.auto;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNG7 {
	
	@Test
	public void z() 
	{
		Assert.assertTrue(3>12);
		System.out.println(" Z  test Method ");
	}
	@Test(dependsOnMethods = {"z"})
	public void b() 
	{
		Assert.assertTrue(3>12);
		System.out.println(" B test Method ");
	}

}
