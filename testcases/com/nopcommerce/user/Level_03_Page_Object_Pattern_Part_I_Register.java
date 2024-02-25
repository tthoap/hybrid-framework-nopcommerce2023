package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.BasePage;
import pageObjects.HomePageObject;
import pageObjects.RegisterPageObject;

public class Level_03_Page_Object_Pattern_Part_I_Register extends BasePage {
	private WebDriver driver;
	private String emailAddress;
	//Khai báo
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		 System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		 driver = new FirefoxDriver();

//		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
//		driver = new ChromeDriver();
		System.out.println("Driver ID at Test class = " + driver.toString());
		
		emailAddress = "afc" + generateFakeNumber() + "@mail.vn";
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//1 - Mở url ra thì nó sẽ mở ra trang home page(Business page)
		driver.get("https://demo.nopcommerce.com/"); 
		driver.manage().window().maximize();
		//Khởi tạo page
		homePage = new HomePageObject(driver);
	}

	@Test
	public void TC_01_Register_Empty_Data() {
		// 2 - Từ Home page click vào Register link sẽ mở ra trang register page (business page)
		homePage.clickToRegisterLink();
		sleepInSecond(3);
		registerPage = new RegisterPageObject(driver);
		
		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getFirstNameErrorMessage(), "First name is required.");
		Assert.assertEquals(registerPage.getLastNameErrorMessage(), "Last name is required.");
		Assert.assertEquals(registerPage.getEmailErrorMessage(), "Email is required.");
		Assert.assertEquals(registerPage.getPasswordErrorMessage(), "Password is required.");
		Assert.assertEquals(registerPage.getConfirmPasswordErrorMessage(), "Password is required.");
	}

	@Test
	public void TC_02_Register_Invalid_Email() {
		homePage.clickToRegisterLink();
		registerPage = new RegisterPageObject(driver);
		
		registerPage.sendKeyToFirstNameTextbox("Automation");
		registerPage.sendKeyToLastNameTextbox("FC");
		registerPage.sendKeyToEmailTextbox("123@456#%*");
		registerPage.sendKeyToPasswordTextbox("123456");
		registerPage.sendKeyToConfirmPasswordTextbox("123456");
		
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getEmailErrorMessage(), "Wrong email");

	}

	@Test
	public void TC_03_Register_Success() {
		homePage.clickToRegisterLink();
		registerPage = new RegisterPageObject(driver);

		registerPage.sendKeyToFirstNameTextbox("Automation");
		registerPage.sendKeyToLastNameTextbox("FC");
		registerPage.sendKeyToEmailTextbox(emailAddress);
		registerPage.sendKeyToPasswordTextbox("123456");
		registerPage.sendKeyToConfirmPasswordTextbox("123456");
		registerPage.clickToRegisterButton();
		
		

		Assert.assertEquals(registerPage.getRegisteredSuccessMessage(), "Your registration completed");
		//3. Từ trang Register chuyển qua trang HOme page thì cần khởi tạo lại home page
		//registerPage.clickToLogoutLink();
		//homePage = new HomePageObject(driver);
	}

	//@Test
	public void TC_04_Register_Existing_Email() {
		homePage.clickToRegisterLink();
		registerPage = new RegisterPageObject(driver);

		registerPage.sendKeyToFirstNameTextbox("Automation");
		registerPage.sendKeyToLastNameTextbox("FC");
		registerPage.sendKeyToEmailTextbox(emailAddress);
		registerPage.sendKeyToPasswordTextbox("123456");
		registerPage.sendKeyToConfirmPasswordTextbox("123456");
		
		registerPage.clickToRegisterButton();
		

		Assert.assertEquals(registerPage.getExistedEmailErrorMessage(), "The specified email already exists");
	}

	//@Test
	public void TC_05_Register_Password_Less_Than_6_Chars() {
		homePage.clickToRegisterLink();
		registerPage = new RegisterPageObject(driver);

		registerPage.sendKeyToFirstNameTextbox("Automation");
		registerPage.sendKeyToLastNameTextbox("FC");
		registerPage.sendKeyToEmailTextbox(emailAddress);
		registerPage.sendKeyToPasswordTextbox("123");
		registerPage.sendKeyToConfirmPasswordTextbox("123");
		
		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getPasswordErrorMessage(), "Password must meet the following rules:\nmust have at least 6 characters");
	}

	//@Test
	public void TC_06_Register_Invalid_Confirm_Password() {
		homePage.clickToRegisterLink();
		registerPage = new RegisterPageObject(driver);

		registerPage.sendKeyToFirstNameTextbox("Automation");
		registerPage.sendKeyToLastNameTextbox("FC");
		registerPage.sendKeyToEmailTextbox(emailAddress);
		registerPage.sendKeyToPasswordTextbox("123456");
		registerPage.sendKeyToConfirmPasswordTextbox("123");
		
		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getConfirmPasswordErrorMessage(), "The password and confirmation password do not match.");

	}

	@AfterClass
	public void afterClass() {
		//driver.quit();
	}

	public int generateFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}

}
