package com.example.demo.controller;

import com.example.demo.entity.Patient;
import com.example.demo.entity.WorkingStaff;
import com.example.demo.repository.patientRepository;
import com.example.demo.repository.workingstaffRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class workingStaffController {

    private final patientRepository patientRepo;
    private final workingstaffRepository WorkingStaffRepository;

    public workingStaffController(patientRepository patientRepo, workingstaffRepository workingStaffRepository) {
        this.patientRepo = patientRepo;
        WorkingStaffRepository = workingStaffRepository;
    }


    @PostMapping("/savePatient")
    public void savePatient(@RequestBody Patient patient){
        patientRepo.save(patient);
    }

    @PostMapping("/saveWorkingStaff")
    public void saveWorkingStaff(WorkingStaff workingStaff){
        WorkingStaffRepository.save(workingStaff);
    }

}
