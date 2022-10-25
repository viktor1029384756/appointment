package com.example.demo.controller;

import com.example.demo.entity.Appointment;
import com.example.demo.entity.Doctor;
import com.example.demo.entity.Patient;
import com.example.demo.repository.departmentRepository;
import com.example.demo.service.doctorService;
import com.example.demo.service.patientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
public class patientController {

    private final patientService patientSer;
    private final doctorService doctorSer;
    private final com.example.demo.repository.appointmentRepository appointmentRepository;

    public patientController(patientService patientSer, doctorService doctorSer,com.example.demo.repository.appointmentRepository appointmentRepository) {
        this.patientSer = patientSer;
        this.doctorSer = doctorSer;
        this.appointmentRepository = appointmentRepository;
    }

    @GetMapping("findPatById/{id}")
    public Patient findPat(@PathVariable int id){
        return patientSer.findPatientById(id);
    }

    @GetMapping("/findPatients")
    public List<Patient> findAllPatients(){
        return patientSer.findAllPatients();
    }

    @GetMapping("/findPatientByEMBG/{embg}")
    public Patient findPatientByEMBG(@PathVariable String embg){
        return patientSer.findPatientByEMBG(embg);
    }

    @GetMapping("/findAppByEMBG/{embg}")
    public List<Appointment> findAppBYEmbg(@PathVariable String embg){
        return patientSer.findAppByEMBG(embg);
    }

    @GetMapping("/findAppByDateAndHour/{date}/{fromHour}/{toHour}")
    public Appointment findAppByDateAndHour(@PathVariable String date,@PathVariable String fromHour,@PathVariable String toHour){
        return patientSer.findAppointmentByDateAndHour(date,fromHour,toHour);
    }

    @GetMapping("/findAppointment/{id}")
    public Appointment findApp(@PathVariable int id){
        return patientSer.findAppointment(id);
    }

    @GetMapping("/findDoctorsByDepartment/{departmentName}")
    public List<Doctor> findDoctorsByDepartment(@PathVariable String departmentName){
        return patientSer.findDoctorsByDepartment(departmentName);
    }

    @GetMapping("/findDoctorByName/{name}/{lname}")
    public Doctor findDoctorByName(@PathVariable String name,@PathVariable String lname){
        return patientSer.findDoctorByName(name,lname);
    }

    @PostMapping("/save/{datum}/{fromHour}/{toHour}/{doctor_id}/{patient_id}")
    public void makeAnAppointment(@PathVariable String datum, @PathVariable String fromHour, @PathVariable String toHour, @PathVariable int doctor_id, @PathVariable int patient_id){
        patientSer.zakaziTermin(datum,fromHour,toHour,doctor_id,patient_id);
    }

    @PutMapping("/modifyApp/{id}/{embg}/{date}/{fromH}/{toHour}/{newFromH}/{newToHour}")
    public Appointment modifyAnAppointment(@PathVariable int id,@PathVariable String embg,@PathVariable String date,@PathVariable String fromH,@PathVariable String toHour,@PathVariable String newFromH,@PathVariable String newToHour){
        return patientSer.modifyTermin(id,embg,date,fromH,toHour,newFromH,newToHour);
    }

}
