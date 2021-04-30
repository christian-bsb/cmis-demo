package com.example.client.infoparser;

import com.example.client.infoparser.service.CmisClientService;
import com.example.cmisdemo.model.*;
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
    */

    /*
    String objectTypeId = "8";
    ObjectType storedType = getTypeDefinition("1", objectTypeId);
    LOGGER.info("stored type: " + storedType.toString());
    */
    // createFolder();

    // String documentId = createDocument();
    Document person = getDocument("person_1");
    LOGGER.info("document id =" + person);
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
    // Properties properties = new Properties();
    // properties.put(Constants.PARAM_PATH, "exampeDoc.txt");

    PropertyDefinition iddef =
        new PropertyDefinition("id", "id", Constants.OBJECTTYPE_STRING, Cardinality.SINGLE);
    Document document = new Document();
    document.getProperties().add(new CmisProperty(iddef, "id:777"));

    return cmisClientService.createDocument("1", "1", document);
  }

  public Document getDocument(String id) throws Exception {
    return cmisClientService.getDocument(id);
  }

  public ObjectType createObjectType() throws Exception {
    ObjectType objectType = new ObjectType(null, "News");
    objectType
        .getPropertyDefinitions()
        .add(
            new PropertyDefinition(null, "title", Constants.OBJECTTYPE_STRING, Cardinality.SINGLE));
    objectType
        .getPropertyDefinitions()
        .add(new PropertyDefinition(null, "text", Constants.OBJECTTYPE_STRING, Cardinality.SINGLE));
    cmisClientService.createObjectType("1", objectType);
    return objectType;
  }

  public ObjectType getTypeDefinition(String repositoryId, String typeId) throws Exception {
    return cmisClientService.getTypeDefiniton(repositoryId, typeId);
  }
}
