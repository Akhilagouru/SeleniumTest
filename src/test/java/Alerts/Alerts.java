package Alerts;


import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import DemoQABase.DemoqaBaseClass;


public class Alerts extends DemoqaBaseClass
{
	public void navigateToAlert()
	{
		//click on Elements
		driver.findElement(By.xpath("//div[normalize-space()='Elements']")).click();
		scrollDown();
						  
		driver.findElement(By.xpath("//*[text()='Alerts, Frame & Windows']")).click();
		driver.findElement(By.xpath("//*[text()='Alerts']")).click();
	}
	@Test
    public void alert() throws InterruptedException
    {
		navigateToAlert();
     
      
        driver.findElement(By.id("alertButton")).click();
        
        Thread.sleep(2000);
        Alert myalert = driver.switchTo().alert();
        System.out.println("Text in the alert is: "+myalert.getText());
        myalert.accept();
        
        //validating the alert text
        if(myalert.getText().equals("You clicked a button"))
        {
        	System.out.println("Testcase Passed");
        }
        else
        {
        	System.out.println("Testcase Failed");
        }
        
    }
	@Test
	public void timerAlert() throws InterruptedException
	{
		navigateToAlert();
		
		//Timer Alert and print the alert text
        driver.findElement(By.id("timerAlertButton")).click();
        Thread.sleep(5000);
        Alert mytimeralert = driver.switchTo().alert();
        Thread.sleep(2000);
        System.out.println("Text in Timer Alert is: "+mytimeralert.getText());
        mytimeralert.accept();
	}
	@Test
	public void confirmationAlert() throws InterruptedException
	{
		navigateToAlert();
		
		driver.findElement(By.id("confirmButton")).click();
		Thread.sleep(2000);
		
		//driver.switchTo().alert().accept();   //closes alert by OK
		driver.switchTo().alert().dismiss();  //closes alert by Cancel
		
		//validating alert message
		WebElement alertMessage = driver.findElement(By.cssSelector(".text-success"));
		System.out.println(alertMessage);
		if(alertMessage.getText().equals("You selected Cancel"))
		{
			System.out.println("Alert Closed by Cancel");
		}
	
	}
	@Test
	public void promptAlert()
	{
		navigateToAlert();
		
		driver.findElement(By.id("promtButton")).click();
		Alert myalert = driver.switchTo().alert();
		myalert.sendKeys("Welcome to Prompt alert");
		myalert.accept();
		
		WebElement promptmessage = driver.findElement(By.className("text-success"));
		System.out.println(promptmessage.getText());	
		
	}
	@Test
	public void handlingAlertWithExplicitWait() throws InterruptedException
	{
		navigateToAlert();
	     	      
        driver.findElement(By.id("alertButton")).click();
        WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Thread.sleep(2000);
        Alert myalert = mywait.until(ExpectedConditions.alertIsPresent());
        System.out.println("Text in the alert is: "+myalert.getText());
        myalert.accept();
		
	}
}
