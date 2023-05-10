package Academy.APIExcel2712;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDriven {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		FileInputStream fis = new FileInputStream("C:\\Users\\joko2909\\Desktop\\Prntscr\\DemoDataJK.xlsx");
		
		XSSFWorkbook workBook = new XSSFWorkbook(fis);
		
		int numberOfSheets = workBook.getNumberOfSheets();
		String wantedSheetName = "testdata";
		
		for(int i=0; i<numberOfSheets; i++)
		{
			if(workBook.getSheetName(i).equalsIgnoreCase(wantedSheetName))
			{
				XSSFSheet sheet = workBook.getSheetAt(i);
				break;
			}
			
		}
		
	}

}
