package com.example.compare.universities;

import com.example.model.University;
import org.apache.commons.lang3.StringUtils;

public class CompareUniversitiesById implements CompareUniversities {

    @Override
    public int compare(University university1, University university2) {
        return StringUtils.compare(university1.getId(), university2.getId());
    }
}
