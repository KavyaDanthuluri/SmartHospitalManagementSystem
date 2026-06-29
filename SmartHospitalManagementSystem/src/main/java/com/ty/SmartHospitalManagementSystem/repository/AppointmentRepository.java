package com.ty.SmartHospitalManagementSystem.repository;

import com.ty.SmartHospitalManagementSystem.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment ,Integer> {
        List<Appointment> findByDoctorId(int id);
        List<Appointment> findByPatientId(int id);
        boolean existsById(int id);
}
