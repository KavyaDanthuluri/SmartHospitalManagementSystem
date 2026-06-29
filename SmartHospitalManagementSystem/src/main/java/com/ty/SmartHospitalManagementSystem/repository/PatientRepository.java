package com.ty.SmartHospitalManagementSystem.repository;

import com.ty.SmartHospitalManagementSystem.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient,Integer> {
    List<Patient> findByName(String name);
    boolean existsByEmail(String email);
    boolean existsByPhone(String phone);
}
