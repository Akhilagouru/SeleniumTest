package Authentication_Popup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AuthenticationPopup 
{
	public static void main(String Args[])
	{
		WebDriver driver=new ChromeDriver();
		driver.get("http://admin:admin@the-internet.herokuapp.com/digest_auth");
		//System.out.println(driver.getTitle());
		if(driver.getTitle().equals("The Internet"))
		{
			System.out.println("Testcase Passed");
		}
		driver.close();
	}

}
