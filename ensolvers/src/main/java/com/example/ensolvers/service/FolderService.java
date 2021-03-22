package com.example.ensolvers.service;
import java.util.List;

import com.example.ensolvers.model.Folder;


public interface FolderService {
    public List<Folder> getAllFolder();
    void saveFolder(Folder folder);
    void deleteFolder(long id);

}
