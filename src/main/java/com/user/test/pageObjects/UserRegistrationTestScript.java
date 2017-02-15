package com.user.test.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserRegistrationTestScript {

	private WebDriver driver;
	private String baseURL;

	public UserRegistrationTestScript(WebDriver driver) throws WrongPageException {

		this.driver = driver;
		baseURL = "http://localhost:8082/user/registration";
		driver.get(baseURL);
		System.out.println(driver.getTitle());
		if (!driver.getTitle().equals("User Registration Form")) {
			throw new WrongPageException("Incorrect page");
		}
	}

	public void inputLastName(String lastName) {

		driver.findElement(By.name("lastName")).sendKeys(lastName);

	}

	public void inputfirstName(String firstName) {

		driver.findElement(By.name("firstName")).sendKeys(firstName);
	}

	public void inputUserName(String userName) {

		driver.findElement(By.name("userName")).sendKeys(userName);
	}

	public void inputEmail(String email) {

		driver.findElement(By.name("email")).sendKeys(email);
	}

	public void inputPassword(String password, String reenterPassword) {

		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("psw-repeat")).sendKeys(reenterPassword);
		driver.findElement(By.name("signup")).submit();
	}

	public String actualResult() {

		String pageValue = driver.findElement(By.xpath("//h2")).getText();
		System.out.println(pageValue);
		return pageValue;
	}

	public String expectedResult() {
		return "User Created with Following Information:";
	}
}
