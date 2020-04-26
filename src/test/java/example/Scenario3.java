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
import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;



import org.openqa.selenium.chrome.ChromeDriver;

public class Scenario3 {
	 Information in=new Information();
	   String User= in.Username;
	   String Pass=in.Password;
	   int n=1;
	   public ExtentTest test;

	   @Test
	public void Scenario3() throws IOException, InterruptedException{
	   System.setProperty("webdriver.chrome.driver", "/Users/cassie/Downloads/chromedriver");
 	   WebDriver driver = new ChromeDriver();
	  
 	   test = Scenario1.extent.startTest("Scenario3");

	  //Step 2- Navigation: Open a website
	  driver.navigate().to("https://securex.bncollege.com/webapp/wcs/stores/servlet/BNCBLogonForm?catalogId=10001&langId=-1&storeId=17555&prevPage=LogonForm&disableGuestLogin=&ordItmMinusFreeDgItmCount=&postLogonURL=OrderCalculateMC%3FprevPage%3DLogonForm%26URL%3DBNCBMyAccountView%3FcatalogId%3D10001%26langId%3D-1%26storeId%3D17555");
	//  driver.manage().window().maximize();
	  Thread.sleep(2000);
	  this.takeSnapShot(driver, "/Users/cassie/eclipse-workspace/Assignment/Scenario3");
	  String urlAfter1 = driver.getCurrentUrl();
	  WebElement email_address = driver.findElement(By.xpath("//input[@id='logonId']"));
	  email_address.sendKeys(User+"@husky.neu.edu");
	  Thread.sleep(2000);
	  this.takeSnapShot(driver, "/Users/cassie/eclipse-workspace/Assignment/Scenario3");


	  //login
	  WebElement password = driver.findElement(By.xpath("//input[@id='logonPassword']"));
	  password.sendKeys(Pass);
	  Thread.sleep(2000);
	  this.takeSnapShot(driver, "/Users/cassie/eclipse-workspace/Assignment/Scenario3");



	  WebElement Login_btn = driver.findElement(By.xpath("/html/body/header/section/div[1]/div/div/div/div/div/div/div[5]/form/input[26]"));
	  Login_btn.click();
	//topNavSearch
	  try {
			Thread.sleep(2000);
			this.takeSnapShot(driver, "/Users/cassie/eclipse-workspace/Assignment/Scenario3");
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  String urlAfter2 = driver.getCurrentUrl();
      if (!urlAfter1.equals(urlAfter2)) {
            test.log(LogStatus.PASS, "Expected:Login to NU bookstore successfully<br>"+"Actual:Login to NU bookstore successfully.");
        } else {
            test.log(LogStatus.FAIL, "Expected:Login to NU bookstore successfully<br>"+"Actual:Login to NU bookstore unsuccessfully.");
        }
	  WebElement search = driver.findElement(By.xpath("//*[@id=\"topNavSearch\"]"));
	  search.sendKeys("HORNGREN'S COST\r\n" + 
	  		"ACCT.-TEXT");

	//*[@id="foo1"]/li
	  try {
			Thread.sleep(2000);
			  this.takeSnapShot(driver, "/Users/cassie/eclipse-workspace/Assignment/Scenario3");

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  driver.findElement(By.xpath("//*[@id=\"foo1\"]/li")).click();
	  try {
			Thread.sleep(2000);
			
			  this.takeSnapShot(driver, "/Users/cassie/eclipse-workspace/Assignment/Scenario3");

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  String urlAfter3 = driver.getCurrentUrl();
      if (!urlAfter2.equals(urlAfter3)) {
            test.log(LogStatus.PASS, "Expected:Search an item successfully<br>"+"Actual:Search an item successfully.");
        } else {
            test.log(LogStatus.FAIL, "Expected:Search an item successfully<br>"+"Actual:Search an item unsuccessfully.");
        }
      
	  driver.findElement(By.xpath("//*[@id=\"foo1\"]/li/a[1]/img")).click();
		Thread.sleep(2000);
		  this.takeSnapShot(driver, "/Users/cassie/eclipse-workspace/Assignment/Scenario3");
	      

	//*[@id="ADD_TO_CART_BUTTON"]
	  driver.findElement(By.xpath("//*[@id=\"TB_FORMAT_DIV_ID\"]")).click();
	  try {
		  Thread.sleep(2000);
		  this.takeSnapShot(driver, "/Users/cassie/eclipse-workspace/Assignment/Scenario3");

	  } catch (InterruptedException e) {
		  // TODO Auto-generated catch block
		  e.printStackTrace();
	  }
	//*[@id="TB_FORMAT_ID"]/li[1]
	  driver.findElement(By.xpath("//*[@id=\"TB_FORMAT_ID\"]/li[1]")).click();
	  try {
		  Thread.sleep(2000);
		  this.takeSnapShot(driver, "/Users/cassie/eclipse-workspace/Assignment/Scenario3");

	  } catch (InterruptedException e) {
		  // TODO Auto-generated catch block
		  e.printStackTrace();
	  }
	//*[@id="TB_FORMAT_ID"]/li[1]
	  driver.findElement(By.xpath("//*[@id=\"TBOrderItemAddForm\"]/div[1]/div/input[2]")).click();
	  String urlAfter4 = driver.getCurrentUrl();
      if (!urlAfter4.equals(urlAfter3)) {
            test.log(LogStatus.PASS, "Expected:Add item to cart successfully<br>"+"Actual:Add item to cart successfully.");
        } else {
            test.log(LogStatus.FAIL, "Expected:Add item to cart successfully<br>"+"Actual:Add item to cart unsuccessfully.");
        }
	  try {
			Thread.sleep(2000);
			this.takeSnapShot(driver, "/Users/cassie/eclipse-workspace/Assignment/Scenario3");

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
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
