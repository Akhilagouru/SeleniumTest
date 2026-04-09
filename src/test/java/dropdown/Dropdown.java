package dropdown;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import HerokuAppBase.HerokuAppBaseClass;


public class Dropdown extends HerokuAppBaseClass
{
	@Test
	public void selectDropdown() throws InterruptedException 
	{
		driver.findElement(By.xpath("//*[text()='Dropdown']")).click();
		
		Thread.sleep(3000);
		WebElement dropdown = driver.findElement(By.xpath("//select[@id='dropdown']"));
		Select dropdownValue=new Select(dropdown);
		
		//print the size of options
		List<WebElement>options=dropdownValue.getOptions();
		System.out.println("No.of options in the dropdown are : "+options.size());
		
		//print the text in the dropdown
		System.out.println("options in the dropdown are: ");
		for(WebElement opt:options)
		{
			System.out.println(opt.getText());
		}
		
		Thread.sleep(2000);
		dropdownValue.selectByIndex(0);
		System.out.println("Text in dropdown after selecting option 1 : "+dropdownValue.getFirstSelectedOption().getText());
	
	}

}
