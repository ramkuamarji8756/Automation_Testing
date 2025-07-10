package com.auto;

import org.testng.annotations.*;

public class TestNG1 
{
	@Test
	public void a2()
	{
		System.out.println(" A2 Method ");
	}
	
	@BeforeTest
	public void b() 
	{
		System.out.println(" B Method ");
	}
	
	@BeforeSuite
	public void c() 
	{
		System.out.println(" C Method ");
	}
	
	@BeforeMethod
	public void d() 
	{
		System.out.println(" D Method ");
	}
	
	@BeforeClass
	public void e() 
	{
		System.out.println(" E Method ");
	}
	
	@AfterTest
	public void f() 
	{
		System.out.println(" F Method ");
	}
	
	@AfterClass
	public void g() 
	{
		System.out.println(" G Method ");
	}
	
	@AfterMethod
	public void h() 
	{
		System.out.println(" H Method ");
	}
	
	@AfterSuite
	public void i() 
	{
		System.out.println(" I Method ");
	}
	
	@Test
	public void a1() 
	{
		System.out.println(" A1 Method ");
	}
	
}
