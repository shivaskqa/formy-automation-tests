package SeleniumFirst;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class UsingChromeDriver {

	WebDriver driver;

	public void invokeBrowser(String url) {

		try {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\skandha\\chromedriver.exe");

			driver = new ChromeDriver();

			driver.manage().deleteAllCookies();

			driver.manage().window().maximize();

			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

			driver.get(url);

			System.out.println("Before hitting the any links in page" + driver.getCurrentUrl());

			getElemnetLocatorTechniquesUsingFacebook();
		}

		catch (Exception e) {

			e.printStackTrace();
		}

	}

	public void getElemnetLocatorTechniquesUsingFacebook()

	{

		try {

			// Entering first name while signing-up in facebook application
			driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("NagaSkandha");

			// Entering lastname in the respective field while registering
			driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Konduru");

			// Entering Mobile number while registering
			driver.findElement(By.xpath("//input[@id='u_0_o']")).sendKeys("9052145647");

			// Entering user chosen password
			driver.findElement(By.xpath("//input[@data-type='password']")).sendKeys("ShivaShivani4all#");

			Select selectBirthDay = new Select(driver.findElement(By.xpath("//select[@id='day']")));

			// Selecting Day in Date of Birth drop-down fields
			selectBirthDay.selectByIndex(5);

			Select selectMonth = new Select(driver.findElement(By.xpath("//select[@id='month']")));

			// Selecting month in Date of Birth drop-down fields
			selectMonth.selectByIndex(11);

			Select selectYear = new Select(driver.findElement(By.xpath("//select[@id='year']")));

			// Selecting year in Date of Birth drop-down fields
			selectYear.selectByValue("2014");

			WebElement radioMalebutton = driver.findElement(By.xpath("//input[@id='u_0_a']"));

			radioMalebutton.click();
			
			Thread.sleep(5000);

			boolean selectedValue = radioMalebutton.isSelected();

			System.out.println(selectedValue);

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public void closeBrowser()

	{

		driver.quit();

	}

	public static void main(String a[]) {

		UsingChromeDriver obj = new UsingChromeDriver();

		obj.invokeBrowser("https://www.facebook.com");

		obj.closeBrowser();
		
	}
}
