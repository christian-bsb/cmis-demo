package com.example.docuserver.dto;

import com.example.cmisdemo.model.*;
import com.example.docuserver.model.CmisDoc;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class DtoService {

  public List<Document> cmisDocsToDocuments(List<CmisDoc> cmisDocs) {
    return cmisDocs.stream().map(this::cmisDocToDocument).collect(Collectors.toList());
  }

  public Document cmisDocToDocument(CmisDoc cmisDoc) {
    // todo get type
    PropertyDefinition iddef =
        new PropertyDefinition("id", "id", Constants.OBJECTTYPE_STRING, Cardinality.SINGLE);

    Document document = new Document();
    document.getProperties().add(new CmisProperty(iddef, cmisDoc.getId()));
    return document;
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
