package com.example.model;

import com.example.enums.StudyProfile;
import com.google.gson.annotations.SerializedName;

public class Statistic {
    @SerializedName("Profil")
    private StudyProfile profile;
    @SerializedName("avgExamScore")
    private float avgExamScore;
    @SerializedName("numberOfStudents")
    private int numberOfStudentsInProfile;
    @SerializedName("numberOfUniversities")
    private int numberOfUniversitiesInProfile;

    @SerializedName("universitiesNames")
    private String universitiesNames;

    public Statistic() {}

    public Statistic(StudyProfile profile, float avgExamScore, int numberOfStudentsInProfile, int numberOfUniversitiesInProfile, String universitiesNames) {
        this.profile = profile;
        this.avgExamScore = avgExamScore;
        this.numberOfStudentsInProfile = numberOfStudentsInProfile;
        this.numberOfUniversitiesInProfile = numberOfUniversitiesInProfile;
        this.universitiesNames = universitiesNames;
    }

    public StudyProfile getProfile() {
        return profile;
    }

    public void setProfile(StudyProfile profile) {
        this.profile = profile;
    }

    public float getAvgExamScore() {
        return avgExamScore;
    }

    public void setAvgExamScore(float avgExamScore) {
        this.avgExamScore = avgExamScore;
    }

    public int getNumberOfStudentsInProfile() {
        return numberOfStudentsInProfile;
    }

    public void setNumberOfStudentsInProfile(int numberOfStudentsInProfile) {
        this.numberOfStudentsInProfile = numberOfStudentsInProfile;
    }

    public int getNumberOfUniversitiesInProfile() {
        return numberOfUniversitiesInProfile;
    }

    public void setNumberOfUniversitiesInProfile(int numberOfUniversitiesInProfile) {
        this.numberOfUniversitiesInProfile = numberOfUniversitiesInProfile;
    }

    public void setUniversitiesNames(String universitiesNames) {
        this.universitiesNames = universitiesNames;
    }

    public String getUniversitiesNames() {
        return universitiesNames;
    }

    @Override
    public String toString() {
        return "Statistic{" +
                "profile=" + profile +
                ", avgExamScore=" + avgExamScore +
                ", numberOfStudentsInProfile=" + numberOfStudentsInProfile +
                ", numberOfUniversitiesInProfile=" + numberOfUniversitiesInProfile +
                ", universitiesNames='" + universitiesNames + '\'' +
                '}';
    }
}
