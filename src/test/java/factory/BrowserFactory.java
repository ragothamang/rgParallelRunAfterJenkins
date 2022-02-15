package factory;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {
	public WebDriver getChromeDriverInstance() {
		WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver chDriver = new ChromeDriver(options);
		chDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));		
		return chDriver;
	}

}
