package com.example.util;

import com.example.enums.StudyProfile;
import com.example.model.Statistic;
import com.example.model.Student;
import com.example.model.University;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class CreateStatisticsUtil {

    private static final Logger LOGGER = Logger.getLogger(CreateStatisticsUtil.class.getName());

    public CreateStatisticsUtil(){}

    public List<Statistic> createStatistics(List<Student> students, List<University> universities) {
        LOGGER.log(Level.INFO, "Creating statistic...");
        List<Statistic> statistics = new ArrayList<>();

        Set<StudyProfile> profiles = universities.stream().map(University::getMainProfile).collect(Collectors.toSet());

        profiles.forEach(p -> {
            Statistic statistic = new Statistic();

            // set profile
            statistics.add(statistic);
            statistic.setProfile(p);

            // set number of universities
            List<String> universityIds = universities.stream().
                    filter(u -> u.getMainProfile().equals(p)).
                    map(University::getId).
                    collect(Collectors.toList());

            statistic.setNumberOfUniversitiesInProfile(universityIds.size());

            // set universities names
            List<String> universityNames = universities.stream().
                    filter(u -> u.getMainProfile().equals(p)).
                    map(University::getShortName).
                    collect(Collectors.toList());

            statistic.setUniversitiesNames(String.join(";", universityNames));

            // set number ouf students
            List<Student> studentsWithProfile = students.stream()
                    .filter(s -> universityIds.contains(s.getUniversityId()))
                    .collect(Collectors.toList());

            statistic.setNumberOfStudentsInProfile(studentsWithProfile.size());

            // set avg score
            OptionalDouble avgExamScore = studentsWithProfile.stream()
                    .mapToDouble(Student::getAvgExamScore)
                    .average();
            avgExamScore
                    .ifPresent(
                            score -> statistic.setAvgExamScore(
                                    (float) new BigDecimal(score)
                                    .setScale(2, RoundingMode.HALF_UP)
                                    .doubleValue())
                    );
        });

        LOGGER.log(Level.INFO, "Statistic was created.");

        return statistics;
    }
}
