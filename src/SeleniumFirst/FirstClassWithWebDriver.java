/**
 * 
 */
package SeleniumFirst;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author skandha
 *
 */
public class FirstClassWithWebDriver {
			
	public static void main(String a[])
	
	{
		
	System.setProperty("webdriver.chrome.driver","C:\\Users\\skandha\\chromedriver.exe");
	
	WebDriver driver = new ChromeDriver();
	
	driver.get("https://www.google.com/");
	
	driver.manage().window().maximize();
	
	System.out.println(driver.getTitle());
	
	driver.quit();
	
	}

}
