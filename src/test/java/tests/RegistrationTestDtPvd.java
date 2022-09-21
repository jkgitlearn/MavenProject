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

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.RegistrationPage;
import pageObjects.RegistrationPageFtry;
import readExcel.TestData;
import readExcel.TestDataGuruDemo;
import pageObjects.HomePage;


public class RegistrationTestDtPvd {
 
	@Test(dataProvider = "dp")
	 public void flightReg(String firstName, String lastName, String phone, String email, String address1, String city, String state, 
			 String postalCode, String country, String userName, String password, String confirmPassword)
	
			 
	 {
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\sihik\\Desktop\\selBrowserDrives\\chromedriver_win32\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		  
		//Creating object of home page
		//HomePage home = new HomePage(driver);
			
		//Creating object of Login page
	//	RegistrationPage reg = new RegistrationPage(driver);
		RegistrationPageFtry reg = new RegistrationPageFtry(driver);
		    
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	    driver.get("https://demo.guru99.com/test/newtours/index.php");
	    driver.manage().window().maximize();
		    
		reg.clickRegLink();
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));                                                      //explicit wait is used to load or wait to find the element
		wait.until(ExpectedConditions.urlContains("https://demo.guru99.com/test/newtours/register.php"));
		
	//	System.out.println("firstname is " + firstName);
		
		//Enter reg form		
		reg.setFirstName(firstName);
		reg.setLastName(lastName);
		reg.setPhone(phone);
		reg.setEmail(email);
		reg.setAddress1(address1);
		reg.setCity(city);
		reg.setState(state);
		reg.setPostalCode(postalCode);
	    reg.setCountry(country);
		reg.setUserName(userName);
		reg.setPassword(password);
		reg.setCPassword(confirmPassword);
		reg.clickSubmit();
		
		System.out.println("came here");
		
	    Assert.assertEquals(driver.getTitle(), "Register: Mercury Tours");             // ucan also write current url instead get title
	    System.out.println("suscessfull");   
	    wait.until(ExpectedConditions.urlContains("https://demo.guru99.com/test/newtours/register_sucess.php"));
	    driver.close();
	 }
	
	 @DataProvider
	  public Object[][] dp() throws IOException 
	  {
		 TestData excel = new TestData();
	//	 TestDataGuruDemo excel = new TestDataGuruDemo();
		 String filePath = System.getProperty("user.dir")+"\\testDataDemoG"; 
		 return excel.readExcel(filePath, "testDataDGuru1.xlsx", "Sheet1"); 
	  }
	
}
