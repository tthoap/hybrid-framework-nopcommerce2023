package javaBasic;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Topic_02_Data_Type {
	
	//Primitive type/value type: Nguyên thủy
	byte bNumber = -120;
	short sNumbre;
	int iNumber;
	long lNumber;
	float fNumber = 19.29f;
	double dNumber = 19.29d;
	char cChart;
	boolean bStatus;
	
	//Reference type: Kiểu tham chiếu
	
	//String
	String address = "Ho Chi Minh";
	
	//Array
	String[]  studenAddress = {address, "Ha Noi", "DN"};
	Integer[] studentNumber = {10, 20 , 14};
	
	//Class
	Topic_02_Data_Type topic1;
	
	//INterface
	WebDriver driver;
	
	//Object aObject
	Object aObject;
	
	// Collection
	//List, Set, Queue, Map
	List<WebElement> homePageLinks = driver.findElements(By.tagName("a"));
	Set<String> allWindows = driver.getWindowHandles();
	List<String> productName = new ArrayList<String>();
	
	
	public static void main(String[] args) {
		
	

	}

}
