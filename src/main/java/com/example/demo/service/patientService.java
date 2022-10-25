package com.example.demo.service;

import com.example.demo.entity.Appointment;
import com.example.demo.entity.Department;
import com.example.demo.entity.Doctor;
import com.example.demo.entity.Patient;
import com.example.demo.entity.exceptions.DepartmentDoesentExist;
import com.example.demo.entity.exceptions.DoktorDoesentExists;
import com.example.demo.entity.exceptions.PatientDoesentExist;
import com.example.demo.entity.exceptions.TerminVekjePostoi;
import com.example.demo.repository.appointmentRepository;
import com.example.demo.repository.departmentRepository;
import com.example.demo.repository.doctorRepository;
import com.example.demo.repository.patientRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.xml.crypto.Data;
import java.util.*;

@Service
public class patientService {

    private final patientRepository patientRepo;

    private final doctorRepository doctorRepo;
    private final appointmentRepository appRepo;
    private final departmentRepository depRepo;

    public patientService(patientRepository patientRepo, doctorRepository doctorRepo, appointmentRepository appRepo, departmentRepository depRepo) {
        this.patientRepo = patientRepo;
        this.doctorRepo = doctorRepo;
        this.appRepo = appRepo;
        this.depRepo = depRepo;
    }


    public Patient findPatientById(int id) {
        return patientRepo.findById(id).orElse(null);
    }

    public List<Patient> findAllPatients() {
        return patientRepo.findAll();
    }

    public List<Doctor> findDoctorsByDepartment(String departmentName) {
        List<Department> departments = depRepo.findAll();
        for (Department department : departments) {
            if (department.getName().equals(departmentName)) {
                return department.getDoctors();
            }
        }
        throw new DepartmentDoesentExist("Department so toa ime ne postoi.");
    }

    public Doctor findDoctorByName(String name, String lname) {
        List<Doctor> doctors = doctorRepo.findAll();
        for (Doctor doctor : doctors) {
            if (doctor.getName().equals(name) && doctor.getLname().equals(lname)) {
                return doctor;
            }
        }
        throw new DoktorDoesentExists("Ne postoi doktor so toa ime i prezime.");
    }

    //I posle najdi spored datum koe e najnovo
    public List<Appointment> findAppByEMBG(String embg) {
        Patient patient = findPatientByEMBG(embg);
        List<Appointment> appointments = appRepo.findAll();
        List<Appointment> app = new ArrayList<>();
        for (Appointment appointment : appointments) {
            if (appointment.getPatient().getEmbg().equals(embg)) {
                app.add(appointment);
            }
        }
        return app;
    }

    public Appointment findAppointment(int id) {
        Appointment appointment = appRepo.findById(id).orElse(null);
        return appointment;
    }

    //Moze da treba i vaka da se najde appointment so slednive atributi vneseni date,from i to hour
    public Appointment findAppointmentByDateAndHour(String date, String fromHour, String toHour) {
        List<Appointment> appointments = appRepo.findAll();
        for (Appointment app : appointments) {
            if (app.getDate().equals(date) && app.getFromHour().equals(fromHour) && app.getToHour().equals(toHour)) {
                return app;
            }
        }
        throw new TerminVekjePostoi("Ne postoi takov termin.");
    }

    public Patient findPatientByEMBG(String embg) {
        List<Patient> patients = patientRepo.findAll();
        for (Patient p : patients) {
            if (p.getEmbg().equals(embg)) {
                return p;
            }
        }
        throw new PatientDoesentExist("Ne postoi takov pacient.");
    }

    //Da zakaze termin sam ili da se javi i da mu zakaze nekoj od working staff
    public void zakaziTermin(String datum, String fHour, String tHour, int doctor_id, int patient_id) {
        Patient patient = patientRepo.findById(patient_id).orElse(null);
        Doctor doctor = doctorRepo.findById(doctor_id).orElse(null);
        List<Appointment> appointments = appRepo.findAll();
        Appointment appointment = new Appointment(datum, fHour, tHour, doctor, patient);

        if (appointments.isEmpty()) {
            appRepo.save(appointment);
        }

        for (Appointment app : appointments) {
            if (app.getDoctor().getId() == doctor_id) {
                if (app.getDate().equals(datum)) {
                    //System.out.println(app.getDate());
                    //System.out.println(app.getFromHour() + " " + app.getToHour());
                    if (app.getFromHour().equals(fHour) || app.getToHour().equals(tHour)) {
                        //System.out.println(app.getFromHour() + " " + app.getToHour());
                        throw new TerminVekjePostoi("Isklucokot e frlen !!!");
                    }
                }
            }
        }
        System.out.println("Zacuvaj !!!!");
    }

    //Moze da se modifikuva termin samo ako e dva dena pred vreme.
    //Dopravi uste da vidi dali mu e pominat terminot.
    public Appointment modifyTermin(int id,String embg, String date,String fromH, String toHour, String newFromH, String newToHour) {

        List<Appointment> appointments = appRepo.findAll();
        Appointment appointment = appRepo.findById(id).orElse(null);

        for (Appointment appointment1 : appointments){
            if (appointment1.getDate().equals(date)){
                if (appointment1.getFromHour().equals(newFromH) && appointment1.getToHour().equals(newToHour)){
                    //System.out.println(appointment1.getFromHour() + " " + appointment1.getToHour());
                    throw new TerminVekjePostoi("Vekje postoi termin so toa vreme.");
                }
            }
        }
        appointment.setFromHour(newFromH);
        appointment.setToHour(newToHour);
        appRepo.save(appointment);
        return appointment;
    }
}


