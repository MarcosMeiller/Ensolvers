package com.example.ensolvers.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.ensolvers.model.Task;
import com.example.ensolvers.repository.TaskRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService{
    @Autowired
    private TaskRepository taskRepository;

    @Override
    public List<Task> getAllTask() {// return a list with all the folders
        return taskRepository.findAll();
    }

    @Override
    public void saveTask(Task task) {//save the folder in the db
        this.taskRepository.save(task);
        
    }

    @Override
    public Task getTaskById(long id) { //return the folder if the id exist. 
        Optional <Task> optional = taskRepository.findById(id);
        Task task = null;
       
        if(optional.isPresent()){
            task = optional.get();            
        }else{
            throw new RuntimeException("Task not found");
        }
     
    
        return task;
    }

    @Override
    public void deleteTask(long id) {//delete the folder if the id exist
        this.taskRepository.deleteById(id);        
    }

    @Override
    public List<Task> getAllTaskByFolder(long id) {// Returns all tasks in the folder.
 
        List<Task> tasks =taskRepository.findAll();
        List<Task> task_filter = new ArrayList<>();
        for (Task task : tasks) {
            if(task.getId_folder() == id){
                task_filter.add(task);
            }
        }
        return task_filter;
    }

    @Override
    public boolean checkOut(Task task) { //return true if the name already exist and false if not exist
        List<Task> tasks = getAllTaskByFolder(task.getId_folder());
        boolean control = false;
        control = validateFormField (task.getName());
        if(control == false){ 
            for (Task tasks2 : tasks) {
                if(tasks2.getName().equals(task.getName())){
                    control = true;
                    break;
                }
            }
        }
        return control;
    }

    @Override
    public boolean validateFormField(String paramName) {//return true if the parmName is Empty or wihout text.
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

   
