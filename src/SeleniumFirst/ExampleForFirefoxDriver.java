package SeleniumFirst;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ExampleForFirefoxDriver {

	WebDriver driver;

	public void invokeBrowser(String url) {

		try {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\skandha\\geckodriver.exe");

			driver = new FirefoxDriver();

			driver.manage().deleteAllCookies();

			driver.manage().window().maximize();

			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

			driver.get(url);

			System.out.println("Before hitting the any links in page" + driver.getCurrentUrl());

			getElemnetLocatorTechniques();
		}

		catch (Exception e) {

			e.printStackTrace();
		}

	}

	public void getElemnetLocatorTechniques() {

		driver.findElement(By.linkText("Today's Deals")).click();

		String currenturl = driver.getCurrentUrl();

		System.out.println("This is Current URL of the window" + currenturl);

		System.out.println(driver.getTitle());

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.navigate().back();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.findElement(By.xpath("//*[@id='nav-your-amazon']")).click();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(driver.getTitle());

	}

	public void closeBrowser() {

		try {
			driver.quit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

		ExampleForFirefoxDriver obj = new ExampleForFirefoxDriver();

		obj.invokeBrowser("http://www.amazon.in");

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		obj.closeBrowser();

	}

}
