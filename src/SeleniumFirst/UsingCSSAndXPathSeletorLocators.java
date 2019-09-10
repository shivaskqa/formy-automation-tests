package SeleniumFirst;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class UsingCSSAndXPathSeletorLocators {

	WebDriver driver;

	public void invokeBrowser(String url)

	{

		try {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\skandha\\geckodriver.exe");

			driver = new FirefoxDriver();

			driver.manage().deleteAllCookies();

			driver.manage().window().maximize();

			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

			driver.get(url);

			System.out.println("Before hitting the any links in page" + driver.getCurrentUrl());

			getCSSElementLocatorTechniques();
		}

		catch (Exception e) {

			e.printStackTrace();
		}

	}

	public void getCSSElementLocatorTechniques() {

		/*
		 * 
		 * Finding the elements with XPath in Firefox Open Firefox browser, hit FB URL,
		 * goto particular web element right click and do inspect element Goto, console
		 * , check with xpath with this syntax: $x("<<xpath>>") xpath syntax:
		 * //tagname[@attribute='value']; $x("//tagname[@attribute='value']");
		 * 
		 * 
		 * 
		 * // Following are Lines of code for identifying Email,Password and Login
		 * buttons and perform the action in FB
		 * 
		 * driver.findElement(By.xpath("//input[@id='email']")).sendKeys("emailid");
		 * driver.findElement(By.xpath("//*[@id='pass']")).sendKeys("password");
		 * driver.findElement(By.xpath("//*[@value='Log In']")).click();
		 * 
		 */

		/*
		 * 
		 * Finding the Web Elements with CSS locator technique
		 * 
		 * CSS Syntax : tagname[attribute='value']
		 * 
		 * $("input[name='email']")
		 */

		driver.findElement(By.cssSelector("input[name='email']")).sendKeys("shiva");

		// With XPath regular express
		driver.findElement(By.xpath("//input[contains(@name,'ema')]")).sendKeys("Skandha");
		// By using CSS Selector
		driver.findElement(By.cssSelector("input#pass"));
		// Wihtout tagname
		driver.findElement(By.xpath("//*[@value='Log In']"));
		driver.findElement(By.cssSelector("input[name='pass']")).sendKeys("konduru");
		driver.findElement(By.cssSelector("input[type='submit']")).click();

	}

	public void closeBrowser()

	{

		driver.quit();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		UsingCSSAndXPathSeletorLocators obj = new UsingCSSAndXPathSeletorLocators();
		obj.invokeBrowser("http://www.facebook.com");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		obj.closeBrowser();

	}

}
