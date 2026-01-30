package ExcelReader;

import ExcelReader.Model.Product;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelReading1 {
    public static void excelReader(String path, List<Product> products) {
        try (
                BufferedInputStream bis = new BufferedInputStream(new FileInputStream(path));
                Workbook workbook = WorkbookFactory.create(bis)) {
                Sheet sheet = workbook.getSheetAt(0);

                int size = sheet.getPhysicalNumberOfRows();
                for (int i = 1; i < size; i++) {
                    Row r = sheet.getRow(i);
                    Product p = new Product();
                    p.setProductID(r.getCell(0).toString());
                    p.setProductName(r.getCell(1).toString());
                    p.setPrice(r.getCell(2).getNumericCellValue());
                    p.setQuantity((int) r.getCell(3).getNumericCellValue());
                    products.add(p);
                }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getCellValue(Cell cell) {
        return switch (cell.getCellType()) {
            case STRING -> cell.getStringCellValue();
            case _NONE -> null;
            case NUMERIC -> String.valueOf(cell.getNumericCellValue());
            case FORMULA -> null;
            case BLANK -> null;
            case BOOLEAN -> null;
            case ERROR -> null;
        };
    }

    public static void writeExcel(String path) {
        Workbook workbook = new XSSFWorkbook();

    }

    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        excelReader("C:\\Users\\Admin\\Desktop\\Book1.xlsx", products);
        products.forEach(System.out::println);
    }
}
