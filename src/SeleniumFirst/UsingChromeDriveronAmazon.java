package SeleniumFirst;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UsingChromeDriveronAmazon {

	WebDriver driver;

	public void invokeBrowser() {

		try {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\skandha\\chromedriver.exe");

			driver = new ChromeDriver();

			driver.manage().deleteAllCookies();

			driver.manage().window().maximize();

			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

			System.out.println("Before hitting the any links in page" + driver.getCurrentUrl());

		}

		catch (Exception e) {

			e.printStackTrace();
		}

	}

	public void getElemnetLocatorTechniquesUsingAmazon(String url)

	{

		try {

			// driver.get(url);
			driver.navigate().to(url);

			// Explicit Wait statement

			WebDriverWait wait = new WebDriverWait(driver, 20);

			WebElement we = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Your Amazon.in")));

			boolean iselementvisible = we.isDisplayed();

			System.out.println(iselementvisible);

			WebElement element = driver.findElement(By.xpath("//a[@href=\"/gp/goldbox?ref=nav_topnav_deals\"]"));

			String text = element.getText();

			System.out.println(text);

			ArrayList<WebElement> linkswithatag = (ArrayList<WebElement>) driver
					.findElements(By.xpath("//a[contains(text(),\"Amazon\")]"));

			System.out.println(linkswithatag.size());

			for (int i = 0; i < linkswithatag.size(); i++) {
				System.out.println("This is " + i + " th link in Amazon Web Page with a tag");
				System.out.println(linkswithatag.get(i).getText());
			}

			driver.findElement(By.xpath("//img[@alt=\"Mobiles and Accessories\"]")).click();

			System.out.println(driver.getTitle());
			
			driver.navigate().back();
			
			Thread.sleep(2000);
			
			//Entering text on to search field in amazon app
			
			driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Lenovo Laptops");
			
			driver.findElement(By.xpath("//input[@type='submit' and @value='Go']")).click();
			
						
			

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public void getiFrameCountinFreeCRMWebApp(String url)

	{
		driver.get(url);

		// Explicit Wait Statements

		WebDriverWait wait = new WebDriverWait(driver, 20);

		WebElement element = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='submit']")));

		System.out.println(element.isDisplayed());

		// iframe count in freecrm web application

		ArrayList<WebElement> e = (ArrayList<WebElement>) driver.findElements(By.tagName("iframe"));
		System.out.println(e.size());

	}

	public void closeBrowser()

	{

		driver.close();

	}

	public static void main(String a[]) {

		UsingChromeDriveronAmazon obj = new UsingChromeDriveronAmazon();

		 obj.invokeBrowser();

		 obj.getElemnetLocatorTechniquesUsingAmazon("http://amazon.in");

		 obj.closeBrowser(); 
		 
		/* obj.invokeBrowser();

		obj.getiFrameCountinFreeCRMWebApp("http://www.freecrm.com");

		obj.closeBrowser();
          */

	}

}
