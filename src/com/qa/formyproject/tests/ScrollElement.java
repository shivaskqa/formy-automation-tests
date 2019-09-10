package com.qa.formyproject.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ScrollElement {

	public static void main(String[] args)throws InterruptedException
	{
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\skandha\\chromedriver.exe");
	       
	       WebDriver driver=new ChromeDriver();
	       
	       driver.get("http://formy-project.herokuapp.com/scroll");
	       
	       driver.manage().window().maximize();

	       WebElement name=driver.findElement(By.id("name"));
	       
	       Actions actions=new Actions(driver);
	       
	       actions.moveToElement(name);
	              
	       name.sendKeys("Shiva Shankar");
	       
	       WebElement date=driver.findElement(By.id("date"));
	       
	       date.sendKeys("01/01/2020");
	       
	       Thread.sleep(5000);
	       
	       driver.quit();
	       
	}

}
