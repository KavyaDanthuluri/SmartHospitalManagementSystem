package com.ty.SmartHospitalManagementSystem.repository;

import com.ty.SmartHospitalManagementSystem.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,Integer> {
    boolean existsByDepartmentName(String departmentName);

}
