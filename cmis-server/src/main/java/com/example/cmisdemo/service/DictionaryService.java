package com.example.cmisdemo.service;

import com.example.cmisdemo.model.Folder;
import com.example.cmisdemo.repository.DictionaryRepository;
import com.example.cmisdemo.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class DictionaryService {

    @Autowired
    DictionaryRepository dictionaryRepository;

    public Folder createFolder(Repository repository, Folder folder) throws Exception {

        Folder folderDict = dictionaryRepository.createFolder(repository,folder);

        repository.createFolder(folderDict);

        return folderDict;
    }
}
