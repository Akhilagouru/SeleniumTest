package demoqa;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TextBoxFromExcelFile extends DemoqaBaseClass
{
	@Test(dataProvider="LoginData")
	public void readExcel(String fullname, String email) throws Exception
	{
		try
		{
		scrollDown();

        driver.findElement(By.xpath("//div[normalize-space()='Elements']")).click();
        removeAds();
        driver.findElement(By.xpath("//div[@class='left-pannel'][1]")).click();
        driver.findElement(By.xpath("//span[normalize-space()='Text Box']")).click();
        
        logger.info("Navigated to Elements -> Text Box page");
            
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
		logger.info("Entered the details from excel file into the textboxes");
	 
		scrollDown();
	    driver.findElement(By.id("submit")).click();
	    logger.info("Submitted the details");
	 
	  //print the output after submit
	  WebElement output = driver.findElement(By.id("output"));
	  String userDetails = output.getText();

	  System.out.println("Details of "+fullname+" is "+"\n"+userDetails);	
	  logger.info("printed the output after submit");
	  //driver.quit();
	  
	}
    catch(Exception e)
	{
    	logger.error("*****Testcase Failed*****", e);
		throw new RuntimeException(e);
	}
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





