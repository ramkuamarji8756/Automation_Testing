package com.auto;

import org.testng.annotations.Test;

public class TestNG4 
{

	@Test(priority = -10)
	public void a() 
	{
		System.out.println(" A test Method ");
	}
	
	@Test(priority = -20)
	public void b() 
	{
		System.out.println(" B test Method ");
	}
	
	@Test(priority = 0)
	public void z() 
	{
		System.out.println(" Z test Method ");
	}
	
	@Test(priority = 2)
	public void d() 
	{
		System.out.println(" D test Method ");
	}
	
	@Test
	public void a3() 
	{
		System.out.println(" A3 test Method ");
	}
	
	@Test
	public void e() 
	{
		System.out.println(" E test Method ");
	}
	
	@Test
	public void s() 
	{
		System.out.println(" S test Method ");
	}
	@Test(priority = 1)
	public void f() 
	{
		System.out.println(" F test Method ");
	}
}
