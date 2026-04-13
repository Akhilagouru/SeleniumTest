package dropdown;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import DemoQABase.DemoqaBaseClass;


public class Dropdown extends DemoqaBaseClass
{
	@Test
	public void selectDropdown() throws InterruptedException 
	{
		 //Click on Elements
		 driver.findElement(By.xpath("//div[normalize-space()='Elements']")).click();
		 scrollDown();
		 //click on Widget -> Select Menu
		 driver.findElement(By.xpath("//*[text()='Widgets']")).click();
		 scrollDown();
		driver.findElement(By.xpath("//*[text()='Select Menu']")).click();
		
		
		WebElement dropdown= driver.findElement(By.id("oldSelectMenu"));		
		Select dropdownValue=new Select(dropdown);
		
		//print the size of options
		List<WebElement>options=dropdownValue.getOptions();
		System.out.println("No.of options in the dropdown are : "+options.size());
		
		//print the text in the dropdown
		System.out.println("options in the dropdown are: ");
		for(WebElement opt:options)
		{
			System.out.println(opt.getText());
		}
		
		Thread.sleep(2000);
		dropdownValue.selectByVisibleText("Green");
		System.out.println("Text in dropdown after selecting option 1 : "+dropdownValue.getFirstSelectedOption().getText());
	
	}
	@Test
	public void hiddenMultiselectDropdown() 
	{
		 //Click on Elements
		 driver.findElement(By.xpath("//div[normalize-space()='Elements']")).click();
		 scrollDown();
		 //click on Widget -> Select Menu
		 driver.findElement(By.xpath("//*[text()='Widgets']")).click();
		 scrollDown();
		 driver.findElement(By.xpath("//*[text()='Select Menu']")).click();
		
		 driver.findElement(By.xpath("//*[normalize-space()='Select...']")).click();
		
		 //get count of options in the dropdown
		 List<WebElement> Options = driver.findElements(By.xpath("//*[contains(@class,'option')]"));		 
		 System.out.println("number of options in the multi-select dropdown are : "+Options.size());
		  //get the text of values in dropdown and selecting values using text
		 System.out.println("Options in the multi-select dropdown are :");
		 for(WebElement opt:Options)
		 {
			 System.out.println(opt.getText());
			 if(opt.getText().equals("Green")|| opt.getText().equals("Red")|| opt.getText().equals("Black"))
			 {
				 opt.click();
			 }
		 }
		 
//		 //Select multiple options using locator
//		 driver.findElement(By.xpath("//div[text()='Green']")).click();
//		 driver.findElement(By.xpath("//div[text()='Red']")).click();
	}

}
