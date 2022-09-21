package tests;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import readExcel.TestData;


public class HomePageTestDtPvd {
	
	@Test(dataProvider = "dp")                           //data provider with data provider method name 
	  public void login(String uName, String pwd) {             //send the parameters as string or object in method for data provider
		  
		//  System.setProperty("webdriver.chrome.driver", "C:\\Users\\sihik\\Desktop\\selBrowserDrives\\chromedriver_win32\\chromedriver.exe");
		  WebDriverManager.chromedriver().setup();
		  WebDriver	 driver = new ChromeDriver();
		  
		//Creating object of home page
			HomePage home = new HomePage(driver);
			
		//Creating object of Login page
		    LoginPage login = new LoginPage(driver);
			
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		  driver.get("https://demo.guru99.com/test/newtours/index.php");
		  driver.manage().window().maximize();
		  
		//Click on Login button
	    home.clickSignOn();
	    
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.urlContains("https://demo.guru99.com/test/newtours/login.php"));

	    
	  //Enter user name & password	
	  		login.enterUserName(uName);
	  		login.enterPassword(pwd);
	  	//	wait.until(ExpectedConditions.urlContains("https://demo.guru99.com/test/newtours/login.php"));

	  		
	  	//click on submit btn
	  	 login.clickSubmit();
	  }
	
	 @DataProvider
	  public Object[][] dp() throws IOException {
		  
		//object creation from class Testdata
		  
		//  TestData ed = new TestData();
		//  ReadingDataFromExcel ed = new  ReadingDataFromExcel();
		  
		    TestData excel = new TestData();
		    String filePath = System.getProperty("user.dir")+"\\testDataDemoG";                           //dir means directory         //test data is a name of the folder u created in the pom-example  in the windows explorer in java ecliose-->then pomexample there u created a new folder called test data
		    return excel.readExcel(filePath, "testData1.xlsx", "sheet1");                                 // testdata1.xslx is the name of the excel sheet i created a test data 
	  } 
		  

}
