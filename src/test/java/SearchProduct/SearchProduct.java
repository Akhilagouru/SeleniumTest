package SearchProduct;

import java.io.FileInputStream;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class SearchProduct 
{
	public WebElement ele;
	public WebDriver driver;
	
	@DataProvider(name="SearchKidsProducts")
	public Object[][] dataFromExcel() throws Exception
	{
		//opens excel file 
		FileInputStream fs = new FileInputStream("C:\\Users\\karth\\OneDrive\\Documents\\Akhila\\Akhila Subex\\Automation testing\\amazonSearch.xlsx");
		
		//access workbook(excel file) and specific sheet
		XSSFWorkbook wb= new XSSFWorkbook(fs);
		XSSFSheet sheet = wb.getSheet("sheet1");
		
		//returns the index of the last row
		int rows=sheet.getLastRowNum();
		//gives no.of columns
		int cols=sheet.getRow(0).getLastCellNum();
		
		//Stores Excel data in memory
		//This creates a 2-dimensional array to store your Excel data
		Object[][] data= new Object[rows][cols];
		
		for(int i=1;i<=rows;i++)
		{
			for (int j = 0; j < cols; j++) 
    	    {
    	        data[i-1][j] = sheet.getRow(i).getCell(j).toString(); 
       	    }
		}
		fs.close();
		wb.close();
		return data;
	}
	
	
	
	@Test(dataProvider = "SearchKidsProducts")
	public void searchKidsaccesories(String Kidneeds)
	{
		driver = new ChromeDriver();
		//Navigates to Amazon website
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//If the Continue Shopping button exists AND it is visible, click it.
		List<WebElement> ContinueShopping= driver.findElements(By.xpath("//*[normalize-space()='Continue shopping']"));		
		if(!ContinueShopping.isEmpty() && ContinueShopping.get(0).isDisplayed())
		{
			ContinueShopping.get(0).click();
		}
		
		//Search for kids dresses from home page
		WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
		searchBox.sendKeys(Kidneeds);
		driver.findElement(By.id("nav-search-submit-button")).click();
		
		WebElement items = driver.findElement(By.xpath("//div[contains(@class,'breadcrumb-header-text')]"));
		System.out.println(items.getText());
		
		
		driver.close();
	}

}
