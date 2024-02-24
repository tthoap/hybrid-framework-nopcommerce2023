package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.HomePageUI;

public class HomePageObject extends BasePage{
	private WebDriver driver;
	
	//Hàm khởi tạo
	// 1 - trùng tên với tên class
	// 2. ko có kiểu trả về
	//3 . có tham số hoặc ko đều được
	//4 hàm có thể có 1 hoặc nhiều hàm khởi tạo đều được
	//5. nếu ko define cụ thể hàm khởi tạo thì trình biên dịch sẽ tự 
	  // tự tạo 1 hàm khởi tạo mặc định không có tham số
	//6. luôn luôn được gọi vào đầu tiên khi object được new lên

	
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
		System.out.println("Driver ID at Homepage = " + driver.toString());

	}
	
	public void clickToRegisterLink() {
		waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);
	}

}
