package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import pageObjects.user.UserAddressPageObject;
import pageObjects.user.UserCustomerInfoPageObject;
import pageObjects.user.UserHomePageObject;
import pageObjects.user.UserLoginPageObject;
import pageObjects.user.UserOrderPageObject;
import pageObjects.user.UserRegisterPageObject;
import pageObjects.user.UserRewardPointPageObject;

public class Level_08_Switch_Role_Admin extends BaseTest {
	private WebDriver driver;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInfoPageObject customerInfoPage;
	private UserOrderPageObject orderPage;
	private UserAddressPageObject addressPage;
	private UserRewardPointPageObject rewardPointpage;
	private String userEmailAddress, userPassword, adminEmailAddress, adminPassword;

	@Parameters({ "browser" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		// 1-Mở Url ra thì nó sẽ mở ra Home page, (Business page)
		driver = getBrowserDriver(browserName, GlobalConstants.USER_URL);

		homePage = PageGeneratorManager.getUserHomePage(driver);

		userEmailAddress = "";
		userPassword = "";
		adminEmailAddress = "";
		adminPassword = "";

	}

	@Test
	public void Role_01_Switch_User_To_Admin() {

	}

	@Test
	public void Role_02_Switch_Admin_To_User() {

	}

	@Test
	public void User_03_My_Account_Info() {

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
