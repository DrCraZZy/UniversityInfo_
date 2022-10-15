package com.example.model;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

@Getter
@Setter
@NoArgsConstructor
@ToString
@XmlAccessorType(XmlAccessType.FIELD)
public class Student {

    @XmlElement(name = "studentName")
    @SerializedName("name")
    private String fullName;

    @XmlElement(name = "university")
    @SerializedName("universityId")
    private String universityId;

    @XmlTransient
    @SerializedName("course_number")
    private int currentCourseNumber;

    @XmlElement(name = "avgScore")
    @SerializedName("avg_score")
    private float avgExamScore;

}
