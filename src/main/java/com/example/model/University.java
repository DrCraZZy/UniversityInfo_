package com.example.model;

import com.example.enums.StudyProfile;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@Setter
@Getter
@NoArgsConstructor
@ToString
@XmlAccessorType(XmlAccessType.FIELD)
public class University {

    @SerializedName("id")
    private String id;

    @SerializedName("name")
    private String fullName;

    @SerializedName("short_name")
    private String shortName;

    @SerializedName("year_of_foundation")
    private int yearOfFoundation;

    @SerializedName("profile")
    private StudyProfile mainProfile;

}
