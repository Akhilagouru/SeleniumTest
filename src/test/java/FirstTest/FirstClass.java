package FirstTest;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class FirstClass {
	public static void main(String Args[]) throws InterruptedException 
	{
		WebDriver driver= new ChromeDriver();
		
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//explicit wait
		WebDriverWait mywait = new WebDriverWait(driver,Duration.ofSeconds(10)); 
		
		
		driver.get("https://demoqa.com/");
		//driver.get("https://demo.opencart.com/");
	
		//maximize
		driver.manage().window().maximize();
		
		//Title validation
	    String title = driver.getTitle();
	    System.out.println("Title of homepage: "+title);
	    
	    //== gives wrong result bcz == compares references while .equals compares content
	    if(title.equals("demosite"))
	    {
	    	System.out.println("Validating title : Testcase Passed");
	    }else
	    {
	    	System.out.println("Validating title : Testcase Failed");
	    }
	   
	  // Finding elements(images) in the home page  
	    List<WebElement> Links = driver.findElements(By.tagName("img"));
	    System.out.println("Number of images:" +Links.size());
	    
	   
	   //xpath - click on Elements
	   driver.findElement(By.xpath("//div[normalize-space()='Elements']")).click();
	   System.out.println("Title of Elements page:" +driver.getTitle());
	   
	   //Expand Elements in new page - xpath with order number
	   WebElement elements = mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='left-pannel'][1]")));
	   elements.click();
	    
	   //prints the items in Elements ----css selector with multiple tags
	   List<WebElement> ListOfElements = driver.findElements(By.cssSelector(".element-list.collapse.show .menu-list .text"));
 
	   System.out.println("number of elements:" +ListOfElements.size());
	   System.out.println("***Elements***");
	   for (WebElement item : ListOfElements) {
	       System.out.println(item.getText());
	   }
	   
	   //Scroll down the page
	   Actions actions = new Actions(driver);
	   actions.sendKeys(Keys.PAGE_DOWN).perform();
	   
	   //Expand Elements in new page 
	   WebElement forms = driver.findElement(By.xpath("//div[text()='Forms']"));
	   forms.click();
	    
	   //prints the items in Elements ----css selector with multiple tags
	   List<WebElement> ListOfForms = driver.findElements(By.cssSelector(".element-list.collapse.show .menu-list .text"));
 
	   System.out.println("***Forms***");
	   for (WebElement item : ListOfForms) {
	       System.out.println(item.getText());
	   }
	   
	   driver.findElement(By.xpath("//div[text()='Alerts, Frame & Windows']")).click();
	   driver.findElement(By.xpath("//span[text()='Browser Windows']")).click();
	    
	   //Handling tabs - prints the browser ids
	   driver.findElement(By.id("tabButton")).click();
	   Set<String> WindowIds = driver.getWindowHandles();
	   System.out.println(WindowIds);
	   
	   
//	  //navigating between windows - validating the title of child window
//	   for (String winid:WindowIds)
//	   {
//		   String Title = driver.switchTo().window(winid).getTitle();
//		   System.out.println("Title of the" +winid + "is : '" +Title +"'");
//	  //closes the only the page whose title is demopage
//	   if(Title.equals ("demosite"))
//		   {
//			   driver.close();
//			   break;
//		   }
//	   }
	  // driver.quit();
	}
}

