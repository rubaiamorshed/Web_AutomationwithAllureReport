package pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base_PageDriver.SetPageDriver;
import commonMethods_AND_Screenshot.Common_Methods;
import io.qameta.allure.Step;

public class P007_Cartpage extends Common_Methods {
	public P007_Cartpage() {
		PageFactory.initElements(SetPageDriver.getCurrentDriver(), this);
	}

	@FindBy(xpath = "//span[@title='Continue shopping']//span[1]")
	public WebElement continueShoppingButton;

	@FindBy(xpath = "//span[normalize-space()='Proceed to checkout']")
	public WebElement proceedToCheckoutButton;

	@Step("Click on continue Shopping Button From Cart details window")
	public void clickContinueShopping() {
		continueShoppingButton.click();

	}
	@Step("Click on Proceed To Checkout Button From Cart details window")
	public void clickProceedToCheckout() {
		proceedToCheckoutButton.click();
	}

}
