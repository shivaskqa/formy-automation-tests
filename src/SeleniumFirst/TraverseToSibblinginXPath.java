package SeleniumFirst;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TraverseToSibblinginXPath {
	
	
	WebDriver driver = null;

	
	@BeforeMethod
	public void invokeBrowser()

	{

		try {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\skandha\\chromedriver.exe");

			driver = new ChromeDriver();

			driver.manage().deleteAllCookies();

			driver.manage().window().maximize();

			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

			driver.get("http://www.qaclickacademy.com");

			System.out.println("Before hitting the any links in page" + driver.getCurrentUrl());

			getSibblingXPathofWebElement();
		}

		catch (Exception e) {

			e.printStackTrace();
		}

	}

	@Test
	public void getSibblingXPathofWebElement()throws InterruptedException {

		
		driver.findElement(By.xpath("//ul[@class='nav navbar-nav navbar-right']/li[4]")).click();
		
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@id='tablist1-tab1']"))).isDisplayed();
				
		//Click on four tabs displayed http://qaclickacademy website under interview guide tab
		// four tabs : Appium , Selenium , Soap UI, Testing tabs by Using Sibling in XPath
		
		
		//Click on First tab : Appium
		driver.findElement(By.xpath("//li[@id='tablist1-tab1']")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//li[@id='tablist1-tab1']/following-sibling::li[1]")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//li[@id='tablist1-tab1']/following-sibling::li[2]")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//li[@id='tablist1-tab1']/following-sibling::li[3]")).click();
		Thread.sleep(3000);
		
		// Using contains : //a[contains(text(),'Features')]
		// Using text : //*[text()='Features']
	}

	@AfterMethod
	public void closeBrowser()

	{

		driver.quit();
	}
	
	

	
}
