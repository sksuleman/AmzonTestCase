package com.amazon.pageObjects;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver ldriver;
	
	public HomePage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	
	@FindBy(xpath="//input[@id='twotabsearchtextbox']")
	      WebElement searchBox;
	
	
	@FindBy(xpath="//input[@id='nav-search-submit-button']")
	     WebElement clickSearchButton;
	
	
     
	 @FindBy(xpath="(//a[@class='a-link-normal a-text-normal'])[1]")
	      WebElement iphonelink;
	
				
	  @FindBy(xpath="//*[@id=\"add-to-cart-button\"]")
	  WebElement addToCart;
	  
	  @FindBy(id="attach-sidesheet-checkout-button")
	  WebElement checkOut;
	 
	 
	//ActionMethods
	
	public void searchOnSearchBox(String ssearcbox) 
	{
		searchBox.sendKeys(ssearcbox);
	}
	
    public void clickOnSearchButton()
	
	{
		 clickSearchButton.click();
		
	}
	
	
	
	public void clickOniphonelink()
	{
			
			iphonelink.click();
			
		}
		
		
		
		  public void clickOnAddToCart()
		  {
			
		       addToCart.click();
		   }
		 
		 public void clickOnProceedToCheckOut()
		 {
			 checkOut.click();
		 }
		
		
	}
    	


