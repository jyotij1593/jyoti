package Step_Defination;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Properties;
import Business_Methods.Basesetupdriver;
import Business_Methods.Login_Glue;
import Utilities.Browserconfig;
import Utilities.Commonmethods;
import Utilities.DataProvider;
import Utilities.Reports;
import Object_Repository.Flipkart;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.SendKeysAction;

import com.codoid.products.exception.FilloException;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Stepdef extends Basesetupdriver {
	
	Login_Glue ob=new Login_Glue();
	
	
	@Before
	public void read_beforetest() throws IOException, Exception
	{
		ReadPropertyfile_and_OpenBrowser();
		
		
	}

	@Given("^The user is able to login with valid \"([^\"]*)\" and with valid \"([^\"]*)\"$")
	public void the_user_is_able_to_login_with_valid_and_with_valid(String arg1, String arg2) throws Throwable 
	{
		ob.logintoflipkart(arg1, arg2);
		
	}

	@Given("^I verify the title and url of the page$")
	public void I_verify_the_title_and_url_of_the_page() throws Throwable 
	{
	  ob.GettitleandUrl();
	}

	@Given("^Click on the search icon and Search for a product$")
	public void click_on_the_search_icon_and_Search_for_a_product() throws Throwable 
	{
        ob.Search_for_Product();
	}
	
	@Then("^Fill the data for item searched into the ExcelSheet$")
	public void Fill_the_data_for_item_searched_into_the_ExcelSheet() throws FilloException, IOException, InvalidFormatException, InterruptedException
	{
		ob.Pass_data_to_Excel_of_item_Searched();
	}

	@Then("^filter the searched product in the application$")
	public void filter_the_searched_product_in_the_application() throws Throwable 
	{
      
	}

	@Then("^add it to favorites section$")
	public void add_it_to_favorites_section() throws InterruptedException, InvalidFormatException, IOException
	{
		 ob.Add_to_Favorites();
	}

	@Given("^Goto favorites section in the application$")
	public void goto_favorites_section_in_the_application() throws Throwable {
		// Write code here that turns the phrase above into concrete actions

	}

	@Then("^Click on The Product and add it to cart$")
	public void click_on_The_Product_and_add_it_to_cart() throws Throwable {
		// Write code here that turns the phrase above into concrete actions

	}

	@And("^click on login button$")
	public void click_on_login_button() throws Throwable {
		
	ob.ClickonLogin();
	Thread.sleep(5000);
	    
	}

	@Then("^validate error message is displayed$")
	public void validate_error_message_is_displayed() throws Throwable {

	
	}
	
	@When("^the user search for a product$")
	public void user_search_for_a_product() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@Then("^verify product is displayed$")
	public void verify_product_is_displayed() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   
	}

	@And("^click on the product$")
	public void click_on_the_product() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@When("^user perfroms cart operation$")
	public void user_perfroms_cart_operation() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@Then("^Application should navigate to user registration$")
	public void application_should_navigate_to_user_registration() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}
	@When("^user is able to click on sign in option$")
	public void click_on_sign_in_option() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@Then("^Verify the user info page is displayed$")
	public void verify_the_user_info_page_is_displayed() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@And("^click on register$")
	public void click_on_register() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@Then("^Error message should be displayed$")
	public void error_message_should_be_displayed() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@Then("^Logout of The application$")
	public void logout_of_The_application() throws Throwable {
			// Write code here that turns the phrase above into concrete actions
		
	}
	
	@After
	public void Closebrowser()
	{
		Reports.endReport();
		Basesetupdriver.driver.quit();
		
	}

}
