import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import java.net.URI;
import java.util.function.Predicate;

public class NetworkSpeed {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\JK\\chromedriver_win32\\chromedriver.exe");
		//webdriver.chrome.driver is a key value, a property
		
		//For the Chrome Dev Tools we must use ChromeDriver NOT WebDriver
		ChromeDriver driver = new ChromeDriver();
		
		//This is predicate concept
		Predicate<URI> uriPredicate = uri -> uri.getHost().contains("httpbin.org");
		
		((HasAuthentication)driver).register(uriPredicate, UsernameAndPassword.of("foo", "bar"));
		driver.get("http://httpbin.org/basic-auth/foo/bar");
		
		
	}

}
