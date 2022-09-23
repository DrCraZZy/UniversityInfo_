package com.example.model;

import com.google.gson.annotations.SerializedName;

public class Student {
    @SerializedName("name")
    private String fullName;

    @SerializedName("university")
    private String universityId;

    @SerializedName("course_number")
    private int currentCourseNumber;

    @SerializedName("avg_score")
    private float avgExamScore;

    public Student() {
    }

    public Student(String fullName, String universityId, int currentCourseNumber, float avgExamScore) {
        this.fullName = fullName;
        this.universityId = universityId;
        this.currentCourseNumber = currentCourseNumber;
        this.avgExamScore = avgExamScore;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUniversityId() {
        return universityId;
    }

    public void setUniversityId(String universityId) {
        this.universityId = universityId;
    }

    public int getCurrentCourseNumber() {
        return currentCourseNumber;
    }

    public void setCurrentCourseNumber(int currentCourseNumber) {
        this.currentCourseNumber = currentCourseNumber;
    }

    public float getAvgExamScore() {
        return avgExamScore;
    }

    public void setAvgExamScore(float avgExamScore) {
        this.avgExamScore = avgExamScore;
    }

    @Override
    public String toString() {
        return "fullName: " + fullName +
                ", universityId: " + universityId +
                ", currentCourseNumber: " + currentCourseNumber +
                ", avgExamScore: " + avgExamScore;
    }
}
