package com.user.test.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserLoginTestScript {

	private WebDriver driver;
	private String baseURL;
	
	public UserLoginTestScript(WebDriver driver) throws WrongPageException{
		
		this.driver = driver;
		baseURL = "http://localhost:8084";
		driver.get(baseURL);
		System.out.println(driver.getTitle());
		if (!driver.getTitle().equals("Authentication Service")){
            throw new WrongPageException("Incorrect page");
        }
	}
	
	public void inputLoginDetails(String userName, String password){
        
		driver.findElement(By.name("username")).sendKeys(userName);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("login")).submit();
    }
	
    public String actualResult(){
        String pageValue = driver.findElement(By.xpath("//h2")).getText();
        System.out.println(pageValue);
        return pageValue;
    }
    
    public String expectedResult(){
        return "Hello,";
    }
	
}
