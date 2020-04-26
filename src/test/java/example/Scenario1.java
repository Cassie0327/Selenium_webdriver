package example;

import org.openqa.selenium.By;		
import org.openqa.selenium.WebDriver;		
import org.openqa.selenium.firefox.FirefoxDriver;	
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;




public class Scenario1 {
	 private WebDriver driver;
	 int n=1;
	 public static ExtentReports extent;
	    public ExtentTest test;
	    Information in=new Information();
	   String User= in.Username;
	   String Pass=in.Password;
	   
	 @Test
	  public  void Scenario1()  throws InterruptedException, IOException {
		 System.setProperty("webdriver.chrome.driver", "/Users/cassie/Downloads/chromedriver");
		 driver = new ChromeDriver();
		 driver.get("https://my.northeastern.edu/");
	     driver.navigate().to("https://my.northeastern.edu/");
	     extent = new ExtentReports("/Users/cassie/eclipse-workspace/Assignment/Report.html", true);
	     test = extent.startTest("Scenario1");
	     Thread.sleep(2000);
	     this.takeSnapShot(driver, "/Users/cassie/eclipse-workspace/Assignment/Scenario1");
	     WebElement gologin=driver.findElement(By.xpath("//*[@id=\"portlet_com_liferay_journal_content_web_portlet_JournalContentPortlet_INSTANCE_GhAIpHlwoE3O\"]/div/div/div/div[2]/div/div[2]/div/a"));
	     gologin.click();
	     Thread.sleep(2000);
	     this.takeSnapShot(driver, "/Users/cassie/eclipse-workspace/Assignment/Scenario1");
	      WebElement Username = driver.findElement(By.id("username"));
	      Username.sendKeys(User);
	      Thread.sleep(2000);
		  this.takeSnapShot(driver, "/Users/cassie/eclipse-workspace/Assignment/Scenario1");
	      WebElement password = driver.findElement(By.id("password"));
	      password.sendKeys(Pass); 
	      Thread.sleep(2000);
		  this.takeSnapShot(driver, "/Users/cassie/eclipse-workspace/Assignment/Scenario1");
	      String urlBefore = driver.getCurrentUrl();
	      driver.findElement(By.name("_eventId_proceed")).click();
	      Thread.sleep(20000);
		  this.takeSnapShot(driver, "/Users/cassie/eclipse-workspace/Assignment/Scenario1");
	      String urlAfter = driver.getCurrentUrl();
	      if (!urlAfter.equals(urlBefore)) {
	            test.log(LogStatus.PASS, "Expected:Login to My NEU portal successfully<br>"+"Actual:Login to My NEU portal successfully.");
	        } else {
	            test.log(LogStatus.FAIL, "Expected:Login to My NEU portal successfully<br>"+"Actual: Login to My NEU portal unsuccessfully.");
	        }
	      WebElement history=driver.findElement(By.xpath("//*[@id=\"my-recent-links\"]/div/div/ul/li[3]/i"));
	      history.click();
	      Thread.sleep(2000);
		  this.takeSnapShot(driver, "/Users/cassie/eclipse-workspace/Assignment/Scenario1");
		  if(driver.findElement(By.xpath("//*[@id=\"my-links\"]/div/div/ul/li/a/div")).isDisplayed())
	      {
	            test.log(LogStatus.PASS, "Expected:Add items to My Favorites successfully<br>"+"Actual:Add items to My Favorites successfully.");

	      }
	      else {
	            test.log(LogStatus.FAIL, "Expected:Add items to My Favorites successfully<br>"+"Actual:Add items to My Favorites unsuccessfully.");
	        }
		  
		  extent.endTest(test);
	      extent.flush();
          driver.quit();


	  }

	  @BeforeTest
	

	 
	  public  void takeSnapShot(WebDriver webdriver,String fileWithPath) throws IOException {

		  	
	        TakesScreenshot scrShot =((TakesScreenshot)webdriver);
	        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
	        File DestFile=new File(fileWithPath+"/test"+n+".png");
	        FileUtils.copyFile(SrcFile, DestFile);
	        n++;

	    }

	
  
 
}
