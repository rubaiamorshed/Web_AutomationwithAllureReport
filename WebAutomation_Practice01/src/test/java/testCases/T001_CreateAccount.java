package testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base_PageDriver.SetBaseDriver;
import io.qameta.allure.Description;
import pageobject.P001_FirstPageHOME;
import pageobject.P002_SignInpage;
import pageobject.P003_CreateAnAccountpage;
import pageobject.P004_MyAccountpage;
import testDATA.DATA_Set;
import commonMethods_AND_Screenshot.Take_Screenshot;

public class T001_CreateAccount extends SetBaseDriver {

	@Test(description = "Perform registration process for new users and Sign Out", 
			dataProvider = "registrationData", 
			dataProviderClass = DATA_Set.class)
	@Description("Test Description: This test will go to automationpractice.com and "
			+ "browse to the registration page. Then complete the registration process "
			+ "by providing new user Personal and address information. " + "Finally, sign out from the system.")
	public void registration(String email, String firstname, String lastname, String password, String day, String month,
			String year, String companyName, String addressone, String Addresstwo, String city, String statename,
			String zipCode, String countryname, String addiAddress, String homephone, String mobilephone, String alias)
			throws InterruptedException {

		P001_FirstPageHOME homepage = new P001_FirstPageHOME();
		P002_SignInpage signInpage = new P002_SignInpage();
		P003_CreateAnAccountpage register = new P003_CreateAnAccountpage();
		P004_MyAccountpage myAccountpage = new P004_MyAccountpage();
		SoftAssert softAssert = new SoftAssert();

		// Going Sign Page
		homepage.clickSignInButton();

		// Waiting for Completely load the Sign In page
		signInpage.waitForPageLoad();

		softAssert.assertEquals(signInpage.getTitle(), signInpage.signinPageTitle);

		// Provide email and click on Create an Account
		signInpage.createAccountWithEmail(email);

		// Waiting for Completely load the Create Account page
		register.waitForPageLoad();

		softAssert.assertEquals(register.pageSubHeading.getText(), register.pageSubHeadingText);

		// Providing Every Personal information for the new user
		register.fillPersonalInformation(firstname, lastname, password, day, month, year);

		// Providing Address related information for the new user
		register.fillYourAddress(companyName, addressone, Addresstwo, city, statename, zipCode, countryname,
				addiAddress, homephone, mobilephone, alias);

		// Click on Register for complete Registration
		register.clickOnRegisterButton();

		// Waiting for Completely load My Account page
		myAccountpage.waitForPageLoad();
		
		String fullName = firstname + " " +lastname;
		softAssert.assertEquals(myAccountpage.userName.getText(), fullName);

		// Taking a screenshot for reporting purpose
		Take_Screenshot.takeScreenShot("Created Account");

		// Click on Sign Out for Sign out
		myAccountpage.clickSignOutButton();
       //Assertion
		softAssert.assertAll();
	}


}
