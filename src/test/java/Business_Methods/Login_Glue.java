package Business_Methods;

import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import com.codoid.products.exception.FilloException;
import Object_Repository.Flipkart;
import Utilities.Commonmethods;
import Utilities.Reports;
import cucumber.api.java.Before;

public class Login_Glue extends Basesetupdriver {

	HashMap<String, String> excelhash = new HashMap<String, String>();
	public void logintoflipkart(String arg1, String arg2) throws IOException, Exception {

		
        Reports.CreateTest("Login Page");
		WebElement username = Basesetupdriver.driver.findElement(Flipkart.USERNAME);
		Commonmethods.sendKeys(username, Basesetupdriver.prop.getProperty(arg1));
		Commonmethods.ScreenShot();

		WebElement password = Basesetupdriver.driver.findElement(Flipkart.PASSWORD);
		Commonmethods.sendKeys(password, Basesetupdriver.prop.getProperty(arg2));
		Commonmethods.ScreenShot();

	}
	
	public void ClickonLogin() throws InvalidFormatException, IOException, InterruptedException
	{
		Reports.CreateTest("Login button");
		WebElement Loginbutton = Basesetupdriver.driver.findElement(Flipkart.LOGINBUTTON);
		Commonmethods.click(Loginbutton);
		Commonmethods.ScreenShot();
	}
	
	public void GettitleandUrl()
	{
		Reports.CreateTest("Getting Title and URL");
		String title = Basesetupdriver.driver.getTitle();
		String Url = Basesetupdriver.driver.getCurrentUrl();
		System.out.println(Url);
		System.out.println(title);
		excelhash.put(title, "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!");
		excelhash.put(Url, "https://www.flipkart.com/");
		Reports.embededTable(excelhash);
		Assert.assertTrue(title, true);
		Assert.assertTrue(Url, true);
	}
	
	public void Search_for_Product() throws FilloException, IOException, InvalidFormatException, InterruptedException
	{
		Reports.CreateTest("Searching Product");
		WebElement search = Basesetupdriver.driver.findElement(Flipkart.SEARCHBAR);
		Commonmethods.ScreenShot();
		Commonmethods.sendKeys(search,Basesetupdriver.excelHashMapValues.get("Search_item"));
		search.sendKeys(Keys.ENTER);
		Commonmethods.ScreenShot();
	}
	
	public void Pass_data_to_Excel_of_item_Searched() throws FilloException, IOException, InvalidFormatException, InterruptedException
	{
		Reports.CreateTest("Pass_data_to_Excel_of_item_Searched");
		for (int i = 2; i<=4; i++) 
		{
			String Firstxpath = "//*[@id='container']/div/div[3]/div[2]/div[1]/div[2]/";
			String Secondxpath = "div[" +i+ "]/div/div/div/a/div[3]/div[2]/div/div/div";
			
			String finalxpath = Firstxpath+Secondxpath;
			
			WebElement Rupees = Basesetupdriver.driver.findElement(By.xpath(finalxpath));
			
			String rupeestext = Rupees.getText();
			
			System.out.println("The Values are : " + rupeestext);
			
			Basesetupdriver.obj.writeExcelData(testCaseID, sheetName, "PriceList_"+i, rupeestext);
			
			excelhash.put(rupeestext,rupeestext);
		}
		Reports.embededTable(excelhash);
		Commonmethods.ScreenShot();
		WebElement openproduct = Basesetupdriver.driver.findElement(Flipkart.OPEN_PRODUCT);
		openproduct.click();
		Commonmethods.Handle_window_tabs(1);
		Commonmethods.ScreenShot();
		System.out.println(Basesetupdriver.driver.getCurrentUrl());
	}
	
	public void Add_to_Favorites() throws InterruptedException, InvalidFormatException, IOException
	{
		Reports.CreateTest("Add_to_Favorites");
		Thread.sleep(5000);
		WebElement favo = Basesetupdriver.driver.findElement(Flipkart.ADD_TO_FAVORITES);
		Commonmethods.actionClick(Basesetupdriver.driver, favo);
		Commonmethods.ScreenShot();
	}
	


}
