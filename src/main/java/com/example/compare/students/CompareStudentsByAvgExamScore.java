package com.example.compare.students;

import com.example.model.Student;

public class CompareStudentsByAvgExamScore implements CompareStrudents {
    @Override
    public int compare(Student student1, Student student2) {
        return Float.compare(student1.getAvgExamScore(), student2.getAvgExamScore());
    }
}
