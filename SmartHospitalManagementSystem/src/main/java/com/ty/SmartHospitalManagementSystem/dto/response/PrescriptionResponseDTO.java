package com.ty.SmartHospitalManagementSystem.dto.response;

import java.time.LocalDate;

public class PrescriptionResponseDTO {
    private int id;
    private String diagnosis;
    private String medicines;
    private String instructions;
    private LocalDate appointmentDate;
    private String appointmentStatus;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getDiagnosis() {
        return diagnosis;
    }
    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }
    public String getMedicines() {
        return medicines;
    }
    public void setMedicines(String medicines) {
        this.medicines = medicines;
    }
    public String getInstructions() {
        return instructions;
    }
    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getAppointmentStatus() {
        return appointmentStatus;
    }

    public void setAppointmentStatus(String appointmentStatus) {
        this.appointmentStatus = appointmentStatus;
    }
}
