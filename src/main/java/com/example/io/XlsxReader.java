package com.example.io;

import com.example.enums.StudyProfile;
import com.example.model.Student;
import com.example.model.University;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
* class for reading xlsx files and extract information about Universities and Students
 */
public class XlsxReader {

    private static final Logger LOGGER = Logger.getLogger(XlsxReader.class.getName());

    private final String filePath;

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

            LOGGER.log(Level.INFO, universities.size() + " universities were imported from " + this.filePath);

        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "It is not possible to read " + this.filePath, e);
            throw new RuntimeException(e);
        }

        return universities;
    }

    // Read xlsx - File and returned a list of Students
    public List<Student> readStudent() {
        List<Student> students = new ArrayList<>();

        try(InputStream inputStream = new FileInputStream(this.filePath)) {
            Workbook wb = WorkbookFactory.create(inputStream);
            Sheet sheet = wb.getSheet("Студенты");

            Iterator<Row> rowIter = sheet.iterator();
            rowIter.next();  // ignore headline

            while(rowIter.hasNext()) {
                Row row = rowIter.next();
                Student student = new Student();

                student.setUniversityId(row.getCell(0).getStringCellValue());
                student.setFullName(row.getCell(1).getStringCellValue());
                student.setCurrentCourseNumber((int) row.getCell(2).getNumericCellValue());
                student.setAvgExamScore((float) row.getCell(3).getNumericCellValue());

                students.add(student);
            }

            LOGGER.log(Level.INFO, students.size() + " students were imported from " + this.filePath);

        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "It is not possible to read " + this.filePath, e);
            throw new RuntimeException(e);
        }

        return students;
    }
}
