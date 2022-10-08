package com.example.io;

import com.example.model.Statistic;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class XlsWriter {

    private static final Logger LOGGER = Logger.getLogger(XlsWriter.class.getName());
    private final String filePath;

    public XlsWriter(String filePath) {
        this.filePath = filePath;
    }

    public void writeStatistics(List<Statistic> statistics) {

        try(
                OutputStream outputStream = new FileOutputStream(this.filePath);
                Workbook workbook = new XSSFWorkbook()
        ) {

            Sheet sheet = workbook.createSheet("Statistics");

            Font headerFont = workbook.createFont();
            headerFont.setBold(true);
            headerFont.setFontHeightInPoints((short) 14);
            CellStyle headerStyle = workbook.createCellStyle();
            headerStyle.setFont(headerFont);

            int rowNum = 0;
            Row row = sheet.createRow(rowNum++);
            Cell profileCell = row.createCell(0);
            profileCell.setCellValue("Profile");
            profileCell.setCellStyle(headerStyle);

            Cell avgScoreCell = row.createCell(1);
            avgScoreCell.setCellValue("AVG Score");
            avgScoreCell.setCellStyle(headerStyle);

            Cell numberOfUniversitiesCell = row.createCell(2);
            numberOfUniversitiesCell.setCellValue("Number of Universities");
            numberOfUniversitiesCell.setCellStyle(headerStyle);

            Cell numberOfStudentsCell = row.createCell(3);
            numberOfStudentsCell.setCellValue("Number of Students");
            numberOfStudentsCell.setCellStyle(headerStyle);

            Cell universitiesNames = row.createCell(4);
            universitiesNames.setCellValue("Universities names");
            universitiesNames.setCellStyle(headerStyle);

            if(statistics != null) {
                for (Statistic s : statistics) {
                    row = sheet.createRow(rowNum++);
                    row.createCell(0).setCellValue(s.getProfile().toString());
                    row.createCell(1).setCellValue(s.getAvgExamScore());
                    row.createCell(2).setCellValue(s.getNumberOfUniversitiesInProfile());
                    row.createCell(3).setCellValue(s.getNumberOfStudentsInProfile());
                    row.createCell(4).setCellValue(s.getUniversitiesNames());
                }
            }

            workbook.write(outputStream);
            LOGGER.log(Level.INFO,
                    "Statistic was exported to " + this.filePath + " (" + statistics.size() + " Elements)");

        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "There is a problem by write statistics to the file" + this.filePath, e);
            throw new RuntimeException(e);
        }
    }
}
