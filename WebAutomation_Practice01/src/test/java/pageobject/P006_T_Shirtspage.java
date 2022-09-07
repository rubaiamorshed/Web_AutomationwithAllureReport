package pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base_PageDriver.SetPageDriver;
import commonMethods_AND_Screenshot.Common_Methods;
import io.qameta.allure.Step;

public class P006_T_Shirtspage extends Common_Methods {
	public P006_T_Shirtspage() {
		PageFactory.initElements(SetPageDriver.getCurrentDriver(), this);
	}

	@FindBy(id = "layered_id_attribute_group_14")
	public WebElement filterBlueColorCheckbox;

	@FindBy(className = "product-container")
	public WebElement product;

	@FindBy(xpath = "//span[normalize-space()='Add to cart']")
	public WebElement addToCartButton;
	
	public String t_ShirtsPageTitle = "T-shirts - My Store";

	@Step("Filter Blue Color from CATALOG-Color section")
	public void filterBlueColor() {
		filterBlueColorCheckbox.click();
	
	}
	@Step("Scroll to Product then Hover on Product and Click on add To Cart Button Button")
	public void productAddToCart() {
		scrollToElement(product);
		hover(product);
		addToCartButton.click();
	}
}
