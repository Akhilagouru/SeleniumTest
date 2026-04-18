import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import DemoQABase.DemoqaBaseClass;

public class WebTable extends DemoqaBaseClass
{
	@Test
	public void staticElements()
	{
	     //Click on Elements
	     driver.findElement(By.xpath("//div[normalize-space()='Elements']")).click();
	     
	     //Click on Web Table and get the row count of the table
	     driver.findElement(By.xpath("//*[normalize-space()='Web Tables']")).click();
	     int tableSize =driver.findElements(By.tagName("tr")).size();
	     System.out.print("Number of rows in the table:" +tableSize);
	     

	}
	
}
