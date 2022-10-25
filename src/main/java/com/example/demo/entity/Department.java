package com.example.demo.entity;

import javax.persistence.*;
import javax.print.Doc;
import java.util.List;

@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;

    @OneToMany
    List<Doctor> doctors;

    public Department(){

    }

    public Department(int id, String name, List<Doctor> doctors) {
        this.id = id;
        this.name = name;
        this.doctors = doctors;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }
}
