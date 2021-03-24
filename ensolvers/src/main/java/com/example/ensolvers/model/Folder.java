package com.example.ensolvers.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Entity
@Table(name = "folders")

public class Folder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")
    private String name;

    public Folder(){
        
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



    public void setName(String name) {
        this.name = name;
    }   

}
