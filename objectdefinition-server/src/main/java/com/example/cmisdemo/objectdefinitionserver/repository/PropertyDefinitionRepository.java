package com.example.cmisdemo.objectdefinitionserver.repository;

import com.example.cmisdemo.objectdefinitionserver.model.hibernate.PropertyDefinitionEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyDefinitionRepository
    extends CrudRepository<PropertyDefinitionEntity, Long> {}
