package com.example.cmisdemo.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RepositoryRepository {

  Map<String,Repository> repositoryMap = new HashMap<>();

  EmptyRepository emptyRepository;

  @Autowired
  public RepositoryRepository(DemoRepository demoRepository, EmptyRepository emptyRepository) {
    repositoryMap.put(demoRepository.getInfo().getId(), demoRepository);
    repositoryMap.put(emptyRepository.getInfo().getId(), emptyRepository);
    this.emptyRepository=emptyRepository;

  }

  public Repository getRepository(String id){

   Repository repository = repositoryMap.get(id);

   if ( repository!=null){
     return repository;
   } else {
     return emptyRepository;
   }

  }

  public Collection<Repository> list() {
    return repositoryMap.values();
  }
}
