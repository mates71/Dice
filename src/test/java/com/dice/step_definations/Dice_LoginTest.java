package com.dice.step_definations;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Ignore;
import org.openqa.selenium.WebDriver;

import com.dice.pages.LoginPage;
import com.dice.utilities.ConfigurationReader;
import com.dice.utilities.Driver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class Dice_LoginTest {
	WebDriver driver;
	LoginPage loginPage=new LoginPage();
	String title="Tech Jobs | US Contract and Permanent IT Jobs | Dice.com";

	@Given("^I am on the Dice home page$")
	public void i_am_on_the_Dice_home_page() throws Throwable {
		//System.setProperty("webdriver.chrome.driver", "/Users/musaates/Documents/Libraries/drivers");
		Driver.getInstance().get(ConfigurationReader.getProperty("url"));
		Driver.getInstance().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Driver.getInstance().manage().window().maximize();
		
		Assert.assertEquals(title, Driver.getInstance().getTitle());

	}

	@When("^I fill my credantial$")
	public void i_fill_my_credantial() throws Throwable {
		
		/*JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(1161, 23)", "");
		Thread.sleep(3000);*/
		//String img="//img[@src='https://tpc.googlesyndication.com/pagead/imgad?id=CICAgKCzt9DbDRABGAEyCBLFY46ZaTTa']";
	/*	
		WebDriverWait wait=new WebDriverWait(driver, 70);
		wait.until(ExpectedConditions.invisibilityOfElementLocated((By) driver.findElement(By.xpath("//img[@src='https://tpc.googlesyndication.com/pagead/imgad?id=CICAgKCzt9DbDRABGAEyCBLFY46ZaTTa']"))));
*/
		loginPage.bannerClose.click();
		Thread.sleep(1000);
		loginPage.searchJob.sendKeys(ConfigurationReader.getProperty("job"));
		Thread.sleep(3000);
		loginPage.searchCity.clear();
		
		loginPage.searchCity.sendKeys(ConfigurationReader.getProperty("city"));
	
		
	}

	@When("^I click sing button$")
	public void i_click_sing_button() throws Throwable {
		loginPage.submit.click();
		loginPage.sortDate.click();
	}
	
	@Ignore
	@Then("^I able to see my account$")
	public void i_able_to_see_my_account() throws Throwable {

		
		loginPage.login.click();
		loginPage.email.sendKeys(ConfigurationReader.getProperty("email"));
		loginPage.psw.sendKeys(ConfigurationReader.getProperty("password"));
		loginPage.signBtn.click();
		
		System.out.println("I am on the my account? "+loginPage.img.isDisplayed());
		
		
	}

}
