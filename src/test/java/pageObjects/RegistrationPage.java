package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage {
	
		
WebDriver driver;
	
	By regLink= By.linkText("REGISTER");  // finding by By. locator , finding all the elements by.id or by. name or by.xpath
	By firstName= By.name("firstName");
	By lastName= By.name("lastName");
	By phone= By.name("phone");
	By email= By.name("userName");
	By address1= By.name("address1");
//	By address2= By.name("REGISTER");
	By city= By.name("city");
	By state= By.name("state");
	By postalCode= By.name("postalCode");
	By country= By.name("country");
	By userName= By.xpath("//input[@id='email']");
	By password= By.name("password");
	By confirmPassword= By.name("confirmPassword");
	By submitBtn= By.name("submit");
	
	public RegistrationPage(WebDriver d)                                                                                                //created a constructor ,constructor name will be same as class name
	{
		driver=d;
	}
	
	public void clickRegLink() 
	{
		driver.findElement(regLink).click();
	}
	
	public void setFirstName(String fName) 
	{
		driver.findElement(firstName).sendKeys(fName);
	}
	
	public void setLastName(String lName) 
	{
		driver.findElement(lastName).sendKeys(lName);
	}
	
	public void setPhone(String ph) 
	{
		driver.findElement(phone).sendKeys(ph);
	}
	
	public void setEmail(String mail) 
	{
		driver.findElement(email).sendKeys(mail);
	}
	
	public void setAddress1(String addr1) 
	{
		driver.findElement(address1).sendKeys(addr1);
	}
	
	public void setCity(String ci) 
	{
		driver.findElement(city).sendKeys(ci);
	}
	
	public void setState(String st) 
	{
		driver.findElement(state).sendKeys(st);
	}
	
	public void setPostalCode(String code) 
	{
		driver.findElement(postalCode).sendKeys(code);
	}
	
	public void setCountry(String ctry) 
	{
		WebElement con = driver.findElement(country);
		Select drop = new Select(con);
		drop.selectByVisibleText(ctry);
	}
	
	public void setUserName(String uname) 
	{
		driver.findElement(userName).sendKeys(uname);
	}
	
	public void setPassword(String pwd) 
	{
		driver.findElement(password).sendKeys(pwd);
	}
	
	
	public void setCPassword(String confirmPwd) 
	{
		driver.findElement(confirmPassword).sendKeys(confirmPwd);
	}
	
	public void clickSubmit()
	{
		driver.findElement(submitBtn).click();
	}
	

}
