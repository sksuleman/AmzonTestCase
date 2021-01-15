package com.amazon.testCases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.amazon.pageObjects.HomePage;
import com.amazon.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass {
	
	
	@Test(dataProvider="LoginData") //specifiy the method name 
	public void loginDDT()
	{
		HomePage hm= new HomePage (driver);
		hm.searchOnSearchBox(ssearch);
		logger.info("user on searchbar ");
		hm.clickOnSearchButton();
		logger.info("user click on searchbar");
		
		
		
	}
	
	@DataProvider(name="LoginData")
	String [][] getData() throws IOException
	{
		String path="C:\\Users\\ASIF SHAIK\\Desktop\\Suleman 2020\\Amazon\\src\\test\\java\\com\\amazon\\testData\\LoginData.xlsx";
		
		int rowcount=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path, "Sheet1", 1);
		
		String logindata[][]= new String[rowcount][colcount];
		
		for(int i=1; i<rowcount;i++)
		{
			for (int j=1;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j); //1 0
			}
		}
		
		return logindata;
	}

}
