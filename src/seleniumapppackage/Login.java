package seleniumapppackage;

import org.testng.annotations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Login {
	public String baseUrl = "http://localhost:8080/login/";
	public String storeId = "00001";
	public String password = "00001";
	public WebDriver webDriver;
	public String expectedHomeHeader = "Welcome to Storybook App";
    
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
	public void verifyLoginSucceedScenario() {
		
		webDriver.get(baseUrl);
	
		WebElement storeIdInputElement = webDriver.findElement(By.id("store-id"));
		storeIdInputElement.sendKeys(storeId);
		
		WebElement passwordInputElement = webDriver.findElement(By.id("password"));
		passwordInputElement.sendKeys(password);
		
		WebElement loginBtnElement = webDriver.findElement(By.id("login-btn"));
		loginBtnElement.click();
		
		WebElement homeHeaderElement = webDriver.findElement(By.cssSelector(".central-login--wrapper h1"));
		String homeHeader  = homeHeaderElement.getText();
		
		Assert.assertEquals(homeHeader, expectedHomeHeader);
	}

}
