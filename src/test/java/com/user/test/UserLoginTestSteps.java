package com.user.test;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.user.test.pageObjects.UserLoginTestScript;

import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;

public class UserLoginTestSteps {

	private WebDriver driver;

	public UserLoginTestScript userTestScript;

	@Given("^I want to test username and password$")
	public void I_want_to_test_username_and_password() throws Throwable {

		
		//System.setProperty("webdriver.gecko.driver","C:\\Users\\rhish\\Desktop\\HandsOn\\geckodriver-v0.9.0-win64\\geckodriver.exe");
		System.setProperty("webdriver.chrome.driver","C:\\Users\\rhish\\Desktop\\HandsOn\\chromedriver_win32\\chromedriver.exe");
		//ProfilesIni profile  = new ProfilesIni();
		//FirefoxProfile firefoxProfile = profile.getProfile("ProfileToolsQA");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		userTestScript = new UserLoginTestScript(driver);

	}

	@When("^I input the value to username and password$")
	public void I_input_the_value_to_username_and_password() throws Throwable {

		userTestScript.inputLoginDetails("aaa", "aaaa");
	}

	@Then("^I should be logged in to the application$")
	public void I_should_be_logged_in_to_the_application() throws Throwable {

		assertEquals(userTestScript.actualResult(), userTestScript.expectedResult());
		driver.quit();
	}

}
