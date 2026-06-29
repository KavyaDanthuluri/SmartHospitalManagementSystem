package com.ty.SmartHospitalManagementSystem.service;

import com.ty.SmartHospitalManagementSystem.dto.request.BillingRequestDTO;
import com.ty.SmartHospitalManagementSystem.dto.response.BillingResponseDTO;
import com.ty.SmartHospitalManagementSystem.entity.Billing;
import com.ty.SmartHospitalManagementSystem.entity.Patient;
import com.ty.SmartHospitalManagementSystem.exception.ResourceNotFoundException;
import com.ty.SmartHospitalManagementSystem.repository.BillingRepository;
import com.ty.SmartHospitalManagementSystem.repository.PatientRepository;
import com.ty.SmartHospitalManagementSystem.utility.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BillingService {
    @Autowired
    private BillingRepository billingRepository;

    @Autowired
    private PatientRepository patientRepository;

    //Save a bill
    public ResponseEntity<ResponseStructure<BillingResponseDTO>> saveBill(BillingRequestDTO billing){
        Billing bill = new Billing();
        bill.setId(billing.getId());
        bill.setAmount(billing.getAmount());
        bill.setPaymentMethod(billing.getPaymentMethod());
        bill.setPaymentStatus(billing.getPaymentStatus());
        Patient patient=patientRepository.findById(billing.getPatientId()).orElse(null);
        bill.setPatient(patient);
        Billing savedBill=billingRepository.save(bill);
        return mapToResponseDTO(savedBill);
    }
    public ResponseEntity<ResponseStructure<BillingResponseDTO>> mapToResponseDTO(Billing savedBill) {
        BillingResponseDTO billResponse = new BillingResponseDTO();
        billResponse.setId(savedBill.getId());
        billResponse.setAmount(savedBill.getAmount());
        billResponse.setPaymentStatus(savedBill.getPaymentStatus());
        billResponse.setPatientId(savedBill.getPatient().getId());
        ResponseStructure<BillingResponseDTO> rs=new ResponseStructure<>();
        rs.setStatusCode(HttpStatus.OK.value());
        rs.setMessage("Success");
        rs.setData(billResponse);
        return new ResponseEntity<ResponseStructure<BillingResponseDTO>>(rs, HttpStatus.OK);
    }
    //Update a bill
    public ResponseEntity<ResponseStructure<BillingResponseDTO>> updateBill(BillingRequestDTO billing){
        Billing bill = new Billing();
        bill.setId(billing.getId());
        bill.setAmount(billing.getAmount());
        bill.setPaymentMethod(billing.getPaymentMethod());
        bill.setPaymentStatus(billing.getPaymentStatus());
        Patient patient=patientRepository.findById(billing.getPatientId()).orElse(null);
        bill.setPatient(patient);
        Billing savedBill=billingRepository.save(bill);
        return mapToResponseDTO(savedBill);
    }
    //delete a bill
    public ResponseEntity<ResponseStructure<String>> deleteBill(int id){
        ResponseStructure<String> rs=new ResponseStructure<>();
        Optional<Billing> optional = billingRepository.findById(id);
        if(optional.isPresent()) {
            rs.setStatusCode(HttpStatus.OK.value());
            rs.setMessage("Success");
            billingRepository.deleteById(id);
            rs.setData("Bill deleted succesfully");
        }
        else
            throw new ResourceNotFoundException("Bill with id "+id+" not found");
        return new ResponseEntity<ResponseStructure<String>>(rs,HttpStatus.OK);
    }
    //find bill
    public ResponseEntity<ResponseStructure<BillingResponseDTO>> findBill(int id) {
        Optional<Billing> billing=billingRepository.findById(id);
        if(billing.isPresent()) {
            return mapToResponseDTO(billing.get());
        }
        else{
            throw new ResourceNotFoundException("Bill with id "+id+" not found");
        }
    }
    //findAllBills
    public ResponseEntity<ResponseStructure<List<BillingResponseDTO>>> findAllBills(){
        List<Billing> billings= billingRepository.findAll();
        return mapToResponseDTOList(billings);
    }

    public ResponseEntity<ResponseStructure<List<BillingResponseDTO>>> mapToResponseDTOList(List<Billing> billings) {
        List<BillingResponseDTO> billing=new ArrayList<>();
        for(Billing bill:billings){
           BillingResponseDTO b=new BillingResponseDTO();
            b.setId(bill.getId());
            b.setAmount(bill.getAmount());
            b.setPaymentStatus(bill.getPaymentStatus());
            Patient patient=patientRepository.findById(bill.getPatient().getId()).orElse(null);
            b.setPatientId(bill.getPatient().getId());
            billing.add(b);
        }
        ResponseStructure<List<BillingResponseDTO>> rs = new ResponseStructure<>();
        rs.setStatusCode(HttpStatus.OK.value());
        rs.setMessage("Success");
        rs.setData(billing);
        return new ResponseEntity<ResponseStructure<List<BillingResponseDTO>>>(rs,HttpStatus.OK);
    }
}
