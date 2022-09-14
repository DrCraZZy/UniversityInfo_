package com.example.compare;

import com.example.compare.students.*;
import com.example.compare.universities.*;
import com.example.enums.StudentComparator;
import com.example.enums.UniversityComparator;

public class UtilComparator {
    public static CompareStudents getStudentComparator(StudentComparator studentComparator){
        CompareStudents compareStudents;

        switch (studentComparator) {
            case BY_NAME:
                compareStudents = new CompareStudentsByName();
                break;
            case BY_UNIVERSITY_ID:
                compareStudents = new CompareStudentsByUniversityID();
                break;
            case BY_AVG_EXAM_SCORE:
                compareStudents = new CompareStudentsByAvgExamScore();
                break;
            case By_AVG_EXAM_SCORE_REVERSE:
                compareStudents = new CompareStudentsByAvgExamScoreReverse();
                break;
            case BY_CURRENT_COURSE_NUMBER:
                compareStudents = new CompareStudentsByCurrentCourseNumber();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + studentComparator);
        }

        return compareStudents;
    }

    public static CompareUniversities getUniversityComparator(UniversityComparator universityComparator){
        CompareUniversities compareUniversities;

        switch (universityComparator) {
            case BY_ID:
                compareUniversities = new CompareUniversitiesById();
                break;
            case BY_FULL_NAME:
                compareUniversities = new CompareUniversitiesByName();
                break;
            case BY_MAIN_PROFILE:
                compareUniversities = new CompareUniversitiesByMainProfile();
                break;
            case BY_SHORT_NAME:
                compareUniversities = new CompareUniversitiesByShortName();
                break;
            case BY_YEAR_OF_FOUNDATION:
                compareUniversities = new CompareUniversitiesByYearOfFoundation();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + universityComparator);
        }

        return compareUniversities;
    }
}
