package com.qa.formyproject.tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchToAlert {

	public static void main(String[] args)throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\skandha\\chromedriver.exe");
	       
	       WebDriver driver=new ChromeDriver();
	       
	       driver.get("http://formy-project.herokuapp.com/switch-window");
	       
	       driver.manage().window().maximize();
	       
	       WebElement alertbutton=driver.findElement(By.id("alert-button"));
	       
	       alertbutton.click();
	       
	       Alert alert=driver.switchTo().alert();
	       
	       alert.accept();
	       
	       Thread.sleep(5000);
	       
	       driver.quit();


	}

}
