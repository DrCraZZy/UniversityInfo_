package com.example.comparator;

import com.example.model.University;
import org.apache.commons.lang3.StringUtils;

public class CompareUniversitiesByShortName implements CompareUniversities {
    @Override
    public int compare(University university1, University university2) {
        return StringUtils.compare(university1.getShortName(), university2.getShortName());
    }
}
