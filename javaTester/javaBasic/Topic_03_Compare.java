package javaBasic;

public class Topic_03_Compare {
	
	int number = 8;
	public static void main(String[] args) {
		// 1 vùng nhớ cho biến x
		int x = 5;

		// 1 vùng nhớ cho biến y
		int y = x;

		System.out.println("x = " + x);
		System.out.println("y = " + y);
		y = 10;

		System.out.println("x = " + x);
		System.out.println("y = " + y);
		
		Topic_03_Compare firstVar = new Topic_03_Compare();
		Topic_03_Compare secondVar =  new Topic_03_Compare();
		System.out.println("before "+firstVar.number);
		System.out.println("before "+secondVar.number);
		secondVar.number = 10;
		System.out.println("after "+firstVar.number);
		System.out.println("after "+secondVar.number);
		
		

	}

}
