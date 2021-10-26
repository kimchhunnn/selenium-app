package seleniumapppackage;

import org.testng.annotations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Page_Login {
	public String baseUrl = "http://localhost:8080/login/";
	public WebDriver webDriver;
    
	@BeforeTest
	public void beforeTest() {
		webDriver = new ChromeDriver();
	}

	@AfterTest
	public void afterTest() {
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
		
		WebElement hrdHome = webDriver.findElement(By.cssSelector(".central-login--wrapper h1"));
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
		
		WebElement hrdForgetPwd = webDriver.findElement(By.cssSelector(".central-forget-pwd--wrapper h1"));
		String hrdForgetPwdText  = hrdForgetPwd.getText();
		
		Assert.assertEquals(hrdForgetPwdText, expectedForgetPasswordHeader);
	}

}
