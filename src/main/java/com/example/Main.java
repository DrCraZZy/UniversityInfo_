package com.example;

import com.example.compare.students.CompareStudents;
import com.example.compare.universities.CompareUniversities;
import com.example.enums.StudentComparator;
import com.example.enums.UniversityComparator;
import com.example.model.Student;
import com.example.model.University;
import com.example.reader.XlsxReader;

import java.util.List;

import static com.example.compare.UtilComparator.getStudentComparator;
import static com.example.compare.UtilComparator.getUniversityComparator;

public class Main
{
    public static void main( String[] args )
    {
        String path = "src/main/resources/universityInfo.xlsx";

        XlsxReader xlsxReader = new XlsxReader(path);
        List<University> universities = xlsxReader.readUniversity();

        CompareUniversities compareUniversities = getUniversityComparator(UniversityComparator.BY_ID);
        universities.stream().sorted(compareUniversities).forEach(System.out::println);

        System.out.println("--------------------------------------------------------");

        List<Student> students = xlsxReader.readStudent();
        CompareStudents compareStudents = getStudentComparator(StudentComparator.By_AVG_EXAM_SCORE_REVERSE);
        students.stream().sorted(compareStudents).forEach(System.out::println);
    }
}
