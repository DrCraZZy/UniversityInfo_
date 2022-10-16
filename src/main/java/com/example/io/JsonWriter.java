package com.example.io;

import com.example.model.FullInfo;
import com.example.util.JsonUtil;
import lombok.NoArgsConstructor;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

@NoArgsConstructor
public class JsonWriter {
    private static final Logger logger = Logger.getLogger(JsonWriter.class.getName());

    public static void writeJson(FullInfo fullInfo) {
        logger.log(Level.INFO, "Start to write JSON");

        try {
            Files.createDirectories(Paths.get("jsonReqs"));
            logger.log(Level.INFO, "Directory was successfully created");
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Directory already exists", e);
        }

        writeStudents(fullInfo);
        writeUniversities(fullInfo);
        writeStatistics(fullInfo);

        logger.log(Level.INFO, "Create JSON was successfully");
    }

    private static void writeStudents(FullInfo fullInfo) {
        String studentsJson = JsonUtil.writeListToJson(fullInfo.getStudentList());

        try {
            FileOutputStream fileOutputStream = new FileOutputStream("jsonReqs/students" + fullInfo.getProcessDate().getTime() + ".json");
            fileOutputStream.write(studentsJson.getBytes(StandardCharsets.UTF_8));
        } catch (FileNotFoundException e) {
            logger.log(Level.SEVERE, "Students JSON was failed, file not found", e);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Students JSON was failed, write process problems", e);
        }
    }

    private static void writeUniversities (FullInfo fullInfo) {
        String universitiesJson = JsonUtil.writeListToJson(fullInfo.getUniversityList());

        try {
            FileOutputStream fileOutputStream = new FileOutputStream("jsonReqs/universities" + fullInfo.getProcessDate().getTime() + ".json");
            fileOutputStream.write(universitiesJson.getBytes(StandardCharsets.UTF_8));
        } catch (FileNotFoundException e) {
            logger.log(Level.SEVERE, "Universities JSON was failed, file not found", e);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Universities JSON was failed, write process problems", e);
        }
    }

    private  static void writeStatistics (FullInfo fullInfo) {
        String statisticJson = JsonUtil.writeListToJson(fullInfo.getStatisticList());

        try {
            FileOutputStream fileOutputStream = new FileOutputStream("jsonReqs/statistics" + fullInfo.getProcessDate().getTime() + ".json");
            fileOutputStream.write(statisticJson.getBytes(StandardCharsets.UTF_8));
        } catch (FileNotFoundException e) {
            logger.log(Level.SEVERE, "Statistics JSON was failed, file not found", e);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Statistics JSON was failed, write process problems", e);
        }
    }


}
