package com.ty.SmartHospitalManagementSystem.dto.request;

import com.ty.SmartHospitalManagementSystem.enums.PaymentStatus;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class BillingRequestDTO {

    private int id;
    @Positive(message = "Amount should be positive")
    private double amount;
    private PaymentStatus paymentStatus;
    @NotNull(message = "Payment Method is required")
    private String paymentMethod;
    @NotNull(message = "Patient Id is required")
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
    public String getPaymentMethod() {
        return paymentMethod;
    }
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
    public int getPatientId() {
        return patientId;
    }
    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }
}
