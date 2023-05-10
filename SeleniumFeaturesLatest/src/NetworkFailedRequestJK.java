import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v103.fetch.Fetch;
import org.openqa.selenium.devtools.v103.fetch.model.RequestPattern;
import org.openqa.selenium.devtools.v103.network.model.ErrorReason;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NetworkFailedRequestJK {
	
	ChromeDriver driver;
	@BeforeTest
	public void somethingJK() throws InterruptedException
	{
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\JK\\chromedriver_win32\\chromedriver.exe");
		//webdriver.chrome.driver is a key value, a property
		
		//For the Chrome Dev Tools we must use ChromeDriver NOT WebDriver
		driver = new ChromeDriver();
		
		DevTools devToolsJK = driver.getDevTools();
		devToolsJK.createSession();
		
		//First we need to enable and catch an URL call with GetBook
		Optional<List<RequestPattern>> patterns = Optional.of(Arrays.asList( new RequestPattern(Optional.of("*GetBook*"), Optional.empty(),Optional.empty())));
		devToolsJK.send(Fetch.enable(patterns, Optional.empty()));
		
		//Now Listener pauses this call and fails it
		devToolsJK.addListener(Fetch.requestPaused(), request ->
		{
			devToolsJK.send(Fetch.failRequest(request.getRequestId(), ErrorReason.FAILED));
		});
		
		
		driver.get("https://www.rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector(".btn.btn-primary")).click();
		Thread.sleep(3000);
		
		
		/*Boolean tableJK= driver.findElement(By.xpath("//tbody")).isDisplayed();
		System.out.println(tableJK);
		Assert.assertFalse(tableJK);*/
		
	
	}
	
	@Test
	public void MyTesttt()
	{
	
	Boolean tableJK= driver.findElement(By.xpath("//tbody")).isDisplayed();
	System.out.println(tableJK);
	Assert.assertFalse(tableJK);
	}
	

}
