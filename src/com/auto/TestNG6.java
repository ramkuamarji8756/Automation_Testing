package com.auto;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNG6 
{
	@Test
	public void a() 
	{
		System.out.println(" A test Method ");
	}

	@Test(invocationCount =2, priority = -1,enabled = false)
	public void b() 
	{
		System.out.println(" B test Method ");
	}
	
	@Test(invocationCount = 2)
	public void c() 
	{
		System.out.println(" C test Method ");
	}
	
	@BeforeMethod
	public void d() 
	{
		System.out.println(" D test Method ");
	}
}
