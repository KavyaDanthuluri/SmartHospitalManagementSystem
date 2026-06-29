package com.ty.SmartHospitalManagementSystem.controller;

import com.ty.SmartHospitalManagementSystem.dto.request.BillingRequestDTO;
import com.ty.SmartHospitalManagementSystem.dto.response.BillingResponseDTO;
import com.ty.SmartHospitalManagementSystem.service.BillingService;
import com.ty.SmartHospitalManagementSystem.utility.ResponseStructure;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/billing")
public class BillingController {

    @Autowired
    private BillingService billingService;

    @PostMapping("/save")
    public ResponseEntity<ResponseStructure<BillingResponseDTO>> generateBill(@Valid @RequestBody BillingRequestDTO billing){
        return billingService.saveBill(billing);
    }
    @PutMapping("/update")
    public ResponseEntity<ResponseStructure<BillingResponseDTO>> updateBill(@Valid @RequestBody BillingRequestDTO billing){
        return billingService.updateBill(billing);
    }
    @GetMapping("/view/{id}")
    public ResponseEntity<ResponseStructure<BillingResponseDTO>> viewBill(@PathVariable int id){
        return billingService.findBill(id);
    }
    @GetMapping("/viewAll")
    public ResponseEntity<ResponseStructure<List<BillingResponseDTO>>> viewAllBills(){
        return billingService.findAllBills();
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseStructure<String>> deleteBill(@PathVariable int id){
        return billingService.deleteBill(id);
    }
}
