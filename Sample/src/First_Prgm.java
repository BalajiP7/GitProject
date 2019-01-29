import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class First_Prgm {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver;
		
		System.setProperty("webdriver.chrome.driver", "E:\\Balaji\\Balaji\\Testing Software\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.get("https://test3.icoreemr.com");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.name("username")).sendKeys("imedicor");
		
		driver.findElement(By.name("password")).sendKeys("Y9F!jk@bpPhJ4s");
		
		driver.findElement(By.xpath("//html//body//div[2]//div//div//form//div//div[1]//div[3]//div//input")).click();
		
		Thread.sleep(3000);
		
		driver.close();
		
	}

}
