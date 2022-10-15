package com.example.model;

import com.example.enums.StudyProfile;
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
public class Statistic {

    @XmlElement(name = "universityProfile")
    @Accessors(fluent = true)
    private StudyProfile profile;

    @XmlElement(name = "avgScore")
    @Accessors(fluent = true)
    private float avgExamScore;

    @XmlTransient
    @Accessors(fluent = true)
    private int numberOfStudentsInProfile;

    @XmlTransient
    @Accessors(fluent = true)
    private int numberOfUniversitiesInProfile;

    @XmlTransient
    @Accessors(fluent = true)
    private String universitiesNames;

}
