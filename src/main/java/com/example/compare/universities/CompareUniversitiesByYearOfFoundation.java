package com.example.compare.universities;

import com.example.model.University;

public class CompareUniversitiesByYearOfFoundation implements CompareUniversities {
    @Override
    public int compare(University university1, University university2) {
        return Integer.compare(university1.getYearOfFoundation(), university2.getYearOfFoundation());
    }
}
