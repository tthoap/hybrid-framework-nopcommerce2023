package javaBasic;

public class Topic_14_StringFormat {

	public static  String ADDRESS_PAGE_LINK = "//div[contains(@class,'account-navigation')]//a[text()='Addresses']";
	public static  String REWARD_POINT_PAGE_LINK = "//div[contains(@class,'account-navigation')]//a[text()='Reward points']";
	public static  String CUSTOMER_INFO_PAGE_LINK = "//div[contains(@class,'account-navigation')]//a[text()='Customer info']";
	public static  String ORDER_PAGE_LINK = "//div[contains(@class,'account-navigation')]//a[text()='Orders']";
	
	//1 biến cho cả 14 pages hoặc n pages (format giống nhau - chỉ khác bởi tên page)
	public static String DYNAMIC_SIDEBAR_LINK_BY_PAGE_NAME = "//div[contains(@class,'account-navigation')]//a[text()='%s']";
	public static String DYNAMIC_LINK_BY_PAGE_NAME = "//div[contains(@class,'%s')]//a[text()='%s']";
	
	
	
	
	
	public static void main(String[] args) {
		clickToLink(ADDRESS_PAGE_LINK);
		clickToLink(CUSTOMER_INFO_PAGE_LINK);
		clickToLink(ORDER_PAGE_LINK);
		clickToLink(REWARD_POINT_PAGE_LINK);
		
		clickToLink(DYNAMIC_SIDEBAR_LINK_BY_PAGE_NAME,"Addresses");
		clickToLink(DYNAMIC_SIDEBAR_LINK_BY_PAGE_NAME, "Reward points");
		clickToLink(DYNAMIC_SIDEBAR_LINK_BY_PAGE_NAME, "Customer info");
		clickToLink(DYNAMIC_SIDEBAR_LINK_BY_PAGE_NAME, "Orders");
		
		clickToLink(DYNAMIC_LINK_BY_PAGE_NAME, "account-navigation", "Addresses");
		clickToLink(DYNAMIC_LINK_BY_PAGE_NAME, "footer-upper", "Search");
		clickToLink(DYNAMIC_LINK_BY_PAGE_NAME, "header-upper", "My account");
		
	}
	
	
/*	public static void clickToLink(String locator) {
		System.out.println("1- Click to: " + locator);
	}
	
	// 1 tham số động
	public static void clickToLink(String dynamicLocator, String pageName) {
		String locator = String.format(dynamicLocator, pageName);
		System.out.println("2- Click to: " + locator);
	}
	
	//2 tham số động
	public static void clickToLink(String dynamicLocator, String areaName, String pageName) {
		String locator = String.format(dynamicLocator, areaName, pageName);
		System.out.println("3-Click to: " + locator);
	}
	*/
	//n tham số động

	public static void clickToLink(String dynamicLocator, String... params) {
		String locator = String.format(dynamicLocator, (Object[]) params);
		System.out.println("4-Click to: " + locator);
	}
	
}
