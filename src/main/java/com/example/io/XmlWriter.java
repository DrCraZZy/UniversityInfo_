package com.example.io;

import com.example.model.FullInfo;
import lombok.NoArgsConstructor;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

@NoArgsConstructor
public class XmlWriter {
    private static final Logger logger = Logger.getLogger(XmlWriter.class.getName());

    public static void generateXml (FullInfo fullInfo) {
        try {
            logger.log(Level.INFO, "Start create XML");

            JAXBContext jaxbContent = JAXBContext.newInstance(FullInfo.class);

            Marshaller marshaller = jaxbContent.createMarshaller();

            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            try {
                Files.createDirectories(Paths.get("xmlReqs"));
                logger.log(Level.INFO, "Directory successfully created");
            } catch (IOException e) {
                logger.log(Level.SEVERE, "Directory already exists", e);
            }

            File file = new File("xmlReqs/infoReq" + new Date().getTime() + ".xml");
            marshaller.marshal(fullInfo, file);

            logger.log(Level.INFO, "XML was successfully created");
        } catch (JAXBException e) {
            logger.log(Level.SEVERE, "Create XML is failed", e);
        }
    }
}
