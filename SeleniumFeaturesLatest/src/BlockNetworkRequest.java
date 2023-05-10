import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v103.network.Network;

import com.google.common.collect.ImmutableList;

public class BlockNetworkRequest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\JK\\chromedriver_win32\\chromedriver.exe");
		//webdriver.chrome.driver is a key value, a property
		
		//For the Chrome Dev Tools we must use ChromeDriver NOT WebDriver
		ChromeDriver driver = new ChromeDriver();
		
		DevTools devToolsJK = driver.getDevTools();
		devToolsJK.createSession();
		
		
		//First we need to enable this Network
		devToolsJK.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		devToolsJK.send(Network.setBlockedURLs(ImmutableList.of("*.jpeg", "*.png")));
		
		/*driver.get("https://www.rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.xpath("//a[text()='Browse Products']")).click();
		Thread.sleep(3000);*/
		
		driver.get("https://www.rahulshettyacademy.com/");
		driver.findElement(By.xpath("//a[text()='Courses']")).click();
		Thread.sleep(3000);
		
		
		
	}

}
