package com.ty.SmartHospitalManagementSystem.repository;

import com.ty.SmartHospitalManagementSystem.entity.Department;
import com.ty.SmartHospitalManagementSystem.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.print.Doc;
import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor,Integer> {
    //Search doctors by specialization
   // View doctors by department

    List<Doctor> findByDepartmentDepartmentName(String departmentName);
    Doctor findByEmail(String email);
    boolean existsByEmail(String email);
}
