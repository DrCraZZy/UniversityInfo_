package com.example.model;

import com.example.enums.StudyProfile;
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
public class Statistic {

    @XmlElement(name = "Profile")
    private StudyProfile profile;

    @XmlElement(name = "avgExamScore")
    private float avgExamScore;

    @XmlTransient
    private int numberOfStudentsInProfile;

    @XmlTransient
    private int numberOfUniversitiesInProfile;

    @XmlTransient
    private String universitiesNames;

}
