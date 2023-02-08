package techproed.utilities;

import org.apache.poi.ss.usermodel.*;
import org.testng.Assert;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelUtils {
    private Workbook workBook;
    private Sheet workSheet;
    private String path;

    public ExcelUtils(String path, String sheetName) {//Constructor : Excel path i ve sayfaya ulasmak icn kullinir
        this.path = path;
        try {
            // Opening the Excel file
            FileInputStream fileInputStream = new FileInputStream(path);
            // accessing the workbook
            workBook = WorkbookFactory.create(fileInputStream);
            //getting the worksheet
            workSheet = workBook.getSheet(sheetName);
            //asserting if sheet has data or not
            Assert.assertNotNull(workSheet, "Worksheet: \"" + sheetName + "\" was not found\n");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //This will get the list of the data in the excel file
    //This is a list of map of string. This takes the data as string and will return the data as a Map of String
//Exceldeki verileri List olarak almamızı saglar.
//Exceldaki verileri Java test sınıfında kullanacagız.
    public List<Map<String, String>> getDataList() { //["username", "password"]
        // getting all columns
        List<String> columns = getColumnsNames();
        // method will return this
        List<Map<String, String>> data = new ArrayList<>();
        for (int i = 1; i < rowCount(); i++) {
            // get each row
            Row row = workSheet.getRow(i);
            // creating map of the row using the column and value
            // key=column, value=cell
            Map<String, String> rowMap = new HashMap<String, String>();
            for (Cell cell : row) {
                int columnIndex = cell.getColumnIndex();
                rowMap.put(columns.get(columnIndex), cell.toString());
            }
            data.add(rowMap);
        }
        return data;
    }

    //===============Exceldeki toplam sutun sayisini return eder.=================
    public int columnCount() {
        //getting how many numbers in row 1
        return workSheet.getRow(0).getLastCellNum();
    }

    //===============Exceldeki satır sayisini return eder.====================
    public int rowCount() {
        return workSheet.getLastRowNum() + 1;
    }//adding 1 to get the actual count

    //==============Bu method satir ve sutun sayilari girildiginde o hucredeki veriyi return eder.=========
    public String getCellData(int rowNum, int colNum) {
        Cell cell;
        try {
            cell = workSheet.getRow(rowNum).getCell(colNum);
            String cellData = cell.toString();
            return cellData;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //============Exceldeki datalari baslık dahil iki boyutlu array olarak return eder.===
    public String[][] getDataArray() {
        String[][] data = new String[rowCount()][columnCount()];
        for (int i = 0; i < rowCount(); i++) {
            for (int j = 0; j < columnCount(); j++) {
                String value = getCellData(i, j);
                data[i][j] = value;
            }
        }
        return data;
    }

    //==============Bu method sutun isimlerini verir.==================//
    public List<String> getColumnsNames() {
        List<String> columns = new ArrayList<>();
        for (Cell cell : workSheet.getRow(0)) {
            columns.add(cell.toString());
        }
        return columns;
    }

    //=========Deger,Sutun ve satir sayisi girildiginde ,O satır ve sutuna girilen veriyi ekler.Index kabul eder.===============//
    public void setCellData(String value, int rowNum, int colNum) {
        Cell cell;
        Row row;
        try {
            row = workSheet.getRow(rowNum);
            cell = row.getCell(colNum);
            if (cell == null) {//if there is no value, create a cell.
                cell = row.createCell(colNum);
                cell.setCellValue(value);
            } else {
                cell.setCellValue(value);
            }
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            workBook.write(fileOutputStream);
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//Bu method ustteki methodun yardımcısıdır.Ustteki methodla birlikte calısır.Overload eder.Sadece parametreleri farklıdır.
    public void setCellData(String value, String columnName, int row) {
        int column = getColumnsNames().indexOf(columnName);
        setCellData(value, row, column);
    }

//Baslıksız tum exceldeki verileri iki boyutlu arraye koyarak alir.
    public String[][] getDataArrayWithoutFirstRow() {
        String[][] data = new String[rowCount() - 1][columnCount()];
        for (int i = 1; i < rowCount(); i++) {
            for (int j = 0; j < columnCount(); j++) {
                String value = getCellData(i, j);
                data[i - 1][j] = value;
            }
        }
        return data;
    }

}
