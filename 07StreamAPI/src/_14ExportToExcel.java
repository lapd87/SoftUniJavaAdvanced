import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 17.6.2018 г.
 * Time: 12:36 ч.
 */
public class _14ExportToExcel {
    public static void main(String[] args) {

        String resourcePath = "C:\\VBprojects\\JavaAdvanced05.2018\\" +
                "07StreamAPI\\recources\\";

        String inputPath = resourcePath + "07. StudentData.txt";
        String ouputPath = resourcePath + "07. StudentData.xlsx";

        try (BufferedReader bufferedReader =
                     new BufferedReader(new FileReader(inputPath));
             FileOutputStream fileOutputStream = new FileOutputStream(ouputPath)) {

            XSSFWorkbook workbook = new XSSFWorkbook();

            XSSFSheet sheet = workbook.createSheet("Student data");

            int rowNum = 0;
            String rowData;
            while (null != (rowData = bufferedReader.readLine())) {

                Row row = sheet.createRow(rowNum++);

                String[] rowCellsData = rowData.split("\\t");

                int cellNum = 0;
                for (String cellData : rowCellsData) {
                    Cell cell = row.createCell(cellNum++);

                    cell.setCellValue(cellData);
                }
            }

            workbook.write(fileOutputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}