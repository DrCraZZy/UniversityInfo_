package com.example.model;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@Getter
@Setter
@NoArgsConstructor
@ToString
@XmlAccessorType(XmlAccessType.FIELD)
public class Student {

    @XmlElement(name = "name")
    @SerializedName("name")
    private String fullName;

    @XmlElement(name = "university")
    @SerializedName("university")
    private String universityId;

    @XmlElement(name = "course_number")
    @SerializedName("course_number")
    private int currentCourseNumber;

    @XmlElement(name = "avg_score")
    @SerializedName("avg_score")
    private float avgExamScore;

}
