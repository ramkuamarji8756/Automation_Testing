package com.auto;

import org.testng.SkipException;
import org.testng.annotations.Test;

public class TestNG5 {

	//@Test
	public void a() {
		System.out.println(" A test Method ");
	}
	
	// Industry mostly use - Recommended
	@Test(enabled = false)
	public void b() {
		System.out.println(" B test Method ");
	}
	
	// Test case will executed 2 times
	@Test(invocationCount = 2)
	public void c() {
		System.out.println(" C test Method ");
	}
	
	
	// Test case will executed 0 times ,means test case will Skip
	@Test(invocationCount = 0)
	public void d() {
		System.out.println(" D test Method ");
	}
	
	// Correct way but not recommended
	@Test
	public void e() 
	{
		System.out.println(" E  test Method ");
		throw new SkipException("Skipping e Method ");
		
	}
}
