import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class RSATest {
	
	
	@Test
	public void homePageCheck() throws MalformedURLException
	{
		
		DesiredCapabilities caps = new DesiredCapabilities();
		//caps.setBrowserName("FireFox");
		//caps.setPlatform(Platform.WIN10);
		//caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		caps.setCapability(CapabilityType.BROWSER_NAME, "firefox");
		
		//Started Selenium Hub 4.3.0 (revision a4995e2c09*): http://10.0.11.52:4444
		WebDriver driver = new RemoteWebDriver(new URL("http://10.0.11.52:4444"), caps); //This is because we are using a HUB and using remote machines
		driver.get("https://www.rahulshettyacademy.com/");
		System.out.println(driver.getTitle());
		driver.close();
		
	}

}
