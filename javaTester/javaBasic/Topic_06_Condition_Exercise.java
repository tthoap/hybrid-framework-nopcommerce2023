package javaBasic;

import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Topic_06_Condition_Exercise {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	Scanner scanner = new Scanner(System.in);

	// @Test
	public void TC_01_If() {
		boolean status = 5 > 3;
		System.out.println(status);
		if (status) {
			System.out.println("Go to If");
		}

		// Gán
		int studentNumber = 10;
		status = (studentNumber == 10);
		System.out.println(status);

		WebDriver driver = new FirefoxDriver();

		// Element luôn có trong DOM dù pop-up hiển thị hay không
		WebElement salePopup = driver.findElement(By.xpath(""));
		if (salePopup.isDisplayed()) {

		}

		// ELement ko có trong DOM khi pop-up không hiển thị
		List<WebElement> salepopups = driver.findElements(By.xpath(""));
		if (salepopups.size() > 0 && salepopups.get(0).isDisplayed()) {
			//
		}
	}

	// @Test
	public void TC_02_If_Else() {
		// Có 2 điều kiện, đúng thì vào ì sai thì vao Else

		// Nếu driver start với browser thì Chrome/FF/Edge thì start với hàm build-in
		// của Selenium

		// Nếu driver là IE thì dùng hàm clicj của javascript

		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();

		// System.setProperty("webdriver.chrome.driver", projectPath +
		// "\\browserDrivers\\chromedriver.exe");
		// driver= new ChromeDriver();

		if (driver.toString().contains("firefox")) {
			System.out.println("CLick by Selenium WebElement");
		} else
			System.out.println("click by not FF");
	}

	// @Parameters("browser")
	// @Test
	public void TC_03_If_Else_IF_Else(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
			driver = new EdgeDriver();
		} else if (browserName.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", projectPath + "\\browserDrivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		} else { // Safari, cococ, Opera
			System.out.println("Please enter correct browser");
		}
		System.out.println(browserName);
		System.out.println(driver.toString());
		driver.quit();
	}

	//@Test
	public void TC_04_If_Else_IF_Else() {
		// Page Object
		// Dynamic

		String pageName = "Login";
		if (pageName.equals("Login")) {
			// LoginPage loginPage = new LoginPage();
			// return loginPage;

		} else if (pageName.equals("Register")) {
			// RegisterPage registerPage = new Registerpage();
			// return registerPage;

		} else if (pageName.equals("New Customer")) {
			// CustomerPage customerPage = new CustomerPage();
			// return customerPage;

		} else {
			// HomePage homePage = new HomePage();
			// return homePage;
		}

		int age = 20;
		String access = (age < 18) ? "Yo can not access" : "Welcome to system";

	}

	@Test
	public void TC_05() {
		int month = scanner.nextInt();
		if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
			System.out.println("Tháng này có 30 ngày");
		} else if (month == 2) {
			System.out.println("Tháng này có 28 hoặc 29 ngày");
		} else if (month == 4 || month == 6 || month == 9 || month == 11)
			System.out.println("Tháng này có 30 ngày");
	}

	public static void main(String[] args) {

	}

}
