package base_PageDriver;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SetBaseDriver {
	
 WebDriver driver = null;

	
	
	@BeforeSuite
	public void setUp() {

		String browser = System.getProperty("browser", "chrome");
		
		 if (browser.contains("chrome")) {
			WebDriverManager.chromedriver().setup();
			

		}
		else if (browser.contains("firefox")) {
			WebDriverManager.firefoxdriver().setup();
	
		}  
		else
		{
			WebDriverManager.operadriver().setup();
		
		} 
		 driver.get("http://automationpractice.com/index.php");
			driver.manage().window().maximize();
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			SetPageDriver.getInstance().setDriver(driver);

		
	}

	@AfterSuite
	public void tearDown() {
		SetPageDriver.getCurrentDriver().quit();

	}

	

}



