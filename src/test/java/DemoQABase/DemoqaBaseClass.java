package DemoQABase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DemoqaBaseClass {

    public WebDriver driver;
    public WebElement ele;

    @BeforeClass
    public void setup() {

        driver = new ChromeDriver();   // FIXED (removed local variable)

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
       
        driver.get("https://demoqa.com");
        driver.manage().window().maximize();
    }

    public void scrollDown()
    {
    	 //Scroll down the page
		   Actions actions = new Actions(driver);
		   actions.sendKeys(Keys.PAGE_DOWN).perform();
    }
    public void scrollDownJs() throws InterruptedException
    {
         JavascriptExecutor js = (JavascriptExecutor)driver;
         js.executeScript("window.scrollBy(0, 500)");
    }
    public void scrollToCenter()
    {
    	((JavascriptExecutor) driver).executeScript(
    	    "arguments[0].scrollIntoView({block: 'center'});", ele);
    }
    public void scrollWithWait()
    {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	wait.until(webDriver -> 
    	    ((JavascriptExecutor) webDriver)
    	        .executeScript("return document.readyState")
    	        .equals("complete")
    	);
    }
    public void clickInterception(WebElement ele) 
    {

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", ele);
    }
    public void screenShots() throws IOException
    {
    	TakesScreenshot ss = (TakesScreenshot)driver;
    	File src = ss.getScreenshotAs(OutputType.FILE);
    	File dest = new File("C:\\Users\\akhila.reddy\\Downloads\\Akhila Subex\\Automation testing\\eclipse-workspace\\SeleniumTest\\screenshots\\test.png");

    	FileUtils.copyFile(src, dest);
    }
//    @AfterClass
//    public void tearDown()
//    {
//
//        driver.close();
//    }
//    
    @DataProvider(name="LoginData")
    public Object[][] getData() throws Exception
    {
    	//opens excel file 
    	FileInputStream file = new FileInputStream("C:\\Users\\akhila.reddy\\Downloads\\AutomationTest.xlsx");
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
    	return data;
    	
    }
    @DataProvider(name="LoginData")
    public Object[][] writeData() throws IOException 
    {
    	//creates excel file if doesn’t exist
    	FileOutputStream file =  new FileOutputStream("C:\\ Downloads\\AutomationTest.xlsx");
              //create workbook(excel file) and sheet
    	XSSFWorkbook wb= new XSSFWorkbook();
    	XSSFSheet sheet = wb.createSheet("Sheet1");

                 //Create Rows and enter the data
                  XSSFRow row1=sheet.createRow(0);
                       row1.createCell(0).setCellValue("Selenium");
                       row1.createCell(1).setCellValue(123);
                       row1.createCell(2).setCellValue("Java");
                    XSSFRow row2=sheet.createRow(1);
                       row2.createCell(0).setCellValue("Selenium");
                       row2.createCell(1).setCellValue(234);
                       row2.createCell(2).setCellValue("C#");
                       //Object[][] data = new Object[][];
                 //Attach workbook to file
          wb.write(file);
          wb.close();
          file.close();
		  return null;
      }
}

