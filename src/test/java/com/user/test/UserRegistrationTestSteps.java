package com.user.test;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.user.test.pageObjects.UserRegistrationTestScript;

import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;

public class UserRegistrationTestSteps {

	private WebDriver driver;

	public UserRegistrationTestScript userRegistration;

	@Given("^I want to write a step with precondition$")
	public void I_want_to_write_a_step_with_precondition() throws Throwable {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\rhish\\Desktop\\HandsOn\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		userRegistration = new UserRegistrationTestScript(driver);
	}

	@When("^Input first name$")
	public void Input_first_name() throws Throwable {

		userRegistration.inputfirstName("Rhicha");
	}

	@When("^Input second name$")
	public void Input_second_name() throws Throwable {

		userRegistration.inputLastName("Nema");
	}

	@When("^Input user name$")
	public void Input_user_name() throws Throwable {

		userRegistration.inputUserName("rhichannndddd");
		userRegistration.inputEmail("rn@gmail.com");
	}

	@When("^Input password$")
	public void Input_password() throws Throwable {
		userRegistration.inputPassword("aaa", "aaa");
	}

	@Then("^On clicking register, the user should be redirected to a page with his/her details$")
	public void On_clicking_register_the_user_should_be_redirected_to_a_page_with_his_her_details() throws Throwable {

		assertEquals(userRegistration.actualResult(), userRegistration.expectedResult());
		driver.quit();
	}

}
