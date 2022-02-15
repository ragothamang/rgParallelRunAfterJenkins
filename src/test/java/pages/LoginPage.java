package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import hooks.AppHooks;

public class LoginPage extends AppHooks {

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public LoginPage enterUserName(String userName) {
		
//		WebElement usernameInput = driver.findElement(By.id("username"));		
		WebElement usernameInput = locateWebElement("id", "username");
		type(usernameInput, userName);
		return this;
	}
	
	public LoginPage enterPassword(String userName) {
//		WebElement passwordInput = driver.findElement(By.id("password"));
		WebElement passwordInput = locateWebElement("id", "password");
		type(passwordInput, userName);
		return this;
	}
	
	public HomePage clickLoginButton() {
//		WebElement loginButton = driver.findElement(By.id("Login"));
		WebElement  loginButton = locateWebElement("id", "Login");
		click(loginButton);
		return new HomePage(this.driver);
	}
	
}
