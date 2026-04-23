import java.util.List;

import org.apache.poi.ss.usermodel.Header;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.google.common.base.MoreObjects.ToStringHelper;

import DemoQABase.DemoqaBaseClass;

public class WebTable extends DemoqaBaseClass
{
	@Test
	public void staticElements() throws Exception
	{
		 scrollWithWait();
	     //Click on Elements
	     WebElement ele = driver.findElement(By.xpath("//div[normalize-space()='Elements']"));    
	     ele.click();
	     
	     //Click on Web Table and get the row count of the table
	     driver.findElement(By.xpath("//*[normalize-space()='Web Tables']")).click();
	     int tableSize =driver.findElements(By.tagName("tr")).size();
	     System.out.print("Number of rows in the table:" +tableSize +"\n");
	     
         //Get the column count
	     int colSize = driver.findElements(By.tagName("th")).size();
	     System.out.print("Number of columns in the table:" +colSize +"\n");
	     List<WebElement> colHeader = driver.findElements(By.tagName("th"));
	     //print the Headers
	     System.out.println("***Table Headers***");
	     for(WebElement Headers : colHeader)
	     {
	    	System.out.println(Headers.getText());
	    	 
	     }
	     
	     //Select value from specific row and column(2nd row 4th column)
	     String email = driver.findElement(By.xpath("//tr[2]//td[4]")).getText();  
	     System.out.println(email);
	}
	
}
