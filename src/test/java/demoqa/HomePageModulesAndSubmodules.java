package demoqa;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


public class HomePageModulesAndSubmodules extends DemoqaBaseClass
{
	@Test
	public void titleValidation()
	{
		//Title validation
	    String title = driver.getTitle();
	    System.out.println("Title of homepage: "+title);
	    
	    //== gives wrong result bcz == compares references while .equals compares content
	    if(title.equals("demosite"))
	    {
	    	System.out.println("Validating title : Testcase Passed");
	    }else
	    {
	    	System.out.println("Validating title : Testcase Failed");
	    }
	}
	public void itemsAndSubItems()
	{
	   
	   List<WebElement> itemsText = driver.findElements(By.className("category-cards"));
	   By categoryItems = By.cssSelector("div.category-cards a");
	    List<WebElement> listOfItems = driver.findElements(categoryItems);
	    
	    //Prints the items in the home page
	    for(WebElement items : itemsText)
	    {  	
	    	System.out.println("-----------Items in home page: "+"\n" +items.getText());
	    }
	    
	    //Iterates through the items in the home page and prints the sub-items in each item
	    for(int i=0; i <listOfItems.size();i++)
	   	{
	   		// Re-find elements because DOM changes after navigation
	   		listOfItems = driver.findElements(categoryItems);
	   		
    		// Scroll until item is found
	   		scrollToElement(listOfItems.get(i));
    		 // Get item name and click on it
	   		String itemName = listOfItems.get(i).getText();
	    	listOfItems.get(i).click();
	    		
	   		//find the sub-items in the new page and print them
	   	    List<WebElement> listOfSubItems = driver.findElements(By.xpath("//div[contains(@class,'element-list') and contains(@class,'show')]"));
	   	    for(WebElement subItems : listOfSubItems)
	   	    {
         		System.out.println("----> Items in "+ itemName+ ": "+"\n" +subItems.getText());
	   	    }
    	    // Navigate back to the home page
	   	    driver.navigate().back();
	   	    
	    }
	}
}

