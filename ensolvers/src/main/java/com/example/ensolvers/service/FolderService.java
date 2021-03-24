package com.example.ensolvers.service;
import java.util.List;

import com.example.ensolvers.model.Folder;


public interface FolderService {
    public List<Folder> getAllFolder();
    Folder getFolderById(long id);
    void saveFolder(Folder folder);
    void deleteFolder(long id);
    boolean checkOut(Folder folder);
    boolean validateFormField (String paramName);

}
