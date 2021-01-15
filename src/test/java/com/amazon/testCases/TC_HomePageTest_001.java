package com.amazon.testCases;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.amazon.pageObjects.HomePage;

public class TC_HomePageTest_001  extends BaseClass
  {
	@Test
	public void homeTest() throws IOException
	
	
	    {
		
		//driver.get(baseurl); Move into Baseclass to run on desired browser
		
		logger.info("URL is opened");
		HomePage hm = new HomePage(driver);
		hm.searchOnSearchBox(ssearch);
		logger.info("Searching on searchbox");
		
		hm.clickOnSearchButton();
		logger.info("Click on Search Button");
		
		hm.clickOniphonelink();
		logger.info("Click on iphonelink");
		
		
		  String MainWindow = driver.getWindowHandle(); 
		  Set<String> s1=driver.getWindowHandles();
		  Iterator<String> i1 = s1.iterator(); 
		  while
		  (i1.hasNext()) 
		  { 
			 String ChildWindow = i1.next();
		  
		  if (!MainWindow.equalsIgnoreCase(ChildWindow))
		  {
		  driver.switchTo().window(ChildWindow);
		  }
		  }
		
		hm.clickOnAddToCart();
		logger.info("Click on Add to cart");
		
		
		hm.clickOnProceedToCheckOut();
	    logger.info("Click on the Proceed to CheckOut Button");
	
		  
		 if(driver.getCurrentUrl().equals(
		  "https://www.amazon.in/ap/signin?_encoding=UTF8&openid.assoc_handle=amazon_checkout_in&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&openid.ns.pape=http%3A%2F%2Fspecs.openid.net%2Fextensions%2Fpape%2F1.0&openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2Fgp%2Fbuy%2Fsignin%2Fhandlers%2Fcontinue.html%3Fie%3DUTF8%26brandId%3D%26cartItemIds%3D%26eGCApp%3D%26hasWorkingJavascript%3D0%26isEGCOrder%3D0%26isFresh%3D%26oldCustomerId%3D0%26oldPurchaseId%3D%26preInitiateCustomerId%3D%26purchaseInProgress%3D%26ref_%3Dcart_signin_submit%26siteDesign%3D&pageId=amazon_checkout_in&showRmrMe=0&siteState=isRegularCheckout.1%7CIMBMsgs.%7CisRedirect.1&suppressSignInRadioButtons=0")) 
		 {
			 Assert.assertTrue(true);
			 logger.info("Home Page Test passed");
			 }
		 
		 else 
		 {
		 captureScreen(driver,"HomePageTest");
		 Assert.assertTrue(false); 
		 logger.info("Home Page Test Fail"); }
		 }
		 
		 
		
	    }
  
	

	
	
	


