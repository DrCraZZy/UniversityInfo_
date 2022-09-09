package com.example;

import com.example.enums.StudyProfile;
import com.example.model.Student;
import com.example.model.University;

public class Main
{
    public static void main( String[] args )
    {
        University university = new University("H", "Hogwords", "Hog", 1997, StudyProfile.MAGIC);
        System.out.println(university);

        Student student = new Student("Harry Potter", "H", 1, 1);
        System.out.println(student);
    }
}
