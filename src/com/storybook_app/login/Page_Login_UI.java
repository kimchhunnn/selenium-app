package com.storybook_app.login;

import org.testng.annotations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;

public class Page_Login_UI {
	public String baseUrl = "http://localhost:8080/login/";
	public WebDriver webDriver;
    
	@BeforeTest
	@Parameters("browser")
	public void beforeTest(String browser) throws Exception {
		switch(browser.toLowerCase()) {
			case "chrome":
				System.out.println("ChromeDriver");
				webDriver = new ChromeDriver();
				break;
			case "safari":
				System.out.println("SafariDriver");
				webDriver = new SafariDriver();
			    break;
			default:
				System.out.println("Incorrect Browser");
			  	throw new Exception("Incorrect Browser");
		};
		    // code block
	}

	@AfterTest
	public void afterTest() {
		webDriver.close();
		webDriver.quit();
	}
  
	@Test
	public void Should_EnableLoginBtn_WhenStoreIdAndPasswordFilled() {
		
		String storeId = "00001";
		String password = "00001";
		Boolean expectedLoginButtonDisability = false;
		
		webDriver.get(baseUrl);
	
		WebElement txtStoreId = webDriver.findElement(By.id("store-id"));
		txtStoreId.sendKeys(storeId);
		
		WebElement txtPassword = webDriver.findElement(By.id("password"));
		txtPassword.sendKeys(password);
		
		WebElement btnLogin = webDriver.findElement(By.id("login-btn"));
		Boolean loginButtonDisability = btnLogin.getAttribute("class").contains("disabled");
		
		Assert.assertEquals(loginButtonDisability, expectedLoginButtonDisability);
	}
	
	@Test
	public void Should_DisableLoginBtn_WhenBothStoreIdAndPasswordIsEmpty() {
		
		Boolean expectedLoginButtonDisability = true;
		
		webDriver.get(baseUrl);
	
		WebElement txtStoreId = webDriver.findElement(By.id("store-id"));
		txtStoreId.sendKeys("");
		
		WebElement txtPassword = webDriver.findElement(By.id("password"));
		txtPassword.sendKeys("");
		
		WebElement btnLogin = webDriver.findElement(By.id("login-btn"));
		Boolean loginButtonDisability = btnLogin.getAttribute("class").contains("disabled");
		
		Assert.assertEquals(loginButtonDisability, expectedLoginButtonDisability);
	}
	
	@Test
	public void Should_DisableLoginBtn_WhenStoreIdEmpty() {
		
		String storeId = "";
		String password = "00001";
		Boolean expectedLoginButtonDisability = true;
		
		webDriver.get(baseUrl);
	
		WebElement txtStoreId = webDriver.findElement(By.id("store-id"));
		txtStoreId.sendKeys(storeId);
		
		WebElement txtPassword = webDriver.findElement(By.id("password"));
		txtPassword.sendKeys(password);
		
		WebElement btnLogin = webDriver.findElement(By.id("login-btn"));
		Boolean loginButtonDisability = btnLogin.getAttribute("class").contains("disabled");
		
		Assert.assertEquals(loginButtonDisability, expectedLoginButtonDisability);
	}
	
	@Test
	public void Should_DisableLoginBtn_WhenPasswordEmpty() {
		
		String storeId = "00001";
		String password = "";
		Boolean expectedLoginButtonDisability = true;
		
		webDriver.get(baseUrl);
	
		WebElement txtStoreId = webDriver.findElement(By.id("store-id"));
		txtStoreId.sendKeys(storeId);
		
		WebElement txtPassword = webDriver.findElement(By.id("password"));
		txtPassword.sendKeys(password);
		
		WebElement btnLogin = webDriver.findElement(By.id("login-btn"));
		Boolean loginButtonDisability = btnLogin.getAttribute("class").contains("disabled");
		
		Assert.assertEquals(loginButtonDisability, expectedLoginButtonDisability);
	}
}
