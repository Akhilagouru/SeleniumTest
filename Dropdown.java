package dropdown;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import internet.HerokuAppBaseClass;

public class Dropdown extends HerokuAppBaseClass{
	@Test
	public void selectDropdown() throws InterruptedException 
	{
		driver.findElement(By.xpath("//*[text()='Dropdown']")).click();
		
		Thread.sleep(3000);
		WebElement dropdown = driver.findElement(By.xpath("//select[@id='dropdown']"));
		Select dropdownValue=new Select(dropdown);
		List<WebElement>options=dropdownValue.getOptions();
		System.out.println("Options in the dropdown are : "+options.size());
		
		Thread.sleep(2000);
		dropdownValue.selectByVisibleText("Option 1");
		System.out.println("Text in dropdown after selecting option 1 : "+dropdownValue.getFirstSelectedOption().getText());
		
	}

}
