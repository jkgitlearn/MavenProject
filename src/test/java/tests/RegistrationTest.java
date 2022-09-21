package tests;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import pageObjects.RegistrationPage;
import readExcel.TestDataGuruDemo;

public class RegistrationTest {
	
WebDriver driver;
	
	@Test
	public void verifyFlightReg()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sihik\\Desktop\\selBrowserDrives\\chromedriver_win32\\chromedriver.exe");
		  driver = new ChromeDriver();
		  
		  RegistrationPage rgPage = new RegistrationPage(driver);                                                                      //created an object so we can call the elements from registration page
		                                                                                                                            // registrationpg object username and password is pranati, registrationpage2 object usrname and pwd is pranati1
		  
		  
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		  driver.get("https://demo.guru99.com/test/newtours/");
		  driver.manage().window().maximize();
		  
		  
		  rgPage.clickRegLink();
		  
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));                                                        //explicit wait is used to load or wait to find the element
		  wait.until(ExpectedConditions.urlContains("https://demo.guru99.com/test/newtours/register.php"));
		  
		  rgPage.setFirstName("pranati1");
		  rgPage.setLastName("kumar");
		  rgPage.setPhone("8142402254");
		  rgPage.setEmail("pranati@gmail.com");
		  rgPage.setAddress1("nizampet");
		  rgPage.setCity("hyderabad");
		  rgPage.setState("AP");
		  rgPage.setPostalCode("500074");
		  rgPage.setCountry("INDIA");
		  rgPage.setUserName("PRANATI1");
		  rgPage.setPassword("pranati1");
		  rgPage.setCPassword("pranati1");
		  rgPage.clickSubmit();
		  
		  //validation
		  
//		  if(driver.getPageSource().contains("Register: Mercury Tours"))
//		  {
//			  System.out.println("you register succesfully--passed");
//		  }else
//		  {
//			  System.out.println("your register failed");                                                                                  // either ways u can write if else or assert
//		  }
		  
		  Assert.assertEquals(driver.getTitle(), "Register: Mercury Tours");                                                               //this is hard assert if execution fails it wont execute rest of the code it stops
		  System.out.println("suscessfull");                                                                                               // if passes it will execute rest of the code
		  driver.close();     
		  
	}
	
	
 
}
