import org.openqa.selenium.By;
import org.testng.annotations.Test;

import DemoQABase.DemoqaBaseClass;

public class ExcelFile extends DemoqaBaseClass
{
	@Test(dataProvider="LoginData")
	public void readExcel(String username)
	{
	 
	   driver.findElement(By.xpath("//div[normalize-space()='Elements']")).click();
	  
	   //Expand Elements in new page - xpath with order number
	 driver.findElement(By.xpath("//div[@class='left-pannel'][1]")).click();
	 driver.findElement(By.xpath("(//li[@id='item-0'])[1]")).click();
	 //getData();
	 driver.findElement(By.id("userName")).sendKeys(username);
	 
	} 
	@Test(dataProvider="LoginData")
	public void writeToExcel()
	{
	   driver.findElement(By.xpath("//div[normalize-space()='Elements']")).click();
	  
	   //Expand Elements in new page - xpath with order number
	 driver.findElement(By.xpath("//div[@class='left-pannel'][1]")).click();
	 driver.findElement(By.xpath("(//li[@id='item-0'])[1]")).click();
	 writeData();
	 
	} 
}
