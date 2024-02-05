package javaBasic;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Topic_08_For_Foreach {
	WebDriver driver;

	// @Test
	public void TC_01() {
		// for (int i = 0; i <= 5; i++) {
		// System.out.println(i);
		// }
		//
		// List<WebElement> links = driver.findElements(By.xpath(""));
		// Array
		String[] cityName = { "HN", "DN", "HCM", "CanTho", "KhanhHoa" };
		//
		// //Dùng kết hợp ì thõa mãn điều kiện mới action
		// //biến đếm - dùng như 1 điều kiện để filter
		// for (int i = 1; i <= cityName.length; i++) {
		// if(cityName[i].equals("DN")) {
		// //Do action
		// System.out.println("Do action!");
		// break;
		// }
		// System.out.println(cityName[i]);
		// }

		// Dùng để chạy qua tất cả các giá trị
		int y = 0;
		for (String city : cityName) {
			if (cityName[y].equals("DN")) {
				System.out.println("Do aaaaaaaaaaaaaaaaction");
				System.out.println(city);
				break;
			}
			y++;

		}
	}

	// @Test
	public void TC_02() {

		String[] cityName = { "HN", "DN", "HCM", "CanTho", "KhanhHoa" };
		for (String citi : cityName) {
			System.out.println(citi);

		}
		List<String> cityAddress = new ArrayList<String>();

	}

}
