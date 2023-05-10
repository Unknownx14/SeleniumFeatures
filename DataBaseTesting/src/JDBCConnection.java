import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class JDBCConnection {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		//Connect our DB
		String host="localhost";
		String port = "3306";
		Connection conn = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/qadb", "root", "demo01");
		
		Statement state = conn.createStatement();
		ResultSet resSet = state.executeQuery("select * from Employeeinfo where name='Jam'");
		
		while( resSet.next())
		{
		
		System.out.println( resSet.getString("location"));
		System.out.println( resSet.getInt("age"));
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\JK\\chromedriver_win32\\chromedriver.exe");
		//webdriver.chrome.driver is a key value, a property
		WebDriver driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com/");
		
		
		driver.findElement(By.id("username")).sendKeys(resSet.getString("location"));
		driver.findElement(By.id("password")).sendKeys(resSet.getString("name")); 
		
		}
		
	}

}
