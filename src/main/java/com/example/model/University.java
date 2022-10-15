package com.example.model;

import com.example.enums.StudyProfile;
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
public class University {

    @XmlElement(name = "universityId")
    @SerializedName("id")
    @Accessors(fluent = true)
    private String id;

    @XmlElement(name = "universityName")
    @SerializedName("name")
    @Accessors(fluent = true)
    private String fullName;

    @XmlTransient
    @SerializedName("short_name")
    @Accessors(fluent = true)
    private String shortName;

    @XmlTransient
    @SerializedName("year_of_foundation")
    @Accessors(fluent = true)
    private int yearOfFoundation;

    @XmlElement(name = "universityProfile")
    @SerializedName("profile")
    @Accessors(fluent = true)
    private StudyProfile mainProfile;

}
