package com.example.model;

import com.example.enums.StudyProfile;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

@Setter
@Getter
@NoArgsConstructor
@ToString
@XmlAccessorType(XmlAccessType.FIELD)
public class University {

    @XmlElement(name = "universityId")
    @SerializedName("id")
    private String id;

    @XmlElement(name = "universityName")
    @SerializedName("name")
    private String fullName;

    @XmlTransient
    @SerializedName("short_name")
    private String shortName;

    @XmlTransient
    @SerializedName("year_of_foundation")
    private int yearOfFoundation;

    @XmlElement(name = "universityProfile")
    @SerializedName("profile")
    private StudyProfile mainProfile;

}
