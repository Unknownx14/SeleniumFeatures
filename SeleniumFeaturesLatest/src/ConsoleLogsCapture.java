import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

public class ConsoleLogsCapture {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\JK\\chromedriver_win32\\chromedriver.exe");
		//webdriver.chrome.driver is a key value, a property
		
		//For the Chrome Dev Tools we must use ChromeDriver NOT WebDriver
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://www.rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.xpath("//a[text()='Browse Products']")).click();
		driver.findElement(By.linkText("Selenium")).click();
		driver.findElement(By.cssSelector(".add-to-cart.btn.btn-default")).click();
		driver.findElement(By.cssSelector(".like.btn.btn-default")).click();
		driver.findElement(By.linkText("Appium")).click();
		driver.findElement(By.cssSelector(".add-to-cart.btn.btn-default")).click();
		driver.findElement(By.linkText("Cart")).click();
		driver.findElement(By.id("exampleInputEmail1")).clear();
		driver.findElement(By.id("exampleInputEmail1")).sendKeys("2");
		
		//This gives us all the logs from a Browser
		LogEntries entry = driver.manage().logs().get(LogType.BROWSER);
		List<LogEntry> logsListed = entry.getAll();
		
		for (LogEntry something :logsListed)
		{
			System.out.println( something.getMessage());
		}
		
		
	}

}
