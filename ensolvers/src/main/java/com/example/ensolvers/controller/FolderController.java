package com.example.ensolvers.controller;

import com.example.ensolvers.service.FolderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FolderController {
    @Autowired
    private FolderService taskService;

    @GetMapping("/folders")
    public String viewHomePage(Model model){
        model.addAttribute("listFolders",taskService.getAllFolder());
        return "folders";
    }

}

