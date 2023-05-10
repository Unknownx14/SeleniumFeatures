import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v103.network.Network;
import org.openqa.selenium.devtools.v103.network.model.Request;
import org.openqa.selenium.devtools.v103.network.model.Response;

public class NetworkLogActivity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\JK\\chromedriver_win32\\chromedriver.exe");
		//webdriver.chrome.driver is a key value, a property
		
		//For the Chrome Dev Tools we must use ChromeDriver NOT WebDriver
		ChromeDriver driver = new ChromeDriver();
		
		DevTools devToolsJK = driver.getDevTools();
		devToolsJK.createSession();
		
		devToolsJK.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		
		//
		devToolsJK.addListener(Network.requestWillBeSent(), request ->
		{
			Request req =request.getRequest();
			//System.out.println(req.getUrl());
			//System.out.println(req.getHeaders());
			
		});
		
		
		//Event will get fired
		devToolsJK.addListener(Network.responseReceived(), response ->
		{
			Response res = response.getResponse();
			//System.out.println(res.getUrl());
			//System.out.println(res.getStatus());
			if(res.getStatus()>400) // if(res.getStatus().toString().startsWith("4"))
			{
				System.out.println(res.getUrl()+ " is failing with a status code "+res.getStatus() );
			}
		});
		
		
		driver.get("https://www.rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector(".btn.btn-primary")).click();
		
		
		
		
	}

}
