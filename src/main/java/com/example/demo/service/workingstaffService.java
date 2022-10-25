package com.example.demo.service;

import com.example.demo.entity.Patient;
import com.example.demo.repository.patientRepository;
import org.springframework.stereotype.Service;

@Service
public class workingstaffService {

    private final patientRepository patientRepo;

    public workingstaffService(patientRepository patientRepo) {
        this.patientRepo = patientRepo;
    }

    //Create patient
    public void savePatient(Patient patient){
        patientRepo.save(patient);
    }

}
