package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pageUIs.RegisterPageUI;

public class RegisterPageObject extends BasePage {
	private WebDriver driver;
	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@CacheLookup
	@FindBy(id="register-button")
	private WebElement registerButton;
	
	@FindBy(xpath = "//a[@class='ico-logout']")
	private WebElement logoutLink;
	
	@FindBy(css ="input[id='FirstName']")
	private WebElement firstNameTextBox;
	
	@FindBy(css ="input[id='FirstName']")
	private WebElement lastNameTextBox;
	
	@FindBy(css ="input[id='Email']")
	private WebElement emailTextBox;
	
	@FindBy(css ="input[id='Password']")
	private WebElement passwordTextBox;
	
	@FindBy(css ="input[id='ConfirmPassword']")
	private WebElement confirmPasswordTextBox;
	
	@FindBy(css ="span[id='FirstName-error']")
	private WebElement firstNameErrorMgs;
	
	@FindBy(css ="span[id='LastName-error']")
	private WebElement lastNameErrorMsg;
	
	@FindBy(css ="span[id='Email-error']")
	private WebElement emailErrorMsg;
	
	@FindBy(css ="span[id='Password-error']")
	private WebElement passwordErrorMsg;
	
	@FindBy(css ="span[id='ConfirmPassword-error']")
	private WebElement confirmPasswordErrorMsg;
	
	@FindBy(xpath ="//div[contains(@class,'validation-summary-errors')]")
	private WebElement exitedEmailErrorMsg;
	
	@FindBy(css ="div[class='result']")
	private WebElement registerSuccessMsg;
	
	@FindBy(xpath ="//a[contains(@class,'register-continue-button')]6"
			+ "")
	private WebElement continueButton;
	
	public void clickToRegisterButton() {
		waitForElementClickable(driver, registerButton );
		clickToElement(registerButton);
	}

	public String getFirstNameErrorMessage() {
		waitForElementVisible(driver, firstNameErrorMgs);
		return getElementText(firstNameErrorMgs);
	}

	public String getLastNameErrorMessage() {
		waitForElementVisible(driver, lastNameErrorMsg);
		return getElementText(lastNameErrorMsg);
	}

	public String getEmailErrorMessage() {
		waitForElementVisible(driver, emailErrorMsg);
		return getElementText(emailErrorMsg);
	}

	public String getPasswordErrorMessage() {
		waitForElementVisible(driver, passwordErrorMsg);
		return getElementText(passwordErrorMsg);
	}

	public String getConfirmPasswordErrorMessage() {
		waitForElementVisible(driver, confirmPasswordErrorMsg);
		return getElementText(confirmPasswordErrorMsg);
	}

	public void sendKeyToFirstNameTextbox(String firstName) {
		waitForElementVisible(driver, firstNameTextBox);
		sendkeyToElement(firstNameTextBox, firstName);
		
	}

	public void sendKeyToLastNameTextbox(String lastName) {
		waitForElementVisible(driver, lastNameTextBox);
		sendkeyToElement(lastNameTextBox, lastName);		
	}

	public void sendKeyToEmailTextbox(String emailAddress) {
		waitForElementVisible(driver, emailTextBox);
		sendkeyToElement(emailTextBox, emailAddress);		
	}

	public void sendKeyToConfirmPasswordTextbox(String password) {
		waitForElementVisible(driver, passwordTextBox);
		sendkeyToElement(passwordTextBox, password);		
	}

	public void sendKeyToPasswordTextbox(String confirmPassword) {
		waitForElementVisible(driver, confirmPasswordTextBox);
		sendkeyToElement(confirmPasswordTextBox, confirmPassword);		
	}

	public String getRegisteredSuccessMessage() {
		waitForElementVisible(driver, registerSuccessMsg);
		return getElementText(registerSuccessMsg);
	}

	public void clickToLogoutLink() {
		waitForElementClickable(driver, logoutLink);
		clickToElement(logoutLink);
	}

	public String getExistedEmailErrorMessage() {
		waitForElementVisible(driver, exitedEmailErrorMsg);
		return getElementText(exitedEmailErrorMsg);
	}

	public void clickToContinueButton() {
		waitForElementClickable(driver, continueButton);
		clickToElement(continueButton);
		
	}
}
