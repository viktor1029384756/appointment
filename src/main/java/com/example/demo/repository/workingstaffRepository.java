package com.example.demo.repository;

import com.example.demo.entity.WorkingStaff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface workingstaffRepository extends JpaRepository<WorkingStaff,Long> {
}
