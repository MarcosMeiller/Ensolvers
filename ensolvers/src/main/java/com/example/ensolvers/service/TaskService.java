package com.example.ensolvers.service;

import java.util.List;

import com.example.ensolvers.model.Task;

public interface TaskService {
    public List<Task> getAllTask();
    void saveTask(Task task);
    Task getTaskById(long id);
    void deleteTask(long id);
    public List<Task> getAllTaskByFolder(long id_folder);
    boolean checkOut(Task task);
    boolean validateFormField (String paramName);
}
