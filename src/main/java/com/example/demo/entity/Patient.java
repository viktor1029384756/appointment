package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String embg;

    String name;

    String lname;

    String email;

    Patient(int id,String embg,String name,String lname,String email){
        this.id = id;
        this.embg = embg;
        this.name = name;
        this.lname = lname;
        this.email = email;
    }

    public Patient() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmbg() {
        return embg;
    }

    public void setEmbg(String embg) {
        this.embg = embg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
