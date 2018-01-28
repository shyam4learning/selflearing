package Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ExcelUtilities.ExcelUtilities;
import logs.Log;
public class Utilities {
	
	public static WebDriver driver = null;

	public static WebDriver openBrowser(int testCaserow)

	{

		String browserName = ExcelUtilities.readCellData(testCaserow, Constants.col_BrowserName);

		System.out.println("browser name is " + browserName);
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", Constants.DriverURl);
			driver = new ChromeDriver();

		}
		return driver;
	}

	
	
	public static void moveToElement(WebElement element,String subelement)
	{
		
		try
		{
			
		Actions action=new Actions(driver);
		
		action.moveToElement(driver.findElement(By.xpath("//*[text()='Product Category']"))).perform();
		
		Thread.sleep(1000);
		
        
        if(subelement.equals("Accessories")){
			 
        	action.moveToElement(driver.findElement(By.xpath("//a[text()='Accessories']"))).perform();

        	 Log.info("Accessories link is found under Product Category");
         }
         if(subelement.equals("iMacs")){
        	 action.moveToElement(driver.findElement(By.linkText("iMacs")));
        	 Log.info("iMacs link is found under Product Category");
         }
         if(subelement.equals("iPads")){
        	 action.moveToElement(driver.findElement(By.linkText("iPads")));
        	 Log.info("iPads link is found under Product Category");
         }
         if(subelement.equals("iPhones")){
        	 action.moveToElement(driver.findElement(By.linkText("iPhones")));
        	 Log.info("iPhones link is found under Product Category");
         }
         action.click();
         action.perform();
         Log.info("Click action is performed on the selected Product Type");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	
	public static void waitForElement(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 2000);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public static String getTestCaseName(String sTestCase)

	{
		String value = sTestCase;

		int posi = value.indexOf("@");

		value = value.substring(0, posi);
		posi = value.lastIndexOf(".");

		value = value.substring(posi + 1);

		return value;
	}

	
}
