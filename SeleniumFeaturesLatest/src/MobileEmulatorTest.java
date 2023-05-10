import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v103.emulation.Emulation;

public class MobileEmulatorTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		System.setProperty("webdriver.chrome.driver", "C:\\JK\\chromedriver_win32\\chromedriver.exe");
		//webdriver.chrome.driver is a key value, a property
		
		//For the Chrome Dev Tools we must use ChromeDriver NOT WebDriver
		ChromeDriver driver = new ChromeDriver();
		
		DevTools devToolsJK = driver.getDevTools();
		devToolsJK.createSession();
		
		//Send command to the CDP Methods -> CDP Methods will invoke and get an access to the Chrome Dev Tools
		devToolsJK.send(Emulation.setDeviceMetricsOverride(600, 1000, 50, true, Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty()));
		
		driver.get("https://www.rahulshettyacademy.com/angularAppdemo/");
		Thread.sleep(1000);
		driver.findElement(By.className("navbar-toggler-icon")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("a[href*='library']")).click();
		
		
	}

}
