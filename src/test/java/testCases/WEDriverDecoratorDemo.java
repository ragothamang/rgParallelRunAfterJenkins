package testCases;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.decorators.Decorated;
import org.openqa.selenium.support.decorators.WebDriverDecorator;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WEDriverDecoratorDemo extends WebDriverDecorator{
	
	@Test
	public void takeScreenEveryAction() {
		WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver chDriver = new ChromeDriver(options);
		chDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		WebDriver driverDecorated = new WEDriverDecoratorDemo().decorate(chDriver);
		
		driverDecorated.get("http://login.salesforce.com");
		
		WebElement username = driverDecorated.findElement(By.id("username"));
		username.sendKeys("test@test.com");
		
		
		
		
	}

	@Override
	public void beforeCall(Decorated<?> target, Method method, Object[] args) {
		// TODO Auto-generated method stub
		System.out.println("Before from Decorator method >>   "+ method.getName());
	}

	@Override
	public void afterCall(Decorated<?> target, Method method, Object[] args, Object res) {
		// TODO Auto-generated method stub
		System.out.println("After from Decorator method");
		
		WebDriver driver = target.getDecorator().getDecoratedDriver().getOriginal();
		
		long number = (long) Math.floor(Math.random() * 900000000L) + 10000000L;
		
			try {
				FileUtils.copyFile(((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE) , new File("./reports-DesignPattern/images/"+number+(new Date()).getTime()+".png"));
			} catch (WebDriverException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	}
	
	

}
