package Object_Repository;

import org.openqa.selenium.By;

public class Flipkart {
	
	public static final By LOGINANDSIGNUP = By.linkText("Login & Signup");
	public static final By USERNAME = By.xpath("(//form//input[@type='text'])[2]");
	public static final By PASSWORD = By.xpath("//form/div[2]/input[@type='password']");
	public static final By LOGINBUTTON = By.xpath("(//button[@type='submit'])[2]");
	public static final By SEARCHBAR = By.xpath("//input[@title='Search for products, brands and more']");
	public static final By ERRORMESSAGE = By.xpath("//span[@class='ZAtlA-']");
	public static final By OPEN_PRODUCT = By.xpath("//div[contains(text(),'₹9,490')]");
	public static final By ADD_TO_FAVORITES = By.xpath("//div[@class='_3gDSOa _13EqDR']/child::div");
	public static final By MYACCOUNT = By.xpath("(//*[contains(text(),'My Account')])[1]");
	public static final By LOGOUT = By.xpath("(//*[contains(text(),'Logout')])[1]");

}
