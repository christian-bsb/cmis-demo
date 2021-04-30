package example.com.cmisservices.util;

import com.example.cmisdemo.model.Constants;

public class TypeUtil {

  public static boolean isObjectType(String typeId) {
    if (typeId == null) {
      return false;
    }
    if (typeId.equals(Constants.OBJECTTYPE_STRING)
        || typeId.equals(Constants.OBJECTTYPE_BOOLEAN)
        || typeId.equals(Constants.OBJECTTYPE_DATE)
        || typeId.equals(Constants.OBJECTTYPE_INTEGER)) {
      return false;
    }
    return true;
  }
}
