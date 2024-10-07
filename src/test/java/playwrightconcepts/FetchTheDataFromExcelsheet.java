package playwrightconcepts;

import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FetchTheDataFromExcelsheet {

	public static void main(String[] args) {
		try {
			FileInputStream file = new FileInputStream("./src/test/resources/DataFile.xlsx");

			// Create Workbook instance holding reference to .xlsx file
			XSSFWorkbook wb = new XSSFWorkbook(file);

			XSSFSheet ws = wb.getSheetAt(0);

			Iterator<Row> rowIterator = ws.iterator();
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();

				Iterator<Cell> cellIterator = row.cellIterator();

				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					// Check the cell type and format accordingly
					switch (cell.getCellType()) {

					case NUMERIC:
						System.out.print(cell.getNumericCellValue());
						break;
					case STRING:
						System.out.print(cell.getStringCellValue());
						break;
					}
					System.out.print("|");
				}
			}

			file.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
