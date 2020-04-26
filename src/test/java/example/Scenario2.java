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

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import java.util.*;



public class Scenario2 {
	   Information in=new Information();
	   String User= in.Username;
	   String Pass=in.Password;
	   int n=1;
	public ExtentTest test;
      @Test
      public void Scenario2 () throws InterruptedException, IOException {
    	  System.setProperty("webdriver.chrome.driver", "/Users/cassie/Downloads/chromedriver");
   	   	  WebDriver driver = new ChromeDriver();
 	      test = Scenario1.extent.startTest("Scenario2");


   	   	  driver.get("https://my.northeastern.edu/");
          Thread.sleep(2000);
 	      this.takeSnapShot(driver, "/Users/cassie/eclipse-workspace/Assignment/Scenario2");
          driver.findElement(By.xpath("//*[@id=\"portlet_com_liferay_journal_content_web_portlet_JournalContentPortlet_INSTANCE_GhAIpHlwoE3O\"]/div/div/div/div[2]/div/div[2]/div/a")).click();
          Thread.sleep(2000);
 	      this.takeSnapShot(driver, "/Users/cassie/eclipse-workspace/Assignment/Scenario2");
          //login
  	     String urlBefore1 = driver.getCurrentUrl();
          driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys(User);
          Thread.sleep(2000);
 	      this.takeSnapShot(driver, "/Users/cassie/eclipse-workspace/Assignment/Scenario2");
          driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(Pass);
          Thread.sleep(2000);
 	      this.takeSnapShot(driver, "/Users/cassie/eclipse-workspace/Assignment/Scenario2");
 	      driver.findElement(By.xpath("/html/body/section/div/div[1]/div/form/div[3]/button")).click();
          Thread.sleep(20000);
 	      this.takeSnapShot(driver, "/Users/cassie/eclipse-workspace/Assignment/Scenario2");
 	     String urlAfter1 = driver.getCurrentUrl();
	      if (!urlAfter1.equals(urlBefore1)) {
	            test.log(LogStatus.PASS, "Expected:Login to My NEU portal successfully<br>"+"Actual:Login to My NEU portal successfully.");
	        } else {
	            test.log(LogStatus.FAIL, "Expected:Login to My NEU portal successfully<br>"+"Actual: Login to My NEU portal unsuccessfully.");
	        }
          //go to course registration page
          driver.findElement(By.xpath("//*[@id=\"layout_2\"]/a")).click();
          Thread.sleep(2000);
 	      this.takeSnapShot(driver, "/Users/cassie/eclipse-workspace/Assignment/Scenario2");
 	      String urlBefore2 = driver.getCurrentUrl();
          driver.findElement(By.xpath("//*[@id=\"portlet_com_liferay_asset_publisher_web_portlet_AssetPublisherPortlet_INSTANCE_VGn3ZknJvwnV\"]/div/div/div/div[4]/div[2]/div/div[1]/div[4]/a")).click();
          Thread.sleep(3000);
          List<String> windows=new ArrayList<String>(driver.getWindowHandles());
          driver.switchTo().window(windows.get(1));
 	      this.takeSnapShot(driver, "/Users/cassie/eclipse-workspace/Assignment/Scenario2");
 	     String urlAfter2 = driver.getCurrentUrl();
	      if (!urlAfter2.equals(urlBefore2)) {
	            test.log(LogStatus.PASS, "Expected:Go to course registration page successfully<br>"+"Actual:Go to course registration page successfully.");
	        } else {
	            test.log(LogStatus.FAIL, "Expected:Go to course registration page successfully<br>"+"Actual:Go to course registration page unsuccessfully.");
	        }

          //click on class search
          driver.findElement(By.xpath("//*[@id=\"classSearchLink\"]/span")).click();
          Thread.sleep(2000);
 	      this.takeSnapShot(driver, "/Users/cassie/eclipse-workspace/Assignment/Scenario2");
          String urlAfter3 = driver.getCurrentUrl();
	      if (!urlAfter3.equals(urlAfter2)) {
	            test.log(LogStatus.PASS, "Expected:Go to Select a Term page successfully<br>"+"Actual:Go to Select a Term page successfully.");
	        } else {
	            test.log(LogStatus.FAIL, "Expected:Go to Select a Term page successfully<br>"+"Actual:Go to Select a Term page unsuccessfully.");
	        }
          driver.findElement(By.xpath("//*[@id=\"select2-chosen-1\"]")).click();
          Thread.sleep(2000);
          this.takeSnapShot(driver, "/Users/cassie/eclipse-workspace/Assignment/Scenario2");

          driver.findElement(By.xpath("//*[@id=\"select2-result-label-6\"]")).click();
          Thread.sleep(2000);
 	      this.takeSnapShot(driver, "/Users/cassie/eclipse-workspace/Assignment/Scenario2");
 	    
          //select 2020 summer fall term
          driver.findElement(By.xpath("//*[@id=\"term-go\"]")).click();
          Thread.sleep(2000);
 	      this.takeSnapShot(driver, "/Users/cassie/eclipse-workspace/Assignment/Scenario2");
 	     String urlAfter4 = driver.getCurrentUrl();
	      if (!urlAfter4.equals(urlAfter3)) {
	            test.log(LogStatus.PASS, "Expected:Go to Browse Classes page successfully<br>"+"Actual:Go to Browse Classes page successfully.");
	        } else {
	            test.log(LogStatus.FAIL, "Expected:Go to Browse Classes page successfully<br>"+"Actual:Go to Browse Classes page unsuccessfully.");
	        }
      
          //start search
          driver.findElement(By.xpath("//*[@id=\"search-go\"]")).click();
          Thread.sleep(2000);
	      if (driver.findElement(By.xpath("//*[@id=\"search-again-button\"]")).isDisplayed()) {
	            test.log(LogStatus.PASS, "Expected:Browse classes for full summer 2020 successfully<br>"+"Actual:Browse classes for full summer 2020 successfully.");
	        } else {
	            test.log(LogStatus.FAIL, "Expected:Browse classes for full summer 2020 successfully<br>"+"Actual:Browse classes for full summer 2020 unsuccessfully.");
	        }
      
 	      this.takeSnapShot(driver, "/Users/cassie/eclipse-workspace/Assignment/Scenario2");
          Scenario1.extent.endTest(test);
 	      Scenario1.extent.flush();
          driver.quit();
    



      }
	  public  void takeSnapShot(WebDriver webdriver,String fileWithPath) throws IOException {

		  	
	        TakesScreenshot scrShot =((TakesScreenshot)webdriver);
	        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
	        File DestFile=new File(fileWithPath+"/test"+n+".png");
	        FileUtils.copyFile(SrcFile, DestFile);
	        n++;

	    }
  }

