package com.example.docuserver.dto;

import com.example.cmisdemo.model.Cardinality;
import com.example.cmisdemo.model.CmisProperty;
import com.example.cmisdemo.model.Document;
import com.example.cmisdemo.model.PropertyDefinition;
import com.example.cmisdemo.model.PropertyType;
import com.example.docuserver.model.CmisDoc;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class DtoService {

  public List<Document> cmisDocsToDocuments(List<CmisDoc> cmisDocs){
    return cmisDocs.stream().map(this::cmisDocToDocument).collect(Collectors.toList());
  }

  public Document cmisDocToDocument(CmisDoc cmisDoc){
    // todo get type
    PropertyDefinition iddef = new PropertyDefinition("id", "id", PropertyType.STRING, Cardinality.SINGLE);

    Document document = new Document();
    document.getProperties().add( new CmisProperty(iddef, cmisDoc.getId()));
    return document;
  }

  public CmisDoc documentToCmisDoc(Document document){

    CmisDoc cmisDoc = new CmisDoc();
    cmisDoc.setId("undefined");
    for ( CmisProperty cmisProperty : document.getProperties()){
      if (cmisProperty.getDefinition().getDisplayName().equals("id"))
      cmisDoc.setId(cmisProperty.getValue().toString());
    }
    return cmisDoc;
  }

}
