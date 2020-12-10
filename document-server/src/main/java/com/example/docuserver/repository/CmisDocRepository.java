package com.example.docuserver.repository;

import com.example.docuserver.model.CmisDoc;
import java.util.List;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.solr.repository.Query;
import org.springframework.data.solr.repository.SolrCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("cmisDocRepository")
public interface CmisDocRepository extends SolrCrudRepository<CmisDoc,String> {

  @Query(value = "*:*")
  List<CmisDoc> getCmisDocs();

}
