package example.com.cmisservices.model;

import com.example.cmisdemo.model.CmisProperty;
import com.example.cmisdemo.model.Document;
import example.com.cmisservices.repository.DocumentRepository;
import example.com.cmisservices.util.TypeUtil;
import java.util.HashMap;
import java.util.Map;

public class DocumentProxy {

  Document document;

  DocumentRepository documentRepository;

  Map<String, Object> propertyMap = new HashMap<>();

  public DocumentProxy(Document document, DocumentRepository documentRepository) {
    this.document = document;
    this.documentRepository = documentRepository;
    for (CmisProperty cmisProperty : document.getProperties()) {
      if (!TypeUtil.isObjectType(cmisProperty.getDefinition().getTypeId())) {
        propertyMap.put(cmisProperty.getDefinition().getPropertyId(), cmisProperty.getValue());
      } else {
        propertyMap.put(cmisProperty.getDefinition().getPropertyId(), null);
      }
    }
  }

  public Object getProperty(String key) throws Exception {
    if (!propertyMap.containsKey(key)) {
      return null;
    }
    Object clientValue = propertyMap.get(key);
    if (clientValue != null || !TypeUtil.isObjectType(document.getTypeId())) {
      return clientValue;
    }
    // property is defined but value is null
    // load value from server
    Document lazyDoc = documentRepository.getDocument("1", document.getPropertyValue(key));
    propertyMap.put(key, lazyDoc);
    return lazyDoc;
  }
}
