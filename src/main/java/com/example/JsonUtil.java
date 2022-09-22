package com.example;

import com.example.model.Student;
import com.example.model.University;

import java.util.List;

// https://zetcode.com/java/gson/

public final class JsonUtil {

    public static void StudentToJson(Student student) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

    }

    public static Student StudentFromJson() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return null;
    }

    public static void StudentsToJson(List<Student> students){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

    }

    public List<Student> StudentsFromJson(){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return null;
    }

    public static void UniversityToJson(University university) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

    }

    public static University UniversityFromJson() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return null;
    }

    public static void UniversitiesToJson(List<University> universities){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

    }

    public List<University> UniversitiesFromJson(){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return null;
    }
}
