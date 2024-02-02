package javaBasic;

public class Topic_05_Primitive_Casting {

	public static void main(String[] args) {
		
		/*
		 * //Ngầm định = ko mất dữ liệu byte bNumber = 126; System.out.println(bNumber);
		 * 
		 * short sNumber = bNumber; System.out.println(bNumber);
		 * 
		 * 
		 * int iNumber = sNumber; System.out.println(iNumber);
		 * 
		 * 
		 * long lNumber = iNumber; System.out.println(lNumber);
		 * 
		 * 
		 * float fNumber = lNumber; System.out.println(fNumber);
		 * 
		 * double dNumber = fNumber; System.out.println(dNumber);
		 */
		
		
		
		// Tuong Minh (Cast)
		double dNumber = 654321789;
		System.out.println(dNumber);
		
		float fNumber = (float) dNumber;
		System.out.println(fNumber);
		
		long lNumber = (long) fNumber;
		System.out.println(fNumber);
		
		int iNumber = (int) lNumber;
		System.out.println(iNumber);
		
		short sNumber = (short) iNumber;
		System.out.println(iNumber);
		
		byte bNumber = (byte) iNumber;
		System.out.println(bNumber);
		

	}

}
