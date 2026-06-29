package com.ty.SmartHospitalManagementSystem.dto.response;

import com.ty.SmartHospitalManagementSystem.enums.PaymentStatus;

public class BillingResponseDTO {
    private int id;
    private double amount;
    private PaymentStatus paymentStatus;
    private int patientId;
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
    public int getPatientId() {
        return patientId;
    }
    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }
}
