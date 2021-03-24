package com.example.ensolvers.controller;

import com.example.ensolvers.model.Folder;
import com.example.ensolvers.model.Task;
import com.example.ensolvers.service.FolderService;
import com.example.ensolvers.service.TaskService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FolderController {
    @Autowired
    private FolderService folderService;
   

    @GetMapping("/")
    public String viewHomePage(Model model){
        model.addAttribute("listFolders",folderService.getAllFolder());
        Folder folder = new Folder();
        model.addAttribute("folder", folder);
        return "folders";
    }

    @GetMapping("/showNewFolderForm")
    public String showNewFolderForm(Model model){
        Folder folder = new Folder();
        model.addAttribute("folder", folder);
        return "new_folder";     
    }

    @PostMapping("/saveFolder")
    public String saveTask(@ModelAttribute("folder") Folder folder){

        boolean control = folderService.checkOut(folder);
        if(!control){ 
            folderService.saveFolder(folder);
        }
        
        return "redirect:/";
    }
    @GetMapping("/showFormForUpdateFolder/{id}")
   public String showFormForUpdate(@PathVariable(value = "id") long id, Model model){
        Folder folder = folderService.getFolderById(id);
        model.addAttribute("folder", folder);
        return "edit_folder";
   }

   @GetMapping("/deleteFolder/{id}")
   public String deleteFolder(@PathVariable (value = "id") long id){
   

        this.folderService.deleteFolder(id);
        return "redirect:/";
   }

}

