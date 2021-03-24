package com.example.ensolvers.service;

import java.util.List;
import java.util.Optional;

import com.example.ensolvers.model.Folder;
import com.example.ensolvers.repository.FolderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FolderServiceImpl implements FolderService {
    @Autowired
    private FolderRepository folderRepository;
    @Override
    public List<Folder> getAllFolder() {// return a list with all the folders
       return folderRepository.findAll();
    }

    @Override
    public void saveFolder(Folder folder) { //save the folder in the db
            this.folderRepository.save(folder);
    }

    @Override
    public void deleteFolder(long id) { //delete the folder if the id exist
        this.folderRepository.deleteById(id);;        
    }
    
    @Override
    public Folder getFolderById(long id) { //return the folder if the id exist. 
        Optional <Folder> optional = folderRepository.findById(id);
        Folder folder = null;
       
        if(optional.isPresent()){
            folder = optional.get();            
        }else{
            throw new RuntimeException("Folder not found");
        }
     
    
        return folder;
               
    }

    @Override
    public boolean checkOut(Folder folder) {//return true if the name already exist and false if not exist
        List <Folder> folders = folderRepository.findAll();
        boolean control = false;
        control = validateFormField (folder.getName());
        if(control == false){ 
        for (Folder folder2 : folders) {
            if(folder2.getName().equals(folder.getName())){
                control = true;
                break;
            }
        }
    }
        return control;
    }

    @Override
    public boolean validateFormField (String paramName) //return true if parmName is Empty or wihout text.
        {
            boolean flag = false;
            String nuevo = paramName.trim();
            if(!nuevo.isEmpty())
            {
               flag = false;  
            }
            else
            {
                flag = true;
            } 

            return flag;
        }
    
}