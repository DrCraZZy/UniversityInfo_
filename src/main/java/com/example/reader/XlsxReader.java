package com.example.reader;

import com.example.enums.StudyProfile;
import com.example.model.University;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
* class for reading xlsx files and extract information about Universities and Students
 */
public class XlsxReader {

    private String filePath;

    public XlsxReader(String filePath) {
        this.filePath = filePath;
    }

    // Read xlsx - File and returned a list of Universities
    public List<University> readUniversity() {
        List<University> universities = new ArrayList<>();

        try(InputStream inputStream = new FileInputStream(this.filePath)) {
            Workbook wb = WorkbookFactory.create(inputStream);
            Sheet sheet = wb.getSheet("Университеты");

            Iterator<Row> rowIter = sheet.iterator();
            rowIter.next();  // ignore headline

            while(rowIter.hasNext()) {
                Row row = rowIter.next();
                University university = new University();

                university.setId(row.getCell(0).getStringCellValue());
                university.setFullName(row.getCell(1).getStringCellValue());
                university.setShortName(row.getCell(2).getStringCellValue());
                university.setYearOfFoundation((int) row.getCell(3).getNumericCellValue());
                university.setMainProfile(StudyProfile.valueOf(row.getCell(4).getStringCellValue()));

                universities.add(university);
            }
        } catch (IOException e) {
            System.err.println("Problem with file reading.");
            throw new RuntimeException(e);
        }

        return universities;
    }
}
