import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

public class CdpCommandsTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		System.setProperty("webdriver.chrome.driver", "C:\\JK\\chromedriver_win32\\chromedriver.exe");
		//webdriver.chrome.driver is a key value, a property
		
		//For the Chrome Dev Tools we must use ChromeDriver NOT WebDriver
		ChromeDriver driver = new ChromeDriver();
		
		DevTools devToolsJK = driver.getDevTools();
		devToolsJK.createSession();
		
		driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", null);
		
		
	}

}
