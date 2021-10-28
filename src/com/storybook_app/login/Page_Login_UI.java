package com.storybook_app.login;

import org.testng.annotations.*;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

public class Page_Login_UI {
	public String baseUrl = "http://172.20.10.6:8080/login/";
	public String URL = "http://localhost:4444/wd/hub";
	public static WebDriver webDriver;
	public DesiredCapabilities caps = new DesiredCapabilities();
    
	@BeforeTest
	@Parameters("browser")
	public void beforeTest(String browser) throws Exception {
		caps.setPlatform(Platform.LINUX);
		switch(browser.toLowerCase()) {
			case "chrome":
				System.out.println("Set Browser to Chrome");
				caps.setBrowserName("chrome");
				break;
			case "firefox":
				System.out.println("Set Browser to Firefox");
				caps.setBrowserName("firefox");
			    break;
			default:
				System.out.println("Incorrect Browser");
			  	throw new Exception("Incorrect Browser");
		};
        webDriver = new RemoteWebDriver(new URL(URL), caps);
	}

	@AfterTest
	public void afterTest() {
		System.out.println("Close Browser And Quit Test");
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
