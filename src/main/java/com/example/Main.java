package com.example;

import com.example.comparator.CompareStudents;
import com.example.comparator.CompareUniversities;
import com.example.enums.StudentComparator;
import com.example.enums.UniversityComparator;
import com.example.io.JsonWriter;
import com.example.io.XlsWriter;
import com.example.io.XlsxReader;
import com.example.io.XmlWriter;
import com.example.model.FullInfo;
import com.example.model.Statistic;
import com.example.model.Student;
import com.example.model.University;
import com.example.util.ComparatorUtil;
import com.example.util.CreateStatisticsUtil;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Main
{
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
    public static void main( String[] args )
    {
        try {
            LogManager.getLogManager().readConfiguration(Main.class.getResourceAsStream("/logging.properties"));
        } catch (IOException e) {
            System.err.println("Problem with logger configuration: " + e);
        }

        LOGGER.log(Level.INFO, "Program was started");

        List<University> universities = new XlsxReader("src/main/resources/universityInfo.xlsx").readUniversity();
        CompareUniversities compareUniversities = ComparatorUtil.getUniversityComparator(UniversityComparator.BY_YEAR_OF_FOUNDATION);
        universities.sort(compareUniversities);

        List<Student> students = new XlsxReader("src/main/resources/universityInfo.xlsx").readStudent();
        CompareStudents studentComparator =  ComparatorUtil.getStudentComparator(StudentComparator.BY_AVG_EXAM_SCORE);
        students.sort(studentComparator);

        List<Statistic> statisticsList = new CreateStatisticsUtil().createStatistics(students, universities);
        new XlsWriter("statistics.xlsx").writeStatistics(statisticsList);

        FullInfo fullInfo = new FullInfo()
                .setStudentList(students)
                .setUniversityList(universities)
                .setStatisticList(statisticsList)
                .setProcessDate(new Date());

        XmlWriter.generateXml(fullInfo);
        JsonWriter.writeJson(fullInfo);

        LOGGER.log(Level.INFO, "Program was finished");

    }
}
