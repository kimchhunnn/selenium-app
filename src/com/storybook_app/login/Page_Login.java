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

public class Page_Login {
	public String baseUrl = "http://172.20.10.6:8080/login/";
	public String URL = "http://localhost:4444/wd/hub";
	public WebDriver webDriver;
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
	public void Should_RedirecToHomePage_WhenLoginInfoValid() {
		String storeId = "00001";
		String password = "00001";
		String expectedHomeHeader = "Welcome to Storybook App";
		
		webDriver.get(baseUrl);
	
		WebElement txtStoreId = webDriver.findElement(By.id("store-id"));
		txtStoreId.sendKeys(storeId);
		
		WebElement txtPassword = webDriver.findElement(By.id("password"));
		txtPassword.sendKeys(password);
		
		WebElement btnLogin = webDriver.findElement(By.id("login-btn"));
		btnLogin.click();
		
		WebElement hrdHome = webDriver.findElement(By.cssSelector(".central-home--wrapper h1"));
		String hrdHomeText  = hrdHome.getText();
		
		Assert.assertEquals(hrdHomeText, expectedHomeHeader);
	}
	
	@Test
	public void Should_FailedToLogin_WhenLoginInfoInvalid() {
		String storeId = "00002";
		String password = "00002";
		String expectedLoginHeader = "管理者ログイン";
		
		webDriver.get(baseUrl);
	
		WebElement txtStoreId = webDriver.findElement(By.id("store-id"));
		txtStoreId.sendKeys(storeId);
		
		WebElement txtPassword = webDriver.findElement(By.id("password"));
		txtPassword.sendKeys(password);
		
		WebElement btnLogin = webDriver.findElement(By.id("login-btn"));
		btnLogin.click();
		
		WebElement hrdLogin = webDriver.findElement(By.cssSelector(".cl-title p"));
		String hrdLoginText  = hrdLogin.getText();
		
		Assert.assertEquals(hrdLoginText, expectedLoginHeader);
	}
	
	@Test
	public void Should_RedirectToForgetPasswordPage_WhenClickForgetPasswordBtn() {
		String expectedForgetPasswordHeader = "Reset Your Password Here";
		
		webDriver.get(baseUrl);
		
		WebElement btnForgetPwd = webDriver.findElement(By.id("forgot-password-btn"));
		btnForgetPwd.click();
		
		WebElement hrdForgetPwd = webDriver.findElement(By.cssSelector(".central-forgot-pwd--wrapper h1"));
		String hrdForgetPwdText  = hrdForgetPwd.getText();
		
		Assert.assertEquals(hrdForgetPwdText, expectedForgetPasswordHeader);
	}

}
