import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v103.fetch.Fetch;

public class NetworkMocking {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\JK\\chromedriver_win32\\chromedriver.exe");
		//webdriver.chrome.driver is a key value, a property
		
		//For the Chrome Dev Tools we must use ChromeDriver NOT WebDriver
		ChromeDriver driver = new ChromeDriver();
		
		DevTools devToolsJK = driver.getDevTools();
		devToolsJK.createSession();
		
		//First we need to enable
		devToolsJK.send(Fetch.enable(Optional.empty(), Optional.empty()));
		
		devToolsJK.addListener(Fetch.requestPaused(), request ->
		{
			
			if( request.getRequest().getUrl().contains("shetty") )
			{
				String mockedUrl = request.getRequest().getUrl().replace("=shetty", "=BadGuy");
				System.out.println(mockedUrl);
				
				devToolsJK.send(Fetch.continueRequest(request.getRequestId(), Optional.of(mockedUrl), Optional.of(request.getRequest().getMethod()), Optional.empty(), Optional.empty(), Optional.empty()));
				
			}
			else 
			{
				devToolsJK.send(Fetch.continueRequest(request.getRequestId(), Optional.of(request.getRequest().getUrl()), Optional.of(request.getRequest().getMethod()), Optional.empty(), Optional.empty(), Optional.empty()));

			}
			
		});
		
		
		driver.get("https://www.rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector(".btn.btn-primary")).click();
		Thread.sleep(3000);
		
		System.out.println(driver.findElement(By.cssSelector("p")).getText());
		
		
	}

}
