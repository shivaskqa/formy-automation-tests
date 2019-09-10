package com.qa.formyproject.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchWindow {
	
	public static void main(String a[])
	{
		
       System.setProperty("webdriver.chrome.driver", "C:\\Users\\skandha\\chromedriver.exe");
       
       WebDriver driver=new ChromeDriver();
       
       driver.get("http://formy-project.herokuapp.com/switch-window");
       
       driver.manage().window().maximize();
       
       WebElement newtabbutton=driver.findElement(By.id("new-tab-button"));
       
       newtabbutton.click();
       
       String originalWinHandle=driver.getWindowHandle();
       
       for(String handle:driver.getWindowHandles())
       {
    	   driver.switchTo().window(handle);
       }
       
       driver.switchTo().window(originalWinHandle);
		
	   driver.quit();	
		
		
	}
	
	

}
