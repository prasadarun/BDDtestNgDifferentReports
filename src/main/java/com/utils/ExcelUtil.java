package com.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	
	 private static final Logger logger = LogManager.getLogger(ExcelUtil.class);
	
	private String filePath;
    private Workbook workbook;
    private Sheet sheet;

    public ExcelUtil(String filePath, String sheetName) throws IOException {
        this.filePath = filePath;
        logger.debug("Initializing ExcelUtil with file: {}", filePath);
        FileInputStream fileInputStream = new FileInputStream(filePath);
        workbook = new XSSFWorkbook(fileInputStream);
        sheet = workbook.getSheet(sheetName);
        logger.debug("Created new sheet: {}", sheetName);
        if (sheet == null) {
            sheet = (Sheet) workbook.createSheet(sheetName);
        }
        fileInputStream.close();
    }

    public void writeStringToCell(String value) throws IOException {
    	 logger.debug("Writing value '{}' to Excel file", value);
         try {
             int rowCount = sheet.getPhysicalNumberOfRows();
             Row row = sheet.createRow(rowCount);
             Cell cell = row.createCell(0);
             cell.setCellValue(value);
             try (FileOutputStream fileOutputStream = new FileOutputStream(filePath)) {
                 workbook.write(fileOutputStream);
             }
             logger.debug("Written value '{}' to row {}", value, rowCount);
         } catch (IOException e) {
             logger.error("Error writing to Excel file: ", e);
             throw e;
         }
    }

    public void closeWorkbook() throws IOException {
    	 if (workbook != null) {
             try {
                 workbook.close();
                 logger.debug("Workbook closed");
             } catch (IOException e) {
                 logger.error("Error closing workbook: ", e);
                 throw e;
             }
    	 }
    }
}
