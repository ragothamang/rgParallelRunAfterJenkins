package factory;

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
		return chDriver;
	}

}
