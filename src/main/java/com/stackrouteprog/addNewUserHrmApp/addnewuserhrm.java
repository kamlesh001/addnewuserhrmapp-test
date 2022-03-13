package com.stackrouteprog.addNewUserHrmApp;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class addnewuserhrm {
	
	public WebDriver loginhrmapp(WebDriver driver1)
	{
		driver1.get("https://opensource-demo.orangehrmlive.com/index.php/admin/viewSystemUsers");
		driver1.manage().window().maximize();
		driver1.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
		driver1.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("admin123");
		driver1.findElement(By.xpath("//input[@id='btnLogin']")).click();
		return driver1;
	}
	
	public void adduser(WebDriver driver2) throws InterruptedException
	{
		
		String generatedString = RandomStringUtils.randomAlphabetic(10);
		Actions at = new Actions(driver2);
		String uname = "harry001"+ generatedString;
		String passw = "harry@1085"+ generatedString;
		at.moveToElement(driver2.findElement(By.xpath("//a[@id='menu_admin_UserManagement']"))).perform();
		driver2.findElement(By.xpath("//a[@id='menu_admin_viewSystemUsers']")).click();
		driver2.findElement(By.xpath("//input[@id='btnAdd']")).click();
		driver2.findElement(By.xpath("//input[@id='systemUser_employeeName_empName']")).sendKeys("Harry Kane");
		driver2.findElement(By.xpath("//input[@id='systemUser_userName']")).sendKeys(uname);
		driver2.findElement(By.xpath("//input[@id='systemUser_password']")).sendKeys(passw);
		driver2.findElement(By.xpath("//input[@id='systemUser_confirmPassword']")).sendKeys(passw);
		driver2.findElement(By.xpath("//input[@id='btnSave']")).click();
		Thread.sleep(2000);
		driver2.findElement(By.xpath("//input[@id='searchSystemUser_userName']")).sendKeys(uname);
		driver2.findElement(By.xpath("//input[@id='searchBtn']")).click();
		((JavascriptExecutor) driver2)
	     .executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(5000);
		String username = driver2.findElement(By.xpath("//*[@id=\"resultTable\"]/tbody/tr/td[2]/a")).getText();
		if(uname.equals(username))
		{
		System.out.println("New User added successfully");
		}
		else
		{
			System.out.println("New User not added");
		}
			
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub.
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		addnewuserhrm newuser = new addnewuserhrm();
		WebDriver driver1 = newuser.loginhrmapp(driver);
		newuser.adduser(driver1);
			
	}

}
