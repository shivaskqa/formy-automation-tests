package SeleniumFirst;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StaticDropDowns {

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

			System.out.println("Before hitting the any links in page: " + driver.getCurrentUrl());

			selectJourneyType();
			selectFromandToPlace();
			Thread.sleep(4000);
			enterFromDateBySimpleXPath(6,15);
			enterToDateBySimpleXPath(6,20);
			Thread.sleep(5000);
			staticDropDownsByXPathForPassengers();
			Thread.sleep(5000);
			selectCurrency();
			Thread.sleep(2000);
			clickOnSearchBtn();
		}

		catch (Exception e) {

			e.printStackTrace();
		}
		
		finally
		{
			closeBrowser();
		}

	}

	/*
	 * This function is created for selected for Journey type as One Way By default
	 * this spicejet site is selected journey type as Oneway We'll verify the same
	 * with by checking WebElement / radio button is selected - Boolean value
	 */

	public void selectJourneyType()

	{

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//label[@for='ctl00_mainContent_rbtnl_Trip_0']"))).isDisplayed();

		boolean radioisSelected = driver
				.findElement(By.xpath("//input[@id='ctl00_mainContent_rbtnl_Trip_1']"))
				.isSelected();
		System.out.println(radioisSelected);

		// Check return date is disabled

		boolean rtndtPickerIsSelected = driver.findElement(By.xpath("//input[@id='ctl00_mainContent_view_date2']"))
				.isEnabled();
		System.out.print(rtndtPickerIsSelected);

	}

	public void selectFromandToPlace()

	{

		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']")).click();
        driver.findElement(By.xpath("//a[@value='HYD']")).click();
       
        driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_destinationStation1_CTXT']")).sendKeys("Del");
        //driver.findElement(By.linkText("Delhi (DEL)")).click();
        
        
      }

		
	//	driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_destinationStation1_CTXT']")).click();
		
	

	public void staticDropDownsByXPathForPassengers() throws InterruptedException {

		// WebDriverWait wait = new WebDriverWait(driver, 30);
		// wait.until(ExpectedConditions
		// .visibilityOfElementLocated(By.xpath("//label[@for='ctl00_mainContent_rbtnl_Trip_0']"))).isDisplayed();

		System.out.println("Clicking on Adults Drop Down");
		driver.findElement(By.xpath("//div[@id='divpaxinfo']")).click();
		Thread.sleep(3000);
		System.out.println("Clicking Adult Increment button for the first time");
		driver.findElement(By.xpath("//span[@id='hrefIncAdt']")).click();
		Thread.sleep(3000);

		System.out.println("Clicking on Adult Increment for the second  time");
		driver.findElement(By.xpath("//span[@id='hrefIncAdt']")).click();
		Thread.sleep(3000);

		System.out.println("Clicking on Adult Increment for the third time");
		driver.findElement(By.xpath("//span[@id='hrefIncAdt']")).click();
		Thread.sleep(3000);

		System.out.println("Clicking on Adult Increment for the fourth time");
		driver.findElement(By.xpath("//span[@id='hrefIncAdt']")).click();
		Thread.sleep(3000);

		System.out.println("Clicking on Adult decrement for the first time");
		driver.findElement(By.xpath("//span[@id='hrefDecAdt']")).click();

		// Providing count for childs

		System.out.println("Selecting child from passenger drop down");
		driver.findElement(By.xpath("//span[@id='hrefIncChd']")).click();
		Thread.sleep(2000);

		System.out.println("Selcting infant from Passenger drop down");
		driver.findElement(By.xpath("//span[@id='hrefIncInf']")).click();
		Thread.sleep(2000);

		// Click on Done
		driver.findElement(By.xpath("//input[@class='buttonN' and @id='btnclosepaxoption' and @value='Done']")).click();

		// Read the text from Passengers drop down
		WebElement element = driver.findElement(By.xpath("//div[@id='divpaxinfo']"));
		System.out.println(element.getText());

		Thread.sleep(2000);
	}

	public void selectCurrency()
	{
			
		WebElement selectBox = driver.findElement(By.xpath("//*[@id='ctl00_mainContent_DropDownListCurrency']"));
		Select select1 = new Select(selectBox );
		List<WebElement> page_options = select1 .getOptions();
		
		for(WebElement e : page_options)
		if(e.getText().equalsIgnoreCase("IND"))
            e.click();
		
	}
	
	public void clickOnSearchBtn()
	{
		
		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
		
	}
	
	public  void selectDate(String custDate)
	{
	
		String s[]=custDate.split("-");
		
		String Day=s[0];
		String Month=s[1];
		String year=s[2];
		
		//String xpathofDateWebElement="//input[@id='ctl00_mainContent_txt_Fromdate']/following-sibling::button[@class='ui-datepicker-trigger']";
		
		//driver.findElement(By.xpath(xpathofDateWebElement)).click();
		
		 
		List<WebElement> rows=driver.findElements(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']/table/tbody/tr"));
		 
		int rowsCount=rows.size();
		
		System.out.println(rowsCount);
	
		boolean flag=false;
		
		for(int i=1;i<=rowsCount;i++)
		{
			for (int j=1;j<=7;j++)
				
			{
				String xpathofDay = "//div[@class='ui-datepicker-group ui-datepicker-group-first']/table/tbody/tr["+i+"]/td["+j+"]";
			
			    System.out.println(xpathofDay);
			    
			    String dayfrmcal=driver.findElement(By.xpath(xpathofDay)).getText();
			    
			    System.out.println(dayfrmcal);
				
				if (Day.equals(dayfrmcal))
			    	
			    {
			    	driver.findElement(By.xpath(xpathofDay)).click();
			        flag=true;
			        break;
			    }
			    
			}
			
			 if(flag) { break; }
		}
	   
		
	}
	
	public void enterFromDateBySimpleXPath(int mon,int day)
	
	{
		
	
		driver.findElement(By.xpath("//td[@data-month='"+mon+"' and @data-year='2019']/a[contains(text(),'"+day+"')]")).click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
   public void enterToDateBySimpleXPath(int mon,int day)
	
	{
		
	    driver.findElement(By.id("ctl00_mainContent_view_date2")).click();
		driver.findElement(By.xpath("//td[@data-month='"+mon+"' and @data-year='2019']/a[contains(text(),'"+day+"')]")).click();
		
	
	}
	
	
	public void closeBrowser()

	{

		driver.quit();
	}

	public static void main(String[] args) {

		StaticDropDowns obj = new StaticDropDowns();
		obj.invokeBrowser("https://www.spicejet.com");
		//obj.closeBrowser();

	}

}
