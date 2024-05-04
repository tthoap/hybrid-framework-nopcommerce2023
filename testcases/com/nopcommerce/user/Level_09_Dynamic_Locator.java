package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.user.UserAddressPageObject;
import pageObjects.user.UserCustomerInfoPageObject;
import pageObjects.user.UserHomePageObject;
import pageObjects.user.UserLoginPageObject;
import pageObjects.user.UserOrderPageObject;
import pageObjects.user.UserRegisterPageObject;
import pageObjects.user.UserRewardPointPageObject;

public class Level_09_Dynamic_Locator extends BaseTest {
	private WebDriver driver;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInfoPageObject customerInfoPage;
	private UserOrderPageObject orderPage;
	private UserAddressPageObject addressPage;
	private UserRewardPointPageObject rewardPointpage;
	private String firstName, lastName, emailAddress, password;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		// 1-Mở Url ra thì nó sẽ mở ra Home page, (Business page)
		driver = getBrowserDriver(browserName, url);

		homePage = PageGeneratorManager.getUserHomePage(driver);

		firstName = "John";
		lastName = "Henry";
		emailAddress = "Jh" + generateFakeNumber() + "@mail.us";
		password = "123456";
	}

	@Test
	public void User_01_Register_Login() {
		// 2- Từ Home page click vào Register link sẽ chuyển vào Register page
		registerPage = homePage.clickToRegisterLink();

		registerPage.sendKeyToFirstNameTextbox(firstName);
		registerPage.sendKeyToLastNameTextbox(lastName);
		registerPage.sendKeyToEmailTextbox(emailAddress);
		registerPage.sendKeyToPasswordTextbox(password);
		registerPage.sendKeyToConfirmPasswordTextbox(password);
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getRegisteredSuccessMessage(), "Your registration completed");

		// 3- Từ Register page click continue sẽ chuyển lại Home Page
		homePage = registerPage.clickToContinueButton();
		homePage = registerPage.clickToUserLogoutLink(driver);

		// 4- Từ HOme page chuyển về Login page
		loginPage = homePage.clickToLoginLink();

		loginPage.inputToEmailTextBox(emailAddress);
		loginPage.inputToPasswordTextBox(password);

		// 5- Từ Login Page chuyển về Home Page
		homePage = loginPage.clickToLoginButton();

		// 6- Từ Home page chuyển về Customer Info page
		customerInfoPage = homePage.clickToMyAccountLink();
		Assert.assertEquals(customerInfoPage.getFirstNameTextboxValue(), firstName);
		Assert.assertEquals(customerInfoPage.getLastNameTextboxValue(), lastName);
		Assert.assertEquals(customerInfoPage.getEmailTextboxValue(), emailAddress);

	}

	@Test
	public void User_02_Navigate_Page() {
		// Customer Info Page -> Orders Page
		System.out.println("Customer Info Page -> Orders Page");
		orderPage = customerInfoPage.openOrderpage(driver);

		// Order Page -> Reward Point
		System.out.println("Order Page -> Reward Point");
		rewardPointpage = orderPage.openRewardPointPage(driver);

		// Reward Page -> Order Page
		System.out.println("Customer Info Page -> Orders Page");
		orderPage = rewardPointpage.openOrderpage(driver);

		// Order Page -> Customer Info Page
		System.out.println("Order Page -> Customer Info Pagen ");
		customerInfoPage = orderPage.openCustomerInfoPage(driver);

	}

	@Test
	public void User_03_Dynamic_Page_01() {
		// Customer Info Page -> Orders Page
		System.out.println("Customer Info Page -> Orders Page");
		orderPage = (UserOrderPageObject) customerInfoPage.openPagesAtMyAccountByName(driver, "Orders");
		
		// Order Page -> Reward Point
		System.out.println("Order Page -> Reward Point");
		rewardPointpage = (UserRewardPointPageObject) orderPage.openPagesAtMyAccountByName(driver, "Reward points");
		
		// Reward Page -> Order Page
		System.out.println("Customer Info Page -> Orders Page");
		orderPage = (UserOrderPageObject) rewardPointpage.openPagesAtMyAccountByName(driver, "Orders");
		
		// Order Page -> Customer Info Page
		System.out.println("Order Page -> Customer Info Pagen ");
		customerInfoPage = (UserCustomerInfoPageObject) orderPage.openPagesAtMyAccountByName(driver, "Customer info");
		
		// Customer Info Page -> Address Page
		System.out.println("Customer Info Page -> Address Page");
		addressPage = (UserAddressPageObject) customerInfoPage.openPagesAtMyAccountByName(driver, "Addresses");
		
		
	}
	
	@Test
	public void User_03_Dynamic_Page_02() {
		//Customer Info Page -> Order page
		System.out.println("User_03_Dynamic_Page_02: Order page ->  Reward Point");
		customerInfoPage.openPagesAtMyAccountByPageName(driver, "Orders");
		orderPage = PageGeneratorManager.getUserOrderPage(driver);
		
		// Order page ->  Reward Point
		System.out.println("User_03_Dynamic_Page_02: Order page ->  Reward Point");
		orderPage.openPagesAtMyAccountByPageName(driver, "Reward points");
		rewardPointpage = PageGeneratorManager.getUserRewardPointPage(driver);
		
		// Reward Point -> Address Page
		System.out.println("User_03_Dynamic_Page_02: Reward Point -> Address Page");
		rewardPointpage.openPagesAtMyAccountByPageName(driver, "Addresses");
		addressPage = PageGeneratorManager.getUserAddressPage(driver);
		
		//Address page -> Order page
		System.out.println("User_03_Dynamic_Page_02: Address page -> Order page");
		addressPage.openPagesAtMyAccountByPageName(driver, "Orders");

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public int generateFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}

}
