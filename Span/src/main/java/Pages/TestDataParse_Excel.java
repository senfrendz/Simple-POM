package Pages;
	import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class TestDataParse_Excel {
	
	static DataFormatter formatter = new DataFormatter();


		@SuppressWarnings("incomplete-switch")
		public static ArrayList<Object[]> readFromExcel() throws IOException {
			ArrayList<Object[]> dataStore= new ArrayList<Object[]>();
			
			String path = "dataprovider\\TestData.xlsx";
			
			FileInputStream readFile = new FileInputStream(path);
			
			@SuppressWarnings("resource")
			XSSFWorkbook workbook = new XSSFWorkbook(readFile); 
			XSSFSheet sheet = workbook.getSheet("Sheet1");
			
			int RowCount = sheet.getLastRowNum();
			@SuppressWarnings("unused")
			int colCount = sheet.getRow(0).getLastCellNum();
			
			for(int row =1;row<=RowCount;row++) {
				@SuppressWarnings("unused")
				XSSFRow rows = sheet.getRow(row);
			//	for(int col=0; col<colCount;col++) {		
			//	XSSFCell cell = rows.getCell(col);	
					
					String email = sheet.getRow(row).getCell(0).getStringCellValue();
					String firstName = sheet.getRow(row).getCell(1).getStringCellValue();
					String lastName = sheet.getRow(row).getCell(2).getStringCellValue();
					String emailAddr = sheet.getRow(row).getCell(3).getStringCellValue();

					String phone =  formatter.formatCellValue(sheet.getRow(row).getCell(4));
					String countryName = sheet.getRow(row).getCell(5).getStringCellValue();
				
					/*
					 * System.out.println(email); System.out.println(firstName);
					 * System.out.println(lastName); System.out.println(emailAddr);
					 * System.out.println(phone); System.out.println(countryName);
					 */
					Object excelValues[] = {email,firstName,lastName,emailAddr,phone,countryName};
					dataStore.add(excelValues);
					
			}
			return dataStore;
		}

	
}
