package javaBasic;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class Topic_07_Switch_Case {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	Scanner scanner = new Scanner(System.in);

	//Chỉ nhận int/string/enum
	//Không dùng với các toán tử trong case: = < > != ==
	// @Parameters("browser")
//	@Test
	public void TC_01(String browserName) {
		driver = getBrowserDriver(browserName);

		System.out.println(browserName);
		System.out.println(driver.toString());
		driver.quit();
	}

	public WebDriver getBrowserDriver(String browserName) {
		switch (browserName) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		case "edge":
			System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
			driver = new EdgeDriver();
			break;
		case "ie":
			System.setProperty("webdriver.ie.driver", projectPath + "\\browserDrivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			break;

		default:
			new RuntimeException("Please enter correct browser");
			break;
		}
		return driver;
	}

	//@Test
	public void TC_02() {
		int month = scanner.nextInt();
		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			System.out.println("Tháng này có 31 ngày");
			//break;
		case 4:
		case 6:
		case 9:
		case 11:
			System.out.println("Tháng này có 30 ngày");
			//break;
		case 2:
			System.out.println("Tháng này có 28 ngày");
			//break;

		default:
			System.out.println("Thang sai format");
			//break;
		}
	}

	@Test
	public void TC_03() {
		int studentPoint = scanner.nextInt();
		switch (studentPoint) {
		case 10:
			
			break;

		default:
			break;
		}
		
	}
}
