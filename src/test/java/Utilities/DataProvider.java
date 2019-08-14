package Utilities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

import Business_Methods.Basesetupdriver;

public class DataProvider {

	Fillo fillo = new Fillo();
	Connection connection;

	// Write the value into Excel

	public void writeExcelData(String testCaseID, String sheetName, String Columnname, String columnvalue)
			throws FilloException, IOException {
		connection = fillo.getConnection("src/main/resources/TestData/Fillo.xlsx");
		String strQuery = "Update " + sheetName + " Set " + Columnname + "='" + columnvalue + "' where TestCaseID='"
				+ testCaseID + "' ";
		connection.executeUpdate(strQuery);
		connection.close();

	}

	// Read the values form Excel

	public HashMap<String, String> extractExcelData(String testCaseID, String sheetName)
			throws FilloException, IOException {
		HashMap<String, String> excelHashMapValues = new HashMap<String, String>();
		connection = fillo.getConnection("src/main/resources/TestData/Fillo.xlsx");
		String strQuery =Basesetupdriver.prop.getProperty("Query")  + sheetName + " " + Basesetupdriver.prop.getProperty("Query1") + " ='" + testCaseID + "'"; 
		Recordset recordset = connection.executeQuery(strQuery);
		while (recordset.next()) {
			ArrayList<String> ColCollection = recordset.getFieldNames();
			int Iter;
			int size = ColCollection.size();
			for (Iter = 0; Iter <= (size - 1); Iter++) {
				String ColName = ColCollection.get(Iter);
				// System.out.println(ColName);
				String ColValue = recordset.getField(ColName);
				// System.out.println(ColValue);
				// HashMap<String, String> excelHashMapValues = new HashMap
				// <String, String>();
				excelHashMapValues.put(ColName, ColValue);
			}
		}

		/*
		 * while(recordset.next()) {
		 * System.out.println(recordset.getField("UserName")); }
		 */

		recordset.close();
		connection.close();
		return excelHashMapValues;
	}

	

}
