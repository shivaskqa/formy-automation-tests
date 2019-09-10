package SeleniumFirst;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class FindingWebElementUsingXPathParent {

	WebDriver driver = null;

	public void invokeBrowser(String url)

	{

		try {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\skandha\\chromedriver.exe");

			driver = new ChromeDriver();

			driver.manage().deleteAllCookies();

			driver.manage().window().maximize();

			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

			driver.get(url);

			System.out.println("Before hitting the any links in page" + driver.getCurrentUrl());

			getParentXPathofWebElement();
		}

		catch (Exception e) {

			e.printStackTrace();
		}

	}

	public void getParentXPathofWebElement() {

		// Finding the WebElement with Parent via XPath when there is not unique
		// attributes to find the WebElement.
		// XPath of Parent : //div[@id='fkbx'] - Parent of Google Search box in
		// http://www.google.in
		//

		driver.findElement(By.xpath("//nav[@class='navbar-collapse collapse']/ul/li[2]/a")).click();

		try {

			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void closeBrowser()

	{

		driver.quit();
	}

	public static void main(String[] args) {

		FindingWebElementUsingXPathParent obj = new FindingWebElementUsingXPathParent();
		obj.invokeBrowser("http://www.qaclickacademy.com");
		obj.closeBrowser();

	}

}
