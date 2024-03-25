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
import pageObjects.admin.AdminDashboardPageObject;
import pageObjects.admin.AdminLoginPageObject;
import pageObjects.user.UserCustomerInfoPageObject;
import pageObjects.user.UserHomePageObject;
import pageObjects.user.UserLoginPageObject;

public class Level_08_Switch_Role_User extends BaseTest {
	private WebDriver driver;
	private UserHomePageObject userHomePage;
	private UserLoginPageObject userLoginPage;
	private AdminLoginPageObject adminLoginPage;
	private AdminDashboardPageObject adminDashboardPage;
	private UserCustomerInfoPageObject userCustomerPage;
	
	private String userEmailAddress, userPassword, adminEmailAddress, adminPassword;

	@Parameters({"browser"})
	@BeforeClass
	public void beforeClass(String browserName) {
		//1-Mở Url ra thì nó sẽ mở ra Home page, (Business page)
		driver = getBrowserDriver(browserName, GlobalConstants.USER_URL);

		userHomePage = PageGeneratorManager.getUserHomePage(driver);
		
		userEmailAddress = "hoa1@mail.com";
		userPassword = "123456";
		adminEmailAddress = "admin@yourstore.com";
		adminPassword = "admin";

	}

	@Test
	public void Role_01_Switch_User_To_Admin() {
		//Home -> Login(User)
		userLoginPage = userHomePage.clickToLoginLink();
		
		//Login vào > rồi làm gì đó
		userLoginPage.loginAsUser(userEmailAddress, userPassword);
		
		//Home -> My Account 
		userCustomerPage = userHomePage.clickToMyAccountLink();
		
		//Customer Info Page -> Click Logout link -> Home user 
		userHomePage = userCustomerPage.clickToUserLogoutLink(driver);
		
		//tại any Page của User -> Mở ra Admin URL -> Login (Admin)
		userHomePage.openUrl(driver, GlobalConstants.ADMIN_URL);
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
		
		//Login -> Dashboard
		adminDashboardPage = adminLoginPage.loginAsAdmin(adminEmailAddress, adminPassword);
		
		//Dashboard -> Any page -> Click Logout
		adminLoginPage = adminDashboardPage.clickToAdminLogoutLink(driver);
	}

	@Test
	public void Role_02_Switch_Admin_To_User() {
		//Login /Any page (Admin) -> Mở ra URL Hom page (user)
		adminLoginPage.openUrl(driver, GlobalConstants.USER_URL);
		userHomePage = PageGeneratorManager.getUserHomePage(driver);
		
		
		
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
