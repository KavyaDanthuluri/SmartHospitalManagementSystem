package com.ty.SmartHospitalManagementSystem.dto.request;

import com.ty.SmartHospitalManagementSystem.enums.AppointmentStatus;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;

public class AppointmentRequestDTO {
    @NotNull(message = "Id is required")
    private int id;
    @FutureOrPresent(message = "Appointment date can't be in past")
    private LocalDate appointmentDate;
    @FutureOrPresent(message = "Appointment date can't be in past")
    private LocalTime appointmentTime;
    @NotNull(message = "Status shoulde be Confirmed,Scheduled or Completed only")
    private AppointmentStatus status;
    @NotNull(message = "Patient Id is required")
    private int patientId;
    @NotNull(message = "Doctor Id is required")
    private int doctorId;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }
    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }
    public LocalTime getAppointmentTime() {
        return appointmentTime;
    }
    public void setAppointmentTime(LocalTime appointmentTime) {
        this.appointmentTime = appointmentTime;
    }
    public AppointmentStatus getStatus() {
        return status;
    }
    public void setStatus(AppointmentStatus status) {
        this.status = status;
    }
    public int getPatientId() {
        return patientId;
    }
    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }
    public int getDoctorId() {
        return doctorId;
    }
    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }
}
