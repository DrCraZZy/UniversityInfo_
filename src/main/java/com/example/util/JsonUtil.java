package com.example.util;

import com.google.gson.GsonBuilder;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public final class JsonUtil {

    public static String writeListToJson(List<?> list) {
        return new GsonBuilder().setPrettyPrinting().create().toJson(list);
    }


}
