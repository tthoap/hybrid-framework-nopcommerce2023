package javaBasic;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_09_While_Do_While {
	static // WebDriver driver;
	Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		TC_01();
		System.out.println("==========================");
		TC_02_While();

		System.out.println("==========================");
		TC_03_Do_While();
	}

	@Test
	public static void TC_01() {

		int number = scanner.nextInt();
		for (int i = number; i < 100; i++) {
			if (i % 2 == 0) {
				System.out.println("IN ra: " + i);
			}
		}
	}

	@Test
	public static void TC_02_While() {

		int number = scanner.nextInt();
		while (number < 100) {
			if (number % 2 == 0) {
				System.out.println(number);
				number++;
			}
		}
	}

	@Test
	public static void TC_03_Do_While() {

		int number = scanner.nextInt();
		do {
			if (number % 2 == 0) {
				System.out.println(number);
				number++;
			}
		} while (number < 100);

	}

}
