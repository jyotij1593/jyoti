package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.codoid.products.utils.FilenameUtils;

import Business_Methods.Basesetupdriver;

public class Attaching_Screenshot_to_document {
	
	
	public static int capture=1;
	public static String rootpath = "src/main/resources/Results/";
	public static String Screenshot = "Snap_Shot/";
	public static String Filename = Basesetupdriver.excelHashMapValues.get("FileName");
	public static int i =0;
	

	public static void attachscreenshot(WebDriver driver) throws InvalidFormatException, IOException
	{
		try
		{
			if(capture==1)
			{
				createdoc();
				
			}
			XWPFDocument doc = new XWPFDocument(new FileInputStream(rootpath+Filename+".docx"));
			XWPFParagraph para = doc.getLastParagraph();
			XWPFRun run = para.createRun();
			
			File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			File dest = new File(Screenshot+Filename+capture+".png");
			
			FileUtils.copyFile(src, dest);
			i++;
			FileInputStream stram = new FileInputStream(dest);
			run.addBreak();
			run.addPicture(stram, XWPFDocument.PICTURE_TYPE_PNG, Filename + i + ".png", Units.toEMU(500), Units.toEMU(200));
			run.addBreak();
			run.addBreak();
			System.out.println("Taking Screenshot...");
			FileOutputStream out = new FileOutputStream(rootpath+Filename+".docx");
			doc.write(out);
			doc.close();
			out.close();
			
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (InvalidFormatException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			capture++;
		}
	}
	
	public static void createdoc() throws IOException
	{
		try
		{
		LocalDateTime now = LocalDateTime.now();
		XWPFDocument doc = new XWPFDocument();
		XWPFParagraph para = doc.createParagraph();
		XWPFRun run = para.createRun();
		run.setBold(true);
		File file = new File(rootpath+Filename+".docx");
		run.addBreak();
		run.setText("********Executing Demo Test Case*****");
		run.setBold(true);
		run.addBreak();
		run.setText("Executed on : " + now);
		run.addBreak();
		FileOutputStream outstream = new FileOutputStream(file);
		doc.write(outstream);
		doc.close();
		outstream.close();
		System.out.println("Document is Created");
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	

}
