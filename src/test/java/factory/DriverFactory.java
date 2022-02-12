package factory;

import org.openqa.selenium.WebDriver;

public class DriverFactory {
	public ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	private DriverFactory() {

	}

	private static DriverFactory dfInstance = new DriverFactory();

	public static  DriverFactory getInstance() {
		return dfInstance;
	}
	
	public WebDriver getDriver() {
		return driver.get();
	}
	
	public void setDriver(WebDriver driverParam) {
		driver.set(driverParam);
	}
	
	public void closeBrowser() {
		driver.get().close();
		driver.remove();
	}

}
