package seleniumapppackage;

import org.testng.annotations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Page_Login_UI {
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
