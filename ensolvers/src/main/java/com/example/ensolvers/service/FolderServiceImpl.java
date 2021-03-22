package com.example.ensolvers.service;

import java.util.List;

import com.example.ensolvers.model.Folder;
import com.example.ensolvers.repository.FolderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FolderServiceImpl implements FolderService {
    @Autowired
    private FolderRepository folderRepository;
    @Override
    public List<Folder> getAllFolder() {
       return folderRepository.findAll();
    }

    @Override
    public void saveFolder(Folder folder) {
            this.folderRepository.save(folder);
    }

    @Override
    public void deleteFolder(long id) {
        this.folderRepository.deleteById(id);;        
    }
    
}