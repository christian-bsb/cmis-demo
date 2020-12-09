package com.example.client.infoparser;

import com.example.client.infoparser.service.CmisClientService;
import com.example.cmisdemo.model.Cardinality;
import com.example.cmisdemo.model.Constants;
import com.example.cmisdemo.model.Folder;
import com.example.cmisdemo.model.ObjectType;
import com.example.cmisdemo.model.PropertyDefinition;
import com.example.cmisdemo.model.PropertyType;
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
    /*
    ObjectType objectType = createObjectType();
    System.out.println(objectType);
    System.out.println("------ type id: " + objectType.getId());
    */

    String objectTypeId = "8";
    ObjectType storedType = getTypeDefinition("1", objectTypeId);
    LOGGER.info("stored type: " + storedType.toString());

    // createFolder();
    // String documentId = createDocument();
    // LOGGER.info("document id =" + documentId);
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

  public ObjectType createObjectType() throws Exception {
    ObjectType objectType = new ObjectType(null, "News");
    objectType
        .getPropertyDefinitions()
        .add(new PropertyDefinition(null, "title", PropertyType.STRING, Cardinality.SINGLE));
    objectType
        .getPropertyDefinitions()
        .add(new PropertyDefinition(null, "text", PropertyType.HTML, Cardinality.SINGLE));
    cmisClientService.createObjectType("1", objectType);
    return objectType;
  }

  public ObjectType getTypeDefinition(String repositoryId, String typeId) throws Exception {
    return cmisClientService.getTypeDefiniton(repositoryId, typeId);
  }
}
