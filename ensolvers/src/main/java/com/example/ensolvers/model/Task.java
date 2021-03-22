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
    @Column(name = "id_user")
    private int idUser;
    @Column(name = "id_folder")
    private int id_folder;
   
   
    public Task(){
        
    }

    public int getIdUser() {
        return idUser;
    }

    public String getName() {
        return name;
    }
   
    public long getId() {
        return id;
    }
  
    public int getId_folder() {
        return id_folder;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setId_folder(int id_folder) {
        this.id_folder = id_folder;
    }
    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public void setName(String name) {
        this.name = name;
    }   
}
