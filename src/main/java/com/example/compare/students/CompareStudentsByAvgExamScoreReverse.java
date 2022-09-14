package com.example.compare.students;

import com.example.model.Student;

public class CompareStudentsByAvgExamScoreReverse implements CompareStudents {

    @Override
    public int compare(Student student1, Student student2) {
        return Float.compare(student2.getAvgExamScore(), student1.getAvgExamScore());
    }
}
