package Functional_Library;

import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Utilities.XcelReader;

public class Common_Methods<chrProfiles> {

	String driverpath = "E:\\Balaji\\Balaji\\Testing Software\\chromedriver.exe";
	public WebDriver driver;
	public static WebDriver init_driver;
	public static String baseurl = "https://test3.icoreemr.com";
	
	XcelReader ex = new XcelReader();

	public void goLauchBrowser(String baseurl) {
		try {
			System.setProperty("webdriver.chrome.driver", driverpath);
			driver = new ChromeDriver();
			driver.get(baseurl);
			driver.manage().window().maximize();
			init_driver = driver;
		} catch (Exception e) {
			System.out.println("Error...." + e.getStackTrace());
		}

	}

	public void goInputByName(String tag, String Value) {
		this.driver.findElement(By.name(tag)).sendKeys(Value);
	}
	
	public void goInputById(String tag, String Value) {
		this.driver.findElement(By.id(tag)).sendKeys(Value);
	}
	
	public void goInputByEx(String tag, String Value) {
		this.driver.findElement(By.xpath(tag)).sendKeys(Value);
	}
	
	public void goSubmitByName(String tag) {
		this.driver.findElement(By.name(tag)).click();
		
	}
	
	public void goSubmitById(String tag) {
		this.driver.findElement(By.id(tag)).click();
	}
	
	public void goSubmitByEx(String tag) {
		this.driver.findElement(By.xpath(tag)).click();
	}
	
	public void ImplicitWait(int Seconds) {
		this.driver.manage().timeouts().implicitlyWait(Seconds, TimeUnit.SECONDS);
	}
	
	public void CloseBrowser() {
		driver.quit();
	}
	
	public String getExcelValue(String sheetName, int RowNum, int CellNum) throws FileNotFoundException, InvalidFormatException {
		return ex.getExcelValue(sheetName,RowNum,CellNum);
	}
	
	public void setExcelValue(String sheetName, int RowNum, int CellNum, String Result) throws InvalidFormatException {
		ex.setExcelValue(sheetName, RowNum, CellNum, Result);
	}
	
	public WebDriver getDriver() {
		return init_driver;
	}
	
	public void setDriver() {
		this.driver=this.getDriver();
	}
}