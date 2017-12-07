package com.dice.step_definations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.dice.pages.LoginPage;

public class DiceTestNG {
	WebDriver driver;
	LoginPage loginPage;

	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "/Users/musaates/Documents/Libraries/drivers/chromedriver");
		driver = new ChromeDriver();

		driver.get("https://www.dice.com/");
		//driver.manage().window().maximize();

	}

	@Test
	public void loginTest() throws Exception {
		driver.findElement(By.xpath("//li[@class='logindd dropdown']")).click();
		driver.findElement(By.id("Email_1")).sendKeys("musaates71@gmail.com");
		driver.findElement(By.id("Password_1")).sendKeys("Tmsa2008");
		driver.findElement(By.id("LoginBtn_1")).click();
	
	}
}
