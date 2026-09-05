import org.openqa.selenium.By;
import org.testng.annotations.Test;

import DemoQABase.DemoqaBaseClass;

public class WindowHandles extends DemoqaBaseClass
{
	@Test
  public void tabNavigation()
  {
		logger.info("*****Testcase execution started*****");		
		try
		{
			  scrollDown();
			  driver.findElement(By.xpath("//*[normalize-space()='Alerts, Frame & Windows']")).click();
			  driver.findElement(By.xpath("//*[normalize-space()='Browser Windows']")).click();	  
		}
		catch(Exception e)
		{
			logger.error("*****Testcase Failed*****");
			logger.error(e.getMessage());
		}
	  
  }
}
