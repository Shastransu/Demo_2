package com.text;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.NoClassDefFoundError;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class demo_2 {
	 WebDriver driver;
	@BeforeTest
	public void drive()
	{
		  System.setProperty("webdriver.chrome.driver","C:\\Users\\Training_b6b.00.10\\Desktop\\Browser And Drivers\\chromedriver.exe");
			 driver=new ChromeDriver();
	}
  @Test
  public void f() throws IOException {

	 String url="http://10.232.237.143:443/TestMeApp/fetchcat.htm";
	 driver.get(url);
	 driver.manage().window().maximize();
	 driver.findElement(By.linkText("SignIn")).click();
	 driver.findElement(By.name("userName")).click();
	 File src=new File("C:\\NexGen Testing Stream\\Selenium\\eclipse\\testdata.xlsx");
	 FileInputStream fis=new FileInputStream(src);
	 XSSFWorkbook wb=new XSSFWorkbook(fis);
	 XSSFSheet SH=wb.getSheetAt(0);
	 driver.findElement(By.name("userName")).sendKeys(SH.getRow(1).getCell(0).getStringCellValue());
	
	  
	 
  }
  @AfterTest
  public void closeApp()
  {
	  driver.close();
  }
}
