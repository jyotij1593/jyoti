package Utilities;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import org.junit.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class Reports 
{
public static ExtentHtmlReporter reporter;
public static ExtentReports extent;
public static ExtentTest test;
public static Properties pro;
	
	
	public static String timeStamp()
	{
	Timestamp time =new Timestamp(System.currentTimeMillis());
	String ts= time.toString().replaceAll(":", "_ ").replace(".", "_");
	System.out.println(ts);
	return ts;
	}
	public static void reportGeneration(String reportpath)
	{
		 System.out.println("loging in to browser");
		 reporter= new ExtentHtmlReporter(reportpath+"ExtentReport"+timeStamp()+".html");
		 extent = new ExtentReports();
		 extent.attachReporter(reporter);
		 System.out.println("Report Created");
		
	}
	
	
	public static void CreateTest(String testcasename)
	{
		test=extent.createTest(testcasename);
	}
	
	public static void testStatus(String st,String data) throws InterruptedException
	{
	switch( st)
	{
	case "pass" :
//		test=extent.createTest(testcasename);
		Assert.assertTrue(true);
		Thread.sleep(2000);
		test.log(Status.PASS,MarkupHelper.createLabel(data, ExtentColor.GREEN));
		break;
	case "fail" :
//		test=extent.createTest(testcasename);
		Assert.assertTrue(true);
		Thread.sleep(2000);
		test.log(Status.FAIL, MarkupHelper.createLabel(data,ExtentColor.RED));
		break;
	case "skip" :
//		test=extent.createTest(testcasename);
		Assert.assertTrue(true);
		Thread.sleep(2000);
		test.log(Status.SKIP, MarkupHelper.createLabel(data,ExtentColor.ORANGE));
		break;
	}
	}
	void configfile() throws IOException
	{
		//File f=new File();
		FileInputStream sc = new FileInputStream("C:\\Users\\Training\\workspace\\CucumberReportDemo\\configaration\\config.properties");
	    pro=new Properties();
		pro.load(sc);
		//return null;
		
	}
	
	public static String createLable(String text)
	{
		
		 String testResult = text ;
		 test.info(MarkupHelper.createLabel(testResult, ExtentColor.GREEN));
		 return text;   
	}
	
	public static void embededTable(HashMap<String,String> s)
	    {
	        

	        StringBuilder stringMapTable = new StringBuilder();
	        stringMapTable.append("<html><body><h4>Basic HTML Table</h4><table style='width:70%' border=1><tr><th bgcolor=\"#0000FF\" width=\"200%\">Excepted</th><th bgcolor=\"#00FF00\">Actual</th><th bgcolor=\"#FF0000\">Status</th></tr>");

	       for(Map.Entry<String, String> entry:s.entrySet())
	       
	       {
	       String key =entry.getKey();
	       String value =entry.getValue();
	       String status="";
	       if(key.equalsIgnoreCase(value))
	       {
	       status="Pass";
	       }
	       else
	       {
	       status="Fail";  
	       }
	                stringMapTable.append("<tr><td>" + key + "</td><td>" +value + "</td><td width=\"40%\">" +status + "</td></tr>");
	                System.out.println(entry.getKey() + " = " + entry.getValue());
	        }
	       stringMapTable.append("</table></body></html>");
	      String mapTable = stringMapTable.toString();

	    
	        test.log(Status.INFO,mapTable);
	    }
		
	public static void embededLink(String link)
	    {
	        test.log(Status.INFO, "<a href="+link+">Click Here</a>");
	    }
	public static void codeBlock(String content)
	{
		String code = "\n\t\n\t\t"+content+"\n\t\n";
		Markup m = MarkupHelper.createCodeBlock(code);

		test.pass(m);
		
	}
	
	public static void setSystemInfo( String os, String browser)
	{
		extent.setSystemInfo(os, browser);
	}
	
	public static void attachScreenshot(String screenushotpath) throws IOException
	{
		// log with snapshot
        //test.fail("fail because of some issue", MediaEntityBuilder.createScreenCaptureFromPath(screenushotpath).build());
        test.log(Status.INFO, "<a href=\"#s\">back to summary</a>");
	}
	public static void assignAuthorName(String name)
	{
		test.assignAuthor(name);
		
	}
	public static void addCategories(String testing_type)
	{
		test.assignCategory(testing_type);
		
	}
	
	
	public static void endReport()
	{
		
		extent.flush();
		
	}
}
