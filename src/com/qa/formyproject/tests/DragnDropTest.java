package com.qa.formyproject.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragnDropTest {

	public static void main(String[] args)throws InterruptedException
	{
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\skandha\\chromedriver.exe");
	       
	       WebDriver driver=new ChromeDriver();
	       
	             
	    // maximize browser
	    driver.manage().window().maximize();
	     
	    // Open webpage
	    driver.get("http://formy-project.herokuapp.com/dragdrop");
	     
	    // Add 5 seconds wait
	    Thread.sleep(5000);
	    
	    // Create object of actions class
	    Actions act=new Actions(driver);
	     
	    // find element which we need to drag
	    WebElement drag=driver.findElement(By.cssSelector("#image"));
	     
	    // find element which we need to drop
	    WebElement drop=driver.findElement(By.cssSelector("#box"));
	    
	    act.dragAndDrop(drag, drop);
	    
	    act.dragAndDrop(drag, drop).build().perform();
	     
	    // this will drag element to destination
	    act.clickAndHold(drag).pause(2000).moveToElement(drop).release(drop).build().perform();
	    
	    //.build().perform();
	     
	     Thread.sleep(5000);
	    
		driver.quit();
		
		
	}

}
