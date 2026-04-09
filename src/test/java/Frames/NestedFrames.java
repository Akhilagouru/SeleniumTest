package Frames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NestedFrames {
	public static void main(String Args[])
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/frames");
		
		 driver.findElement(By.xpath("//*[text()='Nested Frames']")).click();
		 driver.switchTo().frame("frame-top");
		 driver.switchTo().frame("frame-left");
		 
		 // Print text inside left frame
	     String text = driver.findElement(By.tagName("body")).getText();
	     System.out.println("Text in Left Frame: " + text);

	     //Switch to top frame(parent)
	     driver.switchTo().parentFrame();

	        //Switch to middle frame
	        driver.switchTo().frame("frame-middle");
	        String text1=driver.findElement(By.tagName("body")).getText();
	        System.out.println("Middle Frame Text: " + text1);
	        
	        //switch to back
	        driver.switchTo().defaultContent();
	        System.out.println(driver.getTitle());
		
		
		//driver.close();
	}	
}
