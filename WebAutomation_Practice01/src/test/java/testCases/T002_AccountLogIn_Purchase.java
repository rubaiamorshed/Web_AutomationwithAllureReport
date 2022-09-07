package testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base_PageDriver.SetBaseDriver;
import io.qameta.allure.Description;
import pageobject.P001_FirstPageHOME;
import pageobject.P002_SignInpage;
import pageobject.P004_MyAccountpage;
import pageobject.P005_CasualDressespage;
import pageobject.P006_T_Shirtspage;
import pageobject.P007_Cartpage;
import pageobject.P008_Checkoutpage;
import testDATA.DATA_Set;
import commonMethods_AND_Screenshot.Take_Screenshot;

public class T002_AccountLogIn_Purchase extends SetBaseDriver {
	@Test(description = "Perform Login, Purchase, and Logout", dataProvider = "userInfo", dataProviderClass = DATA_Set.class)
	@Description("Test Description: This test will log-in to automationpractice.com, "
			+ "Then add two different category products to the cart and complete the checkout process with payment. "
			+ "Finally, It will Sign out from the system.")
	public void loginAndPurchase(String email, String password, String comment) {
		P001_FirstPageHOME homepage = new P001_FirstPageHOME();
		P002_SignInpage signInpage = new P002_SignInpage();
		P004_MyAccountpage myAccountpage = new P004_MyAccountpage();
		P005_CasualDressespage casualDressespage = new P005_CasualDressespage();
		P006_T_Shirtspage t_Shirtspage = new P006_T_Shirtspage();
		P007_Cartpage cartpage = new P007_Cartpage();
		P008_Checkoutpage checkoutpage = new P008_Checkoutpage();
		SoftAssert softAssert = new SoftAssert();

		// Going to Sign Page
		homepage.clickSignInButton();

		// Waiting for Completely load the Sign In page
		signInpage.waitForPageLoad();
		
		softAssert.assertEquals(signInpage.getTitle(), signInpage.signinPageTitle);

		// Provide email & password and click on Log In for complete Login Process
		signInpage.loginwithEmailPassword(email, password);

		// Taking a screenshot for reporting purpose
		Take_Screenshot.takeScreenShot("After Log In -My Account Page");

		// Click Casual Dresses from Menu bar by hovering on Dresses
		homepage.hoverAndClickCasualDresses();

		// Waiting for Loading the Casual Dresses page Completely 
		casualDressespage.waitForPageLoad();
		
		softAssert.assertEquals(casualDressespage.getTitle(), casualDressespage.casualDressesPageTitle);

		// Scroll to product and add product to cart
		casualDressespage.productAddToCart();

		// Choose the Continue Shopping option
		cartpage.clickContinueShopping();

		// Click on T-Shirts from Menu bar
		homepage.clickOnTShirtsButton();

		// Waiting for loading the T-Shirts page Completely
		t_Shirtspage.waitForPageLoad();
		
		softAssert.assertEquals(t_Shirtspage.getTitle(), t_Shirtspage.t_ShirtsPageTitle);

		// Filter Blue Color from CATALOG-Color section
		t_Shirtspage.filterBlueColor();

		// Scroll to product and add product to cart
		t_Shirtspage.productAddToCart();

		// Choose Proceed To Checkout option
		cartpage.clickProceedToCheckout();

		// Waiting for loading the Order/Checkout page Completely
		checkoutpage.waitForPageLoad();
		
		softAssert.assertEquals(checkoutpage.getTitle(), checkoutpage.checkoutpageTitle);

		// Taking a screenshot for reporting purpose
		Take_Screenshot.takeScreenShot("Cart Details");

		// Click Order/Checkout summary page 'Proceed To Checkout' button
		checkoutpage.clickSummaryProceedToCheckout();

		// Write addition info and Click Order/Checkout Address page 'Proceed To
		// Checkout' button
		checkoutpage.addCommentAndProceedToCheckout(comment);

		// Agree TOS (Terms of Service) and Click Order/Checkout shipping page 'Proceed To Checkout' button
		checkoutpage.checkTOSAndProceedToCheckout();

		// Scroll and select Pay By Check option
		checkoutpage.clickPaybyCheque();

		// Scroll and click on "I confirm my order" button for complete checkout process
		checkoutpage.clickConfirmOrder();

		myAccountpage.clickSignOutButton();
		// Assertion
		softAssert.assertAll();
	}
}
