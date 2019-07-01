import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Excel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[][] demo = {{"aaaa", "bbbbb"}, {"gggggg", "vvvvvv"}};

        HSSFWorkbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet("Java test");

        for (int rows = 0; rows < demo.length; rows++) {
            Row row = sheet.createRow(rows);

            for (int cols = 0; cols < demo[rows].length; cols++) {
                Cell cell = row.createCell(cols);
                String value = demo[rows][cols];
                cell.setCellValue(value);
            }
        }

        try(FileOutputStream fileOutputStream = new FileOutputStream(new File("Java.xls"))) {

            workbook.write(fileOutputStream);
            fileOutputStream.flush();
            workbook.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
