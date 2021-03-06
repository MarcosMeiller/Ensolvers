package com.example.ensolvers.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Entity
@Table(name = "tasks")
public class Task {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "id_folder")
    private long id_folder;
    @Column(name = "status")
    private boolean state;
   
    public Task(){
        
    }

   

    public boolean getState(){
        return state;
    }
    public String getName() {
        return name;
    }
   
    public long getId() {
        return id;
    }
  
    public long getId_folder() {
        return id_folder;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setState(boolean state){
        this.state = state;
    }
    public void setId_folder(long id_folder) {
        this.id_folder = id_folder;
    }


    public void setName(String name) {
        this.name = name;
    }   
}
