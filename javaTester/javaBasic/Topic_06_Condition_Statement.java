package javaBasic;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Topic_06_Condition_Statement {
	WebDriver driver;
	Scanner scanner = new Scanner(System.in);

	//@Test
	public void TC_01_If() {

		int number = scanner.nextInt();
		int afterNumber = number % 2;
		System.out.println(number);
		boolean status = afterNumber == 0;
		System.out.println(status);
		if (status) {
			System.out.println("Số: " + number + " là số chẵn");
		} else {
			System.out.println("Số: " + number + " là số lẻ");
		}
	}
	
	@Test
	public void TC_02_() {
		int numberA = scanner.nextInt();
		int numberB = scanner.nextInt();
		if (numberA>=numberB) {
			System.out.println(numberA + "lớn hơn hoặc bằng" +numberB);
		}else {
			System.out.println(numberA + "nhỏ hơn" +numberB);
			
		}
	}

}
