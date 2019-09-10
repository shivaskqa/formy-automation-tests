package com.qa.testng;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemo {

	
	public WebDriver driver;
	
	public DataProviderDemo() {
	
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\skandha\\chromedriver.exe");
		
		driver=new ChromeDriver();
		
		driver.navigate().to("https://www.crmpro.com");
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}
	
	/*@Test(dataProvider="getDataFromDataProvider")
	public void testMethod(String searchKey)throws InterruptedException
	{
		
		WebElement element=driver.findElement(By.xpath("//input[@name='q']"));
		element.sendKeys(searchKey);
		element.sendKeys(Keys.ENTER);
		System.out.println("Your SearchKey value is"+searchKey);
		Thread.sleep(5000);
		WebElement e=driver.findElement(By.xpath("//div[@class='RNNXgb']//input[@name='q']"));
		String testValue=e.getAttribute("value");
		System.out.println(testValue+":::::::"+e);
		e.clear();
		Assert.assertEquals(searchKey, testValue);
	}*/
	
	/*@DataProvider
	public Object[][] getDataFromDataProvider()
	{
	
	  return new Object[][] {{"India"},{"Selenium"},{"Java"}}; 
	}
	*/
	@After
	public void tearDown()
	{
		
		driver.quit();
	}
	
	@DataProvider
	public Object[][] getDataFromExcel() throws IOException
	{
		
		ReadExcelData read=new ReadExcelData();
		return read.readExcel("C:\\Users\\skandha\\Desktop\\CucumberBDD.xlsx", "Credentials");
			
	}
	
    @Test(dataProvider="getDataFromExcel")	
	public void testReadExcelMethod(String Username,String Password)throws InterruptedException
	{
       	
    	driver.findElement(By.name("username")).sendKeys(Username);
    	driver.findElement(By.name("password")).sendKeys(Password);
    	driver.findElement(By.xpath("//input[@type='submit']")).submit();
    	Thread.sleep(5000);
    	
	}	
}


