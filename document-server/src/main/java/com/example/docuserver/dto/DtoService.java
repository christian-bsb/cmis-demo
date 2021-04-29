package com.example.docuserver.dto;

import com.example.cmisdemo.model.*;
import com.example.docuserver.model.CmisDoc;
import example.com.cmisservices.repository.TypeDefinitionRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DtoService {

  @Autowired TypeDefinitionRepository typeDefinitionRepository;

  public List<Document> cmisDocsToDocuments(List<CmisDoc> cmisDocs) {
    return cmisDocs.stream().map(this::cmisDocToDocument).collect(Collectors.toList());
  }

  public Document cmisDocToDocument(CmisDoc cmisDoc) {
    Document document = new Document();
    document
        .getProperties()
        .add(
            new CmisProperty(
                new PropertyDefinition("id", "id", Constants.OBJECTTYPE_STRING, Cardinality.SINGLE),
                cmisDoc.getId()));
    document
        .getProperties()
        .add(
            new CmisProperty(
                new PropertyDefinition(
                    "typeId", "typeId", Constants.OBJECTTYPE_STRING, Cardinality.SINGLE),
                cmisDoc.getTypeId()));

    try {
      ObjectType objectType = typeDefinitionRepository.getTypeDefinition(cmisDoc.getTypeId());
      for (PropertyDefinition pd : objectType.getPropertyDefinitions()) {
        PropertyDefinition propDef =
            new PropertyDefinition(
                pd.getPropertyId(), pd.getDisplayName(), pd.getTypeId(), pd.getCardinality());
        document
            .getProperties()
            .add(new CmisProperty(propDef, cmisDoc.getTextMap().get(pd.getPropertyId() + "_t")));
      }

      return document;
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public CmisDoc documentToCmisDoc(Document document) {

    CmisDoc cmisDoc = new CmisDoc();
    cmisDoc.setId("undefined");
    for (CmisProperty cmisProperty : document.getProperties()) {
      if (cmisProperty.getDefinition().getPropertyId().equals("id")) {
        cmisDoc.setId(cmisProperty.getValue().toString());
      } else if (cmisProperty.getDefinition().getPropertyId().equals("typeId")) {
        cmisDoc.setTypeId(cmisProperty.getValue().toString());
      } else {
        cmisDoc
            .getTextMap()
            .put(
                cmisProperty.getDefinition().getPropertyId() + "_t",
                cmisProperty.getValue().toString());
      }
    }
    return cmisDoc;
  }
}
