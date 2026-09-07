import java.util.Set;

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
               
			  String parentWindow = driver.getWindowHandle();
			  driver.findElement(By.id("windowButton")).click();
			  Set<String> windoHandles = driver.getWindowHandles();
			  for(String childWindow : windoHandles) 
			  {
				  if(!childWindow.equals(parentWindow))
				  {
				 driver.switchTo().window(childWindow);
				 System.out.println("child window is: " + childWindow+driver.getTitle() );
				 driver.close();
				 }
			  }
		}
		catch(Exception e)
		{
			logger.error("*****Testcase Failed*****");
			logger.error(e.getMessage());
		}
	  
  }
}
