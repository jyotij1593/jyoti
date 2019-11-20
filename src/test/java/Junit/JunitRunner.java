package Junit;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.java.Before;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/main/resources/Features/ValidPurchase.feature", glue={"Step_Defination"}, dryRun=false,tags="@Login_to_application")

public class JunitRunner {
	public void sample(){

		System.out.println("Cucumber implementation"); 
		System.out.println("hello cucumber");
	}
}