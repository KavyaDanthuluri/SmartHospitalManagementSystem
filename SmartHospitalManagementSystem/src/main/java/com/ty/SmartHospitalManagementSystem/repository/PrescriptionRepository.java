package com.ty.SmartHospitalManagementSystem.repository;

import com.ty.SmartHospitalManagementSystem.entity.Appointment;
import com.ty.SmartHospitalManagementSystem.entity.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrescriptionRepository extends JpaRepository<Prescription,Integer> {
    boolean existsByAppointment(Appointment appointment);
}
