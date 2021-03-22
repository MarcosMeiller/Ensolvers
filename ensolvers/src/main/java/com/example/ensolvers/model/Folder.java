package com.example.ensolvers.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Entity
@Table(name = "folder")

public class Folder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "id_user")
    private int idUser;

    @Column(name = "name")
    private String name;

    public Folder(){
        
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
  
    

    public void setId(long id) {
        this.id = id;
    }

  
    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public void setName(String name) {
        this.name = name;
    }   

}
