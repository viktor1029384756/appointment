package com.example.demo.repository;

import com.example.demo.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.print.Doc;

@Repository
public interface doctorRepository extends JpaRepository<Doctor,Integer> {
}
