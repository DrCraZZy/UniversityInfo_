package com.example;

import com.example.io.XlsxReader;
import com.example.io.XlsWriter;
import com.example.model.Statistic;
import com.example.model.Student;
import com.example.model.University;
import com.example.util.CreateStatisticsUtil;

import java.util.List;

public class Main
{
    public static void main( String[] args )
    {
        String pathUniversityInfo = "src/main/resources/universityInfo.xlsx";
        String pathUniversityStatistics = "src/main/resources/universityStatistics.xlsx";
        XlsxReader xlsxReader = new XlsxReader(pathUniversityInfo);

        List<Student> students = xlsxReader.readStudent();
        List<University> universities = xlsxReader.readUniversity();

        CreateStatisticsUtil createStatistic = new CreateStatisticsUtil();
        List<Statistic> statistics = createStatistic.createStatistics(students, universities);

        XlsWriter xw = new XlsWriter(pathUniversityStatistics);

       xw.writeStatistics(statistics);


//        CompareUniversities = getUniversityComparator(UniversityComparator.BY_ID);
//        List<University> universities = xlsxReader.readUniversity().stream().sorted(compareUniversities).collect(Collectors.toList());
//
//        // universities collection serialization (4)
//        String jsonUniversities = JsonUtil.UniversitiesToJson(universities);
//        System.out.println(jsonUniversities);
//
//        // jsonUniversities deserialization to new collection (5)
//        List<University> deserializedUniversitiesCollection = JsonUtil.UniversitiesFromJson(jsonUniversities);
//
//        // check number of elements in collections (before and after deserialization) (6)
//        if (universities.size() != deserializedUniversitiesCollection.size()) {
//            System.out.println("Number of objects before deserialization (" + universities.size() + ") and after (" +
//                    deserializedUniversitiesCollection.size() + ") are different.");
//        }
//
//        // Check ser/deser for single objects
//        universities.
//                stream().
//                map(JsonUtil::UniversityToJson).
//                map(JsonUtil::UniversityFromJson).
//                forEach(System.out::println);
//
//        System.out.println("--------------------------------------------------------");
//
//        CompareStudents compareStudents = getStudentComparator(StudentComparator.By_AVG_EXAM_SCORE_REVERSE);
//        List<Student> students = xlsxReader.readStudent().stream().sorted(compareStudents).collect(Collectors.toList());
//
//        // students collection serialization (4)
//        String jsonStudents = JsonUtil.StudentsToJson(students);
//        System.out.println(jsonStudents);
//
//        // jsonStudents deserialization to new collection (5)
//        List<Student> deserializedStudentsCollection = JsonUtil.StudentsFromJson(jsonStudents);
//
//        // check number of elements in collections (before and after deserialization) (6)
//        if (students.size() != deserializedStudentsCollection.size()) {
//            System.out.println("Number of objects before deserialization (" + students.size() + ") and after (" +
//                    deserializedStudentsCollection.size() + ") are different.");
//        }
//
//        // Check ser/deser for single objects
//        students.
//                stream().
//                map(JsonUtil::StudentToJson).
//                map(JsonUtil::StudentFromJson).
//                forEach(System.out::println);
    }
}
