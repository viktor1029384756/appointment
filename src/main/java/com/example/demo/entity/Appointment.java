package com.example.demo.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String date;

    String fromHour;

    String toHour;

    @OneToOne
    Doctor doctor;

    @OneToOne
    Patient patient;

    public Appointment(){

    }

    public Appointment(String date, String fromHour, String toHour, Doctor doctor, Patient patient) {
        this.date = date;
        this.fromHour = fromHour;
        this.toHour = toHour;
        this.doctor = doctor;
        this.patient = patient;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFromHour() {
        return fromHour;
    }

    public void setFromHour(String fromHour) {
        this.fromHour = fromHour;
    }

    public String getToHour() {
        return toHour;
    }

    public void setToHour(String toHour) {
        this.toHour = toHour;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
