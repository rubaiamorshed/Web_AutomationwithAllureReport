package pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base_PageDriver.SetPageDriver;
import commonMethods_AND_Screenshot.Common_Methods;
import io.qameta.allure.Step;

public class P005_CasualDressespage extends Common_Methods {
	public P005_CasualDressespage() {
		PageFactory.initElements(SetPageDriver.getCurrentDriver(), this);
	}

	@FindBy(className = "product-container")
	public WebElement product;

	@FindBy(xpath = "//span[normalize-space()='Add to cart']")
	public WebElement addToCartButton;
	
	public String casualDressesPageTitle = "Casual Dresses - My Store";

	@Step("Scroll to Product then Hover on Product and Click on add To Cart Button Button")
	public void productAddToCart() {
		scrollToElement(product);
		hover(product);
		addToCartButton.click();

	}

}
