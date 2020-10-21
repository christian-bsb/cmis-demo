package com.example.client.infoparser;

import com.example.client.infoparser.service.CmisClientService;
import com.example.cmisdemo.model.Constants;
import com.example.cmisdemo.model.Folder;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

  private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

  @Autowired CmisClientService cmisClientService;

  public static void main(String[] args) throws Exception {
    SpringApplication.run(Application.class, args);
  }

  // access command line arguments
  @Override
  public void run(String... args) throws Exception {
    // createFolder();
    String documentId = createDocument();
    LOGGER.info("document id =" + documentId);
  }

  void createFolder() throws Exception {

    int count = 0;
    Folder folder = new Folder();
    // folder.setId("test123");
    folder.setName("Testfolder");
    LOGGER.info("+: " + count + " sending " + folder);
    cmisClientService.save(folder);
  }

  public String createDocument() throws Exception {
    Properties properties = new Properties();
    properties.put(Constants.PARAM_PATH, "exampeDoc.txt");
    return cmisClientService.createDocument("1", "1", properties);
  }
}
