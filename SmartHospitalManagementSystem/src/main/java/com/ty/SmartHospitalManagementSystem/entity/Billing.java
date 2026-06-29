package com.ty.SmartHospitalManagementSystem.entity;

import com.ty.SmartHospitalManagementSystem.enums.AppointmentStatus;
import com.ty.SmartHospitalManagementSystem.enums.PaymentStatus;
import jakarta.persistence.*;

@Entity
public class Billing {
    @Id
    private int id;
    private double amount;
    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;
    private String paymentMethod;
    @ManyToOne
    private Patient patient;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }
    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
    public String getPaymentMethod() {
        return paymentMethod;
    }
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
    public Patient getPatient() {
        return patient;
    }
    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
