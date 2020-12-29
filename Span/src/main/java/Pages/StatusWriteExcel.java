package Pages;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class StatusWriteExcel {
	
		public static void statusWrite(String status) throws IOException {
			// TODO Auto-generated method stub
			// System.out.println("Welcome to Excel World : " + status);
			String path = "dataprovider\\TestData.xlsx";

			FileInputStream readFile = new FileInputStream(path);

			XSSFWorkbook workbook = new XSSFWorkbook(readFile);
			XSSFSheet sheet = workbook.getSheet("Sheet1");
			int RowCount = sheet.getLastRowNum();
			int colCount = sheet.getRow(0).getLastCellNum();

			for (int i = 1; i <= RowCount; i++) {
				for (int j = 6; j < colCount; j++) {
					// System.out.println("Yet to write in Excel "+status);
					sheet.getRow(i).createCell(j).setCellValue(status);
				}
			}
			FileOutputStream fout = new FileOutputStream(path);

			workbook.write(fout);

			workbook.close();
		}

	}


