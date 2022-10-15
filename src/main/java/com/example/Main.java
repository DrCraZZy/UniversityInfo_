package com.example;

import com.example.io.XlsWriter;
import com.example.io.XlsxReader;
import com.example.model.Statistic;
import com.example.model.Student;
import com.example.model.University;
import com.example.util.CreateStatisticsUtil;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Main
{
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
    public static void main( String[] args )
    {
        try {LogManager.getLogManager().readConfiguration(
                    Main.class.getResourceAsStream("/logging.properties"));
        } catch (IOException e) {
            System.err.println("Problem with logger configuration: " + e);
        }

        LOGGER.log(Level.INFO, "Program was started");
        String pathUniversityInfo = "src/main/resources/universityInfo.xlsx";
        String pathUniversityStatistics = "src/main/resources/universityStatistics.xlsx";
        XlsxReader xlsxReader = new XlsxReader(pathUniversityInfo);

        List<Student> students = xlsxReader.readStudent();
        List<University> universities = xlsxReader.readUniversity();

        CreateStatisticsUtil createStatistic = new CreateStatisticsUtil();
        List<Statistic> statistics = createStatistic.createStatistics(students, universities);

        XlsWriter xw = new XlsWriter(pathUniversityStatistics);

        xw.writeStatistics(statistics);
        LOGGER.log(Level.INFO, "Program was finished");

    }
}
