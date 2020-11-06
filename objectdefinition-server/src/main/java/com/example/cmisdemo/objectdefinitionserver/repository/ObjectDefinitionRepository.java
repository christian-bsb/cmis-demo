package com.example.cmisdemo.objectdefinitionserver.repository;

import com.example.cmisdemo.objectdefinitionserver.model.hibernate.ObjectDefinitionEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObjectDefinitionRepository extends CrudRepository<ObjectDefinitionEntity, Long> {}
