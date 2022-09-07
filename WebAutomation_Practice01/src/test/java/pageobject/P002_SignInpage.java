package pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonMethods_AND_Screenshot.Common_Methods;
import base_PageDriver.SetPageDriver;
import io.qameta.allure.Step;

public class P002_SignInpage extends Common_Methods{
	public P002_SignInpage() {
		PageFactory.initElements(SetPageDriver.getCurrentDriver(), this);
	}

	@FindBy(id = "email_create")
	public WebElement emailInputField;

	@FindBy(id = "SubmitCreate")
	public WebElement createAccountButton;

	@FindBy(id = "email")
	public WebElement emailLoginField;

	@FindBy(id = "passwd")
	public WebElement passwordLoginField;

	@FindBy(id = "SubmitLogin")
	public WebElement signInButton;
	
	public String signinPageTitle = "Login - My Store";

	@Step("Provide an Email address and click on create an Account button")
	public void createAccountWithEmail(String email) {
		sendText(emailInputField, email);
		createAccountButton.click();

	}

	@Step("Provide an Email & Password and click on Sign In button")
	public void loginwithEmailPassword(String email, String password) {
		sendText(emailLoginField, email);
		sendText(passwordLoginField, password);
		// Taking a screenshot for reporting purpose
		commonMethods_AND_Screenshot.Take_Screenshot.takeScreenShot("Log In Information");
		signInButton.click();

	}

}
