package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.UserHomePageUI;

public class UserHomePageObject extends BasePage{
	private WebDriver driver;
	
	//Hàm khởi tạo
	// 1 - trùng tên với tên class
	// 2. ko có kiểu trả về
	//3 . có tham số hoặc ko đều được
	//4 hàm có thể có 1 hoặc nhiều hàm khởi tạo đều được
	//5. nếu ko define cụ thể hàm khởi tạo thì trình biên dịch sẽ tự 
	  // tự tạo 1 hàm khởi tạo mặc định không có tham số
	//6. luôn luôn được gọi vào đầu tiên khi object được new lên

	
	public UserHomePageObject(WebDriver driver) {
		this.driver = driver;
		System.out.println("Driver ID at Homepage = " + driver.toString());

	}
	
	public UserRegisterPageObject clickToRegisterLink() {
		waitForElementClickable(driver, UserHomePageUI.REGISTER_LINK);
		clickToElement(driver, UserHomePageUI.REGISTER_LINK);
		return PageGeneratorManager.getUserRegisterPage(driver);
	}

	public UserLoginPageObject clickToLoginLink() {
		waitForElementClickable(driver, UserHomePageUI.LOGIN_LINK);
		clickToElement(driver, UserHomePageUI.LOGIN_LINK);	
		return PageGeneratorManager.getUserLoginPage(driver);
	}

	public boolean isMyAccountLinkDisplayed() {
		waitForElementVisible(driver, UserHomePageUI.MY_ACCOUNT_LINK);
		return isElementDisplay(driver, UserHomePageUI.MY_ACCOUNT_LINK);
	}

	public boolean isLogoutLinkDisplayed() {
		waitForElementVisible(driver, UserHomePageUI.LOGOUT_LINK);
		return isElementDisplay(driver, UserHomePageUI.LOGOUT_LINK);
	}

	public UserCustomerInfoPageObject clickToMyAccountLink() {
		waitForElementClickable(driver, UserHomePageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, UserHomePageUI.MY_ACCOUNT_LINK);
		return PageGeneratorManager.getUserCustomerInfoPage(driver);
		
		
	}


	

}
