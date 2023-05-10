package qaclickacademy.ExcelDriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class dataDriven165 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		
		
		
		
		
		
	}
	
	
	
	
	//Method - here just place the name of a TC (variable testcaseName)
	public ArrayList<String> getDataFromExcel(String testcaseName) throws IOException
	{
		
		ArrayList<String> al = new ArrayList<String>();
		//A) We have to create an object (fis) that has an access to this excel file
		FileInputStream fis = new FileInputStream("C:\\Users\\joko2909\\Desktop\\Prntscr\\DemoDataRahul.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		
		
		//B) Count all sheets and access to a specific one
		int sheetsCount = workbook.getNumberOfSheets();
		for (int i=0; i<sheetsCount; i++)
		{
			if(workbook.getSheetName(i).equalsIgnoreCase("TestDataSheet"))
			{
				
				XSSFSheet sheetWanted = workbook.getSheetAt(i);
				
				//Identify TestCases column by scanning the entire first row
				Iterator<Row> rows = sheetWanted.rowIterator();
				Row firstRow = rows.next(); //This is the first row
				
				//Now scan all the columns in this first row
				Iterator<Cell> cell = firstRow.cellIterator();
				
				int k=0;
				int column = 0;
				while(cell.hasNext())
				{
					
					Cell cellValue = cell.next();
						if( cellValue.getStringCellValue().equalsIgnoreCase("TestCases"))
						{
							//Now, here we have reached the desired column
							column=k;
						}
					k++;	
				}
				System.out.println("In this column index is our desired TestCases - " +column);
				
				//Now, we have identified the TestCases column, therefore scan this column to get to the "Purchase" TC
				while (rows.hasNext())
				{
					
					Row r = rows.next();
					if(r.getCell(column).getStringCellValue().equalsIgnoreCase(testcaseName))
					{
						//Now we have grabbed this TC Purchase, take all the cells for the row in which this TC Purchase is located
						Iterator<Cell> cv = r.cellIterator();
						while(cv.hasNext())
						{
							
							Cell c =cv.next();
							if(c.getCellType()==CellType.STRING)
								{
								
								al.add(c.getStringCellValue()); //Adding all the data from this TC to this ArrayList if the data is String
								
								} 
							else
							{
								String numToString = NumberToTextConverter.toText(c.getNumericCellValue()); //Parsing this integer into a String
								al.add(numToString);
							}
						}
					}
					
				}
				
				
			}
			
				
		}
		return al;
	}

}
