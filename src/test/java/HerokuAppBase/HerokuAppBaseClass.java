package HerokuAppBase;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class HerokuAppBaseClass {
	 public WebDriver driver;
	 public WebElement ele;

	 @BeforeMethod
	 public void setup() 
	 {
		    driver = new ChromeDriver();   // FIXED (removed local variable)

	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	        driver.get("https://the-internet.herokuapp.com");
	        driver.manage().window().maximize();
	 
	 }
	 public void scrollDown()
	    {
	    	 //Scroll down the page
			   Actions actions = new Actions(driver);
			   actions.sendKeys(Keys.PAGE_DOWN).perform();
	    }
	    public void clickInterception(WebElement ele) 
	    {

	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", ele);
	    }
	    @AfterMethod
	    public void tearDown() {

	        driver.quit();
	    }

}
