package com.seavus.qa.seleniumdemoqa.framework.service;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Lazy
@Service
public class DataService {

    public Object[][] readDataFromExcelFile(String filePath) throws IOException {
        List<List<String>> matrix = new ArrayList<>();

        File excelFile = new File(filePath);
        FileInputStream fis = new FileInputStream(excelFile);

        // we create an XSSF Workbook object for our XLSX Excel File
        try (XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

//            // When you work with more sheets
//            Iterator<Sheet> sheetIterator = workbook.sheetIterator();
//            while(sheetIterator.hasNext()) {

            XSSFSheet sheet = workbook.getSheetAt(0);

            // we iterate on rows
            Iterator<Row> rowIt = sheet.rowIterator();

            // Skip header
            if (rowIt.hasNext()) {
                rowIt.next();
            }

            while (rowIt.hasNext()) {
                Row row = rowIt.next();
                // iterate on cells for the current row
                Iterator<Cell> cellIterator = row.cellIterator();
                List<String> rowData = new ArrayList<>();
                // Iterate cells
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    if (!cell.toString().isEmpty()) {
                        rowData.add(cell.toString().replace("-", ""));
                    }
                }
                if (rowData.size() > 1) {
                    matrix.add(rowData);
                }
            }
        }

        fis.close();

        Object[][] result = new Object[matrix.size()][matrix.get(0).size()];
        int i = 0;
        for (List<String> row : matrix) {
            result[i++] = row.toArray();
        }

        return result;
    }
}
