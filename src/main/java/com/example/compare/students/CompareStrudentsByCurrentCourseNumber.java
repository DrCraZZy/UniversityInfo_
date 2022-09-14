package com.example.compare.students;

import com.example.model.Student;

public class CompareStrudentsByCurrentCourseNumber implements CompareStudents {

    @Override
    public int compare(Student student1, Student student2) {
        return Integer.compare(student1.getCurrentCourseNumber(), student2.getCurrentCourseNumber());
    }
}
