import java.io.FileInputStream;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelFileWithoutInheritance 
{
    /* code to read data from excel */
    @DataProvider(name="TextboxSubmit")
    public Object[][] getData() throws Exception
    {
	//opens excel file 
	FileInputStream file = new FileInputStream("C:\\Users\\karth\\OneDrive\\Documents\\Akhila\\Akhila Subex\\Automation testing\\Test.xlsx");
	//access workbook(excel file) and specific sheet
	XSSFWorkbook wb= new XSSFWorkbook(file);
	XSSFSheet sheet = wb.getSheet("Sheet1");
	
	//total number of data rows and columns
	int rows= sheet.getLastRowNum();
	int cols= sheet.getRow(0).getLastCellNum();
	
	//Stores Excel data in memory
	Object[][] data = new Object[rows][cols];
	
	//Reads Row by row, Cell by cell, skips header
	for (int i = 1; i <= rows; i++) 
	{
	    for (int j = 0; j < cols; j++) 
	    {
	        data[i-1][j] = sheet.getRow(i).getCell(j).toString(); 
   	    }
	}
	wb.close();
	file.close();
	return data;
	
}
	public WebDriver driver;
    public WebElement ele;

    
	@Test(dataProvider = "TextboxSubmit")
	public void readExcelFullMethod(String userfullname, String email)
	{
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       
        /*opens demoqa website
         *Select Elements
         * Click on Textbox from left panel
         * enter the full name and email from excel file and Submit 
         * Iterate it for the no.of times as the no.of records present in excel file
         */
        driver.get("https://demoqa.com");
        driver.manage().window().maximize();
		
		//Scroll down the page
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).perform();

        driver.findElement(By.xpath("//div[normalize-space()='Elements']")).click();
        driver.findElement(By.xpath("//div[@class='left-pannel'][1]")).click();
        driver.findElement(By.xpath("(//li[@id='item-0'])[1]")).click();
        
        	
        WebElement username = driver.findElement(By.id("userName"));
    	WebElement useremail = driver.findElement(By.id("userEmail"));
    	if(!username.equals(null))
    	{
    	      username.clear();
    	      username.sendKeys(userfullname);
    	}
    	if(!useremail.equals(null))
        {
    	     useremail.clear();
    	     useremail.sendKeys(email);
     	}
    	
		actions.sendKeys(Keys.PAGE_DOWN).perform();
    	 
        driver.findElement(By.id("submit")).click();
    	 
        //print the output after submit
        WebElement output = driver.findElement(By.id("output"));
        String userDetails = output.getText();
    	System.out.println("Details of "+userfullname+" is "+"\n"+userDetails);	
    	
    	driver.quit();
    }
}

