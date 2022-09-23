package com.example;

import com.example.compare.students.CompareStudents;
import com.example.compare.universities.CompareUniversities;
import com.example.enums.StudentComparator;
import com.example.enums.UniversityComparator;
import com.example.model.Student;
import com.example.model.University;
import com.example.reader.XlsxReader;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.compare.UtilComparator.getStudentComparator;
import static com.example.compare.UtilComparator.getUniversityComparator;

public class Main
{
    public static void main( String[] args )
    {
        String path = "src/main/resources/universityInfo.xlsx";
        XlsxReader xlsxReader = new XlsxReader(path);


        CompareUniversities compareUniversities = getUniversityComparator(UniversityComparator.BY_ID);
        List<University> universities = xlsxReader.readUniversity().stream().sorted(compareUniversities).collect(Collectors.toList());

        // universities collection serialization (4)
        String jsonUniversities = JsonUtil.UniversitiesToJson(universities);
        System.out.println(jsonUniversities);

        // jsonUniversities deserialization to new collection (5)
        List<University> deserializedUniversitiesCollection = JsonUtil.UniversitiesFromJson(jsonUniversities);

        // check number of elements in collections (before and after deserialization) (6)
        if (universities.size() != deserializedUniversitiesCollection.size()) {
            System.out.println("Number of objects before deserialization (" + universities.size() + ") and after (" +
                    deserializedUniversitiesCollection.size() + ") are different.");
        }

        // Check ser/deser for single objects
        universities.
                stream().
                map(JsonUtil::UniversityToJson).
                map(JsonUtil::UniversityFromJson).
                forEach(System.out::println);

        System.out.println("--------------------------------------------------------");

        CompareStudents compareStudents = getStudentComparator(StudentComparator.By_AVG_EXAM_SCORE_REVERSE);
        List<Student> students = xlsxReader.readStudent().stream().sorted(compareStudents).collect(Collectors.toList());

        // students collection serialization (4)
        String jsonStudents = JsonUtil.StudentsToJson(students);
        System.out.println(jsonStudents);

        // jsonStudents deserialization to new collection (5)
        List<Student> deserializedStudentsCollection = JsonUtil.StudentsFromJson(jsonStudents);

        // check number of elements in collections (before and after deserialization) (6)
        if (students.size() != deserializedStudentsCollection.size()) {
            System.out.println("Number of objects before deserialization (" + students.size() + ") and after (" +
                    deserializedStudentsCollection.size() + ") are different.");
        }

        // Check ser/deser for single objects
        students.
                stream().
                map(JsonUtil::StudentToJson).
                map(JsonUtil::StudentFromJson).
                forEach(System.out::println);
    }
}
