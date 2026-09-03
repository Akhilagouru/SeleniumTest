import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import DemoQABase.DemoqaBaseClass;

public class ExcelFile extends DemoqaBaseClass
{
	@Test(dataProvider="LoginData")
	public void readExcel(String fullname, String email) throws Exception
	{
		scrollDown();

        driver.findElement(By.xpath("//div[normalize-space()='Elements']")).click();
        driver.findElement(By.xpath("//div[@class='left-pannel'][1]")).click();
        driver.findElement(By.xpath("(//li[@id='item-0'])[1]")).click();
        
        
	    //clears the text which is already present in the textbox and enters new row(name/email) from excel
		WebElement username = driver.findElement(By.id("userName"));
		WebElement useremail = driver.findElement(By.id("userEmail"));
		if(!username.equals(null))
		{
	       username.clear();
	       username.sendKeys(fullname);
		}
		if(!useremail.equals(null))
		{
	       useremail.clear();
	       useremail.sendKeys(email);
		}
	 
		scrollDown();
	    driver.findElement(By.id("submit")).click();
	 
	  //print the output after submit
	  WebElement output = driver.findElement(By.id("output"));
	  String userDetails = output.getText();
	  System.out.println("Details of "+fullname+" is "+"\n"+userDetails);	
	  
	  driver.quit();
  	
	}
}
//	@Test(dataProvider="LoginData")
//	public void writeToExcel() throws Exception
//	{
//	   driver.findElement(By.xpath("//div[normalize-space()='Elements']")).click();
//	  
//	   //Expand Elements in new page - xpath with order number
//	 driver.findElement(By.xpath("//div[@class='left-pannel'][1]")).click();
//	 driver.findElement(By.xpath("(//li[@id='item-0'])[1]")).click();
//	 writeData();
//	 
//	} 
//}





