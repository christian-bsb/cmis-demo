package com.example.cmisdemo.service;

import com.example.cmisdemo.model.RepositoryInfo;
import com.example.cmisdemo.repository.Repository;
import com.example.cmisdemo.repository.RepositoryRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RepositoryService {

  @Autowired RepositoryRepository repositoryRepository;

  public RepositoryService() {}

  public Repository getRepository(String id) {
    return repositoryRepository.getRepository(id);
  }

  public List<RepositoryInfo> getRepositoryInfos() {
    return repositoryRepository.list().stream()
        .map(Repository::getInfo)
        .collect(Collectors.toList());
  }
}
