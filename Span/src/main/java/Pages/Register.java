package Pages;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Register extends Baseclass{
	
	public static String emailID;
	static String signup = Baseclass.properties.getProperty("Signup");
	static String Next = Baseclass.properties.getProperty("Next");
	static String fName = Baseclass.properties.getProperty("FirstName");
	static String lName = Baseclass.properties.getProperty("LastName");
	static String eMail = Baseclass.properties.getProperty("Email");
	static String mobile = Baseclass.properties.getProperty("Phone");
	static String country_choose = Baseclass.properties.getProperty("Country");
	static String Gender = Baseclass.properties.getProperty("Gender");
	static String Go = Baseclass.properties.getProperty("Submit");

	public static void Signup(String SignUp_Email,String firstName,String lastName,String emailAddr,String phone,String countryName) throws IOException {
		
		driver.findElement(By.xpath(signup)).sendKeys(SignUp_Email);
		
		driver.findElement(By.xpath(Next)).click();
		
		int fiName = firstName.length();
		
		if (firstName.length() > 3) {
		
			driver.findElement(By.xpath(fName)).sendKeys(firstName);
		} 
		else 
		{
			System.out.println("Assertion Failed....");
			StatusWriteExcel.statusWrite("Fail");
			assertEquals(fiName, fiName > 3);
		}
		
		driver.findElement(By.xpath(lName)).sendKeys(lastName);
		
		driver.findElement(By.xpath(eMail)).sendKeys(emailAddr);
	
		//	String phoneNo = Integer.toString(phone);
		
		//System.out.println(String.valueOf(phone).length());
		
		if (String.valueOf(phone).length() == 10) {
		
			driver.findElement(By.xpath(mobile)).sendKeys(String.valueOf(phone));
			
			assertEquals(String.valueOf(phone).length(), 10);
		} 
		else
		{
			StatusWriteExcel.statusWrite("Fail");
		}
		dropDownSelction(countryName);
		
		driver.findElement(By.xpath(Gender)).click();
		
		StatusWriteExcel.statusWrite("Pass");
	}

	public static void dropDownSelction(String countryName) {
		
		WebElement cNames = driver.findElement(By.xpath(country_choose));
		
		Select dropdownoptions = new Select(cNames);
		
		dropdownoptions.selectByVisibleText(countryName);
	}
	
	
	}

