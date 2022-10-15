package com.example.model;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

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
    @Accessors(fluent = true)
    private String fullName;

    @XmlElement(name = "university")
    @SerializedName("universityId")
    @Accessors(fluent = true)
    private String universityId;

    @XmlTransient
    @SerializedName("course_number")
    @Accessors(fluent = true)
    private int currentCourseNumber;

    @XmlElement(name = "avgScore")
    @SerializedName("avg_score")
    @Accessors(fluent = true)
    private float avgExamScore;

}
