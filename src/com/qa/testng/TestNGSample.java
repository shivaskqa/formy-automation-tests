package com.qa.testng;

import java.util.Arrays;
import java.util.List;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

public class TestNGSample {

	
	@BeforeClass
	public void checkBeforeClass()
	{
		
		System.out.println("This method is annotated with BeforeClass");
	}
	
	
	@BeforeTest
	public void checkBeforeTest()
	{
		
		System.out.println("This method is annotated with BeforeTest");
		
	}
	
	@BeforeMethod
	public void checkBeforeMethod()
	{
		
		System.out.println("This method is annotated with beforemethod");
		
	}
	
	@Test(priority=1)
	@Parameters({"name"})
	public  void checkTest(String name)
	{
		
		System.out.println("This method is being invoked with @test annotation");
		System.out.println(name);
	}
	
	@Test(priority=2,enabled=false)
	public  void checkTest1()
	{
		
		System.out.println("This method is being invoked with @test annotation");
	}
	
	
	
	
	@AfterClass
	public void checkAfterClass()
	{
		
		System.out.println("This method is annotated with BeforeClass");
	}
	
	
	@AfterTest
	public void checkAfterTest()
	{
		
		System.out.println("This method is annotated with BeforeTest");
		
	}
	
	@AfterMethod
	public void checkAfterMethod()
	{
		
		System.out.println("This method is annotated with beforemethod");
		
	}
	
	
}
