package javaBasic;

import org.testng.annotations.Test;

public class Topic_02_Exercise {
	
	@Test
	public void TC_01() {
		int a = 2;
		int b = 6;
		
		System.out.println("Tong = " + (a+b));
		System.out.println("Hieu = " + (a-b));
		System.out.println("Tich = " + (a*b));
		System.out.println("Thuong = " + (a/b));
	}
	
	@Test
	public void TC_02() {
		float  dai = 2.3f;
		float  rong = 4.3f;
		System.out.println("Dien tich = " + (dai*rong));
		System.out.println("chu vi = " +((dai+rong)*2));
	}
}
