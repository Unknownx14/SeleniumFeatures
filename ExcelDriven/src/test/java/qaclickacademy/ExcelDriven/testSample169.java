package qaclickacademy.ExcelDriven;

import java.io.IOException;
import java.util.ArrayList;

public class testSample169 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		
		dataDriven165 dd = new dataDriven165();
		ArrayList allData = dd.getDataFromExcel("Add Profile"); //Here it is only ArrayList (without <String>) because it's not going to be always strings
		System.out.println(allData.get(0)); //Print the name of this TC
		System.out.println(allData.get(1));
		System.out.println(allData.get(2));
		System.out.println(allData.get(3));
		
		
		//How to use this in the Selenium
		//driver.findElement(By.xpath("some x path given")).sendKeys(allData.get(1)); //Like this we are now sending this allData.get(1) in our automation TC
		
		
		
	}

}
