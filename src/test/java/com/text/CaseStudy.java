package com.text;
import java.util.*;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class CaseStudy {
	WebDriver driver;
	//String name="zzzaaa787";
Scanner sc=new Scanner(System.in);
String name=sc.nextLine();
	
	@BeforeTest
	public void configure()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Training_b6b.00.10\\Desktop\\Browser And Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		
	}
	@BeforeTest
	public void startReport()
	{
		String url="http://10.232.237.143:443/TestMeApp/fetchcat.htm";
		driver.get(url);
		 driver.manage().window().maximize();
		
	}
  @Test(priority=1)
  public void signup() throws InterruptedException {
	  Random rand=new Random();
	  int val=rand.nextInt(6);
	  driver.findElement(By.linkText("SignUp")).click();
	  driver.findElement(By.name("userName")).sendKeys(name);
	  driver.findElement(By.name("firstName")).click();
	  String sss=driver.findElement(By.xpath("//*[@id=\'err\']")).getText();
	  if(sss.equals("Available"))
	  {
	  driver.findElement(By.name("firstName")).sendKeys("shastransu");
	  driver.findElement(By.name("lastName")).sendKeys("Suprabh");
	  driver.findElement(By.name("password")).sendKeys("Suprabh01");
	  driver.findElement(By.name("confirmPassword")).sendKeys("Suprabh01");
	  driver.findElement(By.xpath("//input[@id='gender' and @value='Male']")).click();
	  driver.findElement(By.name("emailAddress")).sendKeys("shastransu@gmail.com");
	  driver.findElement(By.name("mobileNumber")).sendKeys("999999999"+val);
	  driver.findElement(By.xpath("//img[@class='ui-datepicker-trigger']")).click();
	  Select SelYear=new Select(driver.findElement(By.className("ui-datepicker-year")));
	  SelYear.selectByVisibleText("1998");
	  Select SelMon=new Select(driver.findElement(By.className("ui-datepicker-month")));
	  SelMon.selectByVisibleText("Jan");
	  driver.findElement(By.linkText("28")).click();
	  
	  driver.findElement(By.id("address")).sendKeys("Bengaluru");
	  Select catSel=new Select(driver.findElement(By.name("securityQuestion")));
	  catSel.selectByIndex(val);
	  driver.findElement(By.name("answer")).sendKeys("kdvcsgcgh");
	  driver.findElement(By.name("Submit")).click();
}
	  else
	  {
		  driver.findElement(By.xpath("/html/body/header/div/b/a")).click();
		  driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/ul/li[1]/a")).click();
	  }
  }
  
  @Test(priority=2)
  public void login() throws InterruptedException
  {
	  Thread.sleep(2000);
	  driver.findElement(By.name("userName")).sendKeys(name);
	  driver.findElement(By.name("password")).sendKeys("Suprabh01");
	  driver.findElement(By.name("Login")).click();
  }
  
  @Test(priority=3)
  public void testCart() throws InterruptedException
  {
	  Thread.sleep(2000);
	  driver.findElement(By.name("products")).click();
	  driver.findElement(By.name("products")).sendKeys("Headphone");
	  driver.findElement(By.xpath("/html/body/div[1]/form/input")).click();
	  //driver.findElement(By.name("val")).click();
	  driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div/div/div/div[2]/center/a")).click();
  }
  @Test(priority=4)
  public void testPayment() throws InterruptedException
  {
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/a[2]")).click();
	  driver.findElement(By.xpath("//*[@id=\"cart\"]/tfoot/tr[2]/td[5]/a")).click();
	  driver.findElement(By.name("ShippingAdd")).sendKeys("Keerthi Karthik Harmony");
	  Thread.sleep(500);
	  driver.findElement(By.xpath("//input[@value='Proceed to Pay']")).click();
	  Thread.sleep(5000);
	  driver.findElement(By.xpath("//*[@id=\"swit\"]/div[1]/div/label/i")).click();
	  driver.findElement(By.xpath("//*[@id=\"btn\"]")).click();
	  driver.findElement(By.name("username")).sendKeys("123456");
	  driver.findElement(By.name("password")).sendKeys("Pass@456");
	  driver.findElement(By.xpath("//input[@type='submit']")).click();
	  driver.findElement(By.name("transpwd")).sendKeys("Trans@456");
	  driver.findElement(By.xpath("//input[@value='PayNow']")).click();
	  driver.findElement(By.xpath("/html/body/header/div/div/ul/b/a[2]")).click();
  }
  @AfterMethod
  public void AfterMethod()
  {
	  ExtentHtmlReporter reporter=new ExtentHtmlReporter("C:\\Users\\Training_b6b.00.10\\Desktop\\caseReport.html");
	  ExtentReports extent=new ExtentReports();
	  extent.attachReporter(reporter);
	  ExtentTest logger1=extent.createTest("SignUp");
	  ExtentTest logger2=extent.createTest("SignIn");
	  ExtentTest logger3=extent.createTest("AddToCart");
	  ExtentTest logger4=extent.createTest("Payment Gateway");
	  logger1.log(Status.PASS,"The signup is created successfully");
	  logger2.log(Status.PASS, "The log in is completed successfully");
	  logger3.log(Status.PASS, "The product is added successfully");
	  logger4.log(Status.PASS, "The payment gateway is done sucessfully");
	  extent.flush();
 }
  @AfterTest
  public void endreporter()
  {
	  driver.close();
  }
 }
