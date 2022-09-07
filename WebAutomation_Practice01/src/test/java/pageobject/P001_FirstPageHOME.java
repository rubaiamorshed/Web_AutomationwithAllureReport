package pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base_PageDriver.SetPageDriver;
import commonMethods_AND_Screenshot.Common_Methods;
import io.qameta.allure.Step;

public class P001_FirstPageHOME extends Common_Methods {
	public P001_FirstPageHOME() {
		PageFactory.initElements(SetPageDriver.getCurrentDriver(), this);
	}

	@FindBy(css = "a[title='Log in to your customer account']")
	public WebElement signInButton;

	@FindBy(xpath = "(//a[@title='Dresses'])[2]")
	public WebElement dressesButton;

	@FindBy(xpath = "(//a[@title='Casual Dresses'])[2]")
	public WebElement CasualDressesButton;

	@FindBy(xpath = "(//a[@title='T-shirts'])[2]")
	public WebElement tShirtsButton;
	
	@Step("Click on Sign In Button")
	public void clickSignInButton() {
		signInButton.click();
	}
	
	@Step("Hover on Dresses Button and Click on Casual Dresses Button")
	public void hoverAndClickCasualDresses() {
		hover(dressesButton);
		CasualDressesButton.click();
	}
	

	

	@Step("Click on T-Shirts Button")
	public void clickOnTShirtsButton() {
		tShirtsButton.click();
	}

}



