package base_PageDriver;

import org.openqa.selenium.WebDriver;



public class SetPageDriver {
	
	private static final ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();
	private static SetPageDriver instance = null;
	
private SetPageDriver() {
		
	}
	public static SetPageDriver getInstance() {
		if (instance == null) {
			instance = new SetPageDriver();
		}
		return instance;
	}
		

	public WebDriver getDriver() {
		return webDriver.get();
	}
	public void setDriver(WebDriver driver) {
		webDriver.set(driver);
	}
	public static WebDriver getCurrentDriver() {
		return getInstance().getDriver();
	}
	

}

	
	


