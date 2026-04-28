import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import DemoQABase.DemoqaBaseClass;

public class WebTable extends DemoqaBaseClass
{
	public void setupWebTable() throws Exception
	{
		Thread.sleep(6000);
		
		//Click on Elements and go to web table
	     WebElement ele = driver.findElement(By.xpath("//div[normalize-space()='Elements']"));
	     scrollDown();
	     ele.click();
	     
	     driver.findElement(By.xpath("//*[normalize-space()='Web Tables']")).click();	
	}
	
	@Test
	public void staticElements() throws Exception
	{
		
		setupWebTable();
	     
	     // get the row count of the table
	     int rowSize =driver.findElements(By.xpath("//tbody//tr")).size();
	     System.out.print("Number of rows in the table:" +rowSize +"\n");
	     
         //Get the column count
	     int colSize = driver.findElements(By.tagName("th")).size();
	     System.out.print("Number of columns in the table:" +colSize +"\n");
	     
	     
	     //Select value from specific row and column(2nd row 4th column)
	     String email = driver.findElement(By.xpath("//tr[2]//td[4]")).getText();  
	     System.out.println(email);
	     
	   //print the Headers
	     List<WebElement> colHeader = driver.findElements(By.tagName("th"));
	     for(WebElement Headers : colHeader)
	     {
	    	System.out.print(Headers.getText()+"\t");
	    	 
	     }
	     System.out.println();
	     //Read data from all rows and cols and print the table
	     for(int r=1;r<=rowSize;r++)
	     {
	    	 for(int c=1;c<=colSize;c++)
	    	 {
	    		 String tableData = driver.findElement(By.xpath("//table//tbody//tr["+r+"]//td["+c+"]")).getText();
	    		 System.out.print(tableData+"\t");
	    	 }
	    	 System.out.println();
	     }
	     
	     //Get the data based on the condition(First name whose salary=10000)
	     for(int r=1;r<=3;r++)
	     {
	    	 String salaryCol=driver.findElement(By.xpath("//table//tbody//tr["+r+"]//td[5]")).getText();
	    	 if (salaryCol.equals("10000")) 
	    	 {
	    		 String firstName=driver.findElement(By.xpath("//table//tbody//tr["+r+"]//td[1]")).getText();
				System.out.print("First name of employee with salary 1000 is: "+firstName +"\t" +salaryCol);
			}
	     } 
	}
	@Test
	 public void dynamicWebTable() throws Exception
	 
     {
		 scrollWithWait();
		 WebElement ele = driver.findElement(By.xpath("//div[normalize-space()='Elements']")); 
	     ele.click();
	     
	     driver.findElement(By.xpath("//*[normalize-space()='Web Tables']")).click();	
    	 
    	 //Add the rows and fill the details
    	 for(int i=0;i<=20;i++)
    	 {
    		 Thread.sleep(5000);
    		 driver.findElement(By.id("addNewRecordButton")).click();
    		 driver.findElement(By.id("firstName")).sendKeys("Antony");
    		 driver.findElement(By.id("lastName")).sendKeys("Singh");
    		 driver.findElement(By.id("userEmail")).sendKeys("Antony@example.com");
    		 driver.findElement(By.id("age")).sendKeys("25");
    		 driver.findElement(By.id("salary")).sendKeys("10000");
    		 driver.findElement(By.id("department")).sendKeys("IT");	 
    	     driver.findElement(By.id("submit")).click();
             
    	 }
    	  //Get the count of pages in the table from pagenation 
         String pagenation = driver.findElement(By.xpath("//div[@class='col-auto'][2]")).getText();
         System.out.println(pagenation);
         String[] parts = pagenation.split(" ");

         int totalPages = Integer.parseInt(parts[parts.length - 1]);

         System.out.println("Total Pages: " + totalPages);
        
        tearDown();
    	 
     }
	
}
