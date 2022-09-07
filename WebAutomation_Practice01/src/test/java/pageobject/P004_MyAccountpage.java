package pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base_PageDriver.SetPageDriver;
import commonMethods_AND_Screenshot.Common_Methods;
import io.qameta.allure.Step;

public class P004_MyAccountpage extends Common_Methods {
	public P004_MyAccountpage() {
		PageFactory.initElements(SetPageDriver.getCurrentDriver(), this);
	}

	@FindBy(css = "a[title='Log me out']")
	public WebElement signOutButton;
	
	@FindBy(css = "a[title='View my customer account'] span")
	public WebElement userName;
	

	@Step("Click on Sign Out Button")
	public void clickSignOutButton() {
		signOutButton.click();

	}

}
