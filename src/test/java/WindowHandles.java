import java.awt.Robot;
import java.awt.datatransfer.DataFlavor;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.awt.Toolkit;

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
			  
			  //window navigation
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
			  logger.info("Handled child window and closed it successfully");
			  driver.switchTo().window(parentWindow);
			  logger.info("switched back to parent window successfully");
			  System.out.println("parent window is: " + driver.getTitle() );
			  
			  
			  String parentTab = driver.getWindowHandle();
			  driver.findElement(By.id("tabButton")).click();
			  
			 //Tab navigation
			 Set<String> tabHandles = driver.getWindowHandles();
			 for(String childTab : tabHandles)
			 {
				 if(!childTab.equals(parentTab))
				 {
					 driver.switchTo().window(childTab);
					 System.out.println("Title of child tab is: "+driver.getTitle());
					 driver.close();
				 }
			 }
			 logger.info("Handled child tab and closed it successfully");
			 driver.switchTo().window(parentTab);
			 logger.info("switched back to parent tab successfully");
			 
			 //window message navigation
			 String parentMessageWindow = driver.getWindowHandle();
			 driver.findElement(By.id("messageWindowButton")).click();
			 
			 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			 wait.until(ExpectedConditions.numberOfWindowsToBe(2));

			 Set<String> messageWindowHandles = driver.getWindowHandles();
			 for(String childmessageWindow : messageWindowHandles)
			 {
				 if(!childmessageWindow.equals(parentMessageWindow))
				 {
				    driver.switchTo().window(childmessageWindow);
				    logger.info("switched to child message window successfully");


				    /* message window is behaving differently
				       with the current Chrome/Selenium combination.
				       Selenium switchTo().window() works, but getTitle(), findElement(), getPageSource() and JavaScript execution time out. 
				       Therefore use the browser's Select All + Copy * operation to retrieve the visible text. */
				    Robot robot = new Robot();
				    robot.keyPress(KeyEvent.VK_CONTROL); 
				    robot.keyPress(KeyEvent.VK_A); 
				    robot.keyRelease(KeyEvent.VK_A); 
				    robot.keyRelease(KeyEvent.VK_CONTROL);
				    robot.keyPress(KeyEvent.VK_CONTROL);
				    robot.keyPress(KeyEvent.VK_C);
				    robot.keyRelease(KeyEvent.VK_C); 
				    robot.keyRelease(KeyEvent.VK_CONTROL); 
				    Thread.sleep(500);
				    String message = (String) Toolkit.getDefaultToolkit() .getSystemClipboard() .getData(DataFlavor.stringFlavor);
				    System.out.println("Message in child window: " + message);
                    driver.close();
				 }
			 }
			 logger.info("Handled child message window and closed it successfully");
			 logger.info("*****Testcase execution completed*****");
			 
		}
		catch(Exception e)
		{
			logger.error("*****Testcase Failed*****", e);
			//throw e;
			//logger.error(e.getMessage());
			throw new RuntimeException(e);
		}
	  
  }
}
