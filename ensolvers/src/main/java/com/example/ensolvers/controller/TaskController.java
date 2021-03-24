package com.example.ensolvers.controller;


import com.example.ensolvers.model.Task;
import com.example.ensolvers.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class TaskController {

    @Autowired
    private TaskService taskService;



    @GetMapping("/allTask")
    public String viewHomePage(Model model){
        model.addAttribute("listTask",taskService.getAllTask());
        return "index";
    }



    @GetMapping("/showNewTaskForm")
    public String showNewTaskForm(Model model){        
        Task task = new Task();
        model.addAttribute("task", task);
        return "new_task";
        
    }

    @PostMapping("/saveTask/{id}")
    public String saveTask(@ModelAttribute("task") Task task,@PathVariable (value = "id") long id, Model model){
        
        task.setId_folder(id);
        boolean control = taskService.checkOut(task);
        if(!control){ 
            taskService.saveTask(task);
        }
        
        model.addAttribute("listTask",taskService.getAllTaskByFolder(id));
        Task newtask = new Task();
        newtask.setId_folder(id);
        model.addAttribute("task", newtask);

        return "task_by_folder";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable (value = "id") long id, Model model){
        //get task from the list
        Task task = taskService.getTaskById(id);

        model.addAttribute("task", task);
     
        return "edit_task";

    }

    @GetMapping("/deleteTask/{id}")
	public String deleteTask(@PathVariable (value = "id") long id) {
		
		// call delete employee method 
		this.taskService.deleteTask(id);
		return "redirect:/";
	}

    @GetMapping("/taskbyfolder/{id}")
    public String viewTaskForFolder(Model model,@PathVariable (value = "id") long id){
        model.addAttribute("listTask",taskService.getAllTaskByFolder(id));
        Task task = new Task();
        task.setId_folder(id);
        model.addAttribute("task", task);

        return "task_by_folder";
    }
}
