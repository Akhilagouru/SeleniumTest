import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class SeleniumGrid 
{
	@Test
	public void seleniumGridTestGoogle() throws Exception
	{
		// Define browser
		ChromeOptions options = new ChromeOptions();
		options.setCapability("browserName", "MicrosoftEdge");

		// Connect to selenium Grid Hub
		WebDriver driver = new RemoteWebDriver(new URL("http://192.168.1.2:4444"), options);
	   
	   
	   // Test steps
        driver.get("https://www.google.com");
        System.out.println("Title: " + driver.getTitle());

        driver.quit();
	}

}
