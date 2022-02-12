package uiServices;

import org.openqa.selenium.WebElement;

public interface IPageActions {
	public WebElement locateElement(String locValue);
	public WebElement locateWebElement(String locator, String locatorValue);
	public void click(WebElement element);
	public void type(WebElement element, CharSequence... keysToSend);
	public void typeAndAppend(WebElement element, CharSequence... keysToSend);
	public void jsClick(WebElement ele);
}
