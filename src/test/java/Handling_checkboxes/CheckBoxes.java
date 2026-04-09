package Handling_checkboxes;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import DemoQABase.DemoqaBaseClass;


public class CheckBoxes extends DemoqaBaseClass
{
	@Test
	public void checkboxTest() throws IOException
	{
		 //xpath - click on Elements
		   driver.findElement(By.xpath("//div[normalize-space()='Elements']")).click();
		  
		   //Expand Elements in new page - xpath with order number
		 driver.findElement(By.xpath("//div[@class='left-pannel'][1]")).click();
		 driver.findElement(By.xpath("//*[text()='Check Box']")).click();
		 
		 //Expand Home
		WebElement expandHome = driver.findElement(By.className("rc-tree-switcher"));
	    expandHome.click();
	    
	   scrollDown();
	   screenShots();
		   //Expand all the items with + icon
		 List<WebElement> ExpandItems = driver.findElements(By.cssSelector(".rc-tree-switcher_close"));
		 System.out.println("The Number of items under Home is: "+ExpandItems.size());
		
		 for(WebElement ExpandAll:ExpandItems)
		 {
			 
			 ExpandAll.click();	
			 
		 }
		 
		 //Selects all the checkboxes
		 List<WebElement> SelectAll = driver.findElements(By.cssSelector(".rc-tree-checkbox"));
		 for(int i=0;i<SelectAll.size();i++) 
		 {
			 SelectAll.get(i).click();
			 
		 } 
		 WebElement result = driver.findElement(By.id("result"));
		 System.out.println(result.getText());
		 
	
		 //deselects Desktop
		 WebElement DeselectDesktop = driver.findElement(By.xpath("//span[@aria-label=\"Select Desktop\"]"));
		 DeselectDesktop.click();
	
		 String updatedText = result.getText();
		 //validates the result message
		 if(!updatedText.contains("desktop")) 
		 {
			 System.out.println("Testcase passed(desktop deselected)");
		 }
		 else 
		 {
			 System.out.println("Testcase failed");
		 }
	}
}
		 
		 //Try later
//		 //Deselect the selected checkbox
//		 for(int i=0;i<SelectAll.size();i++)
//		 {
//			 if(SelectAll.get(i).isSelected())
//			 {
//				 SelectAll.get(i).click();
//			 }
//		 }
//		 String deselectedBoxes = result.getText();
//		 //validates the result message
//		 if(!deselectedBoxes.contains("documents")) {
//			 System.out.println("Testcase passed(desktop deselected)");
//		 }
//		 else {
//			 System.out.println("Testcase failed");
//		 }
		
		 
		 
		 //***************Try later
//		 //Selecting last 3 checkboxes
//		 //Total no.of checkboxes - no.of checkboxes to select

		
//		 Thread.sleep(5000);
//		 for(int i=7;i<SelectAll.size();i++)
//		 {
//			 SelectAll.get(i).click();
//		 }
//		 System.out.println("-------Result after deselecting last 3 checkboxes------"+"\n" +result.getText());
		 //driver.close();
				
