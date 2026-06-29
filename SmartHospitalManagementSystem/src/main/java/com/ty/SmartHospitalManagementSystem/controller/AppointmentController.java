package com.ty.SmartHospitalManagementSystem.controller;

import com.ty.SmartHospitalManagementSystem.service.AppointmentService;
import com.ty.SmartHospitalManagementSystem.dto.request.AppointmentRequestDTO;
import com.ty.SmartHospitalManagementSystem.dto.response.AppointmentResponseDTO;
import com.ty.SmartHospitalManagementSystem.utility.ResponseStructure;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping("/save")
    public ResponseEntity<ResponseStructure<AppointmentResponseDTO>> bookAppointment(@Valid @RequestBody AppointmentRequestDTO appointmentRequest)  {
        appointmentRequest.setAppointmentDate(LocalDate.now());
        appointmentRequest.setAppointmentTime(LocalTime.now());
        return appointmentService.saveAppointment(appointmentRequest);
    }
    @PostMapping("/saveAll")
    public ResponseEntity<ResponseStructure<List<AppointmentResponseDTO>>> bookAllAppointments(@Valid @RequestBody List<AppointmentRequestDTO> appointments){
        for (AppointmentRequestDTO appointment : appointments) {
            appointment.setAppointmentDate(LocalDate.now());
            appointment.setAppointmentTime(LocalTime.now());
        }
        return appointmentService.saveAllAppointments(appointments);
    }
    @GetMapping("/viewById/{id}")
    public ResponseEntity<ResponseStructure<AppointmentResponseDTO>> viewAppointment(@PathVariable int id){
        return appointmentService.findAppointment(id);
    }
    @GetMapping("/viewAll")
    public ResponseEntity<ResponseStructure<List<AppointmentResponseDTO>>> viewAllAppointments(){
        return appointmentService.findAllAppointments();
    }
    @PutMapping("/update")
    public ResponseEntity<ResponseStructure<AppointmentResponseDTO>> updateAppointment(@Valid @RequestBody AppointmentRequestDTO appointment){
        appointment.setAppointmentDate(LocalDate.now());
        appointment.setAppointmentTime(LocalTime.now());
        return appointmentService.updateAppointment(appointment);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseStructure<String>> deleteAppointment(@PathVariable int id){
        return appointmentService.deleteAppointment(id);
    }
    @GetMapping("/viewByDoctor/{doctorId}")
    public ResponseEntity<ResponseStructure<List<AppointmentResponseDTO>>> viewByDoctor(@PathVariable int doctorId){
        return appointmentService.findByDoctor(doctorId);
    }
    @GetMapping("/viewByPatient/{patientId}")
    public ResponseEntity<ResponseStructure<List<AppointmentResponseDTO>>> viewByPatient(@PathVariable int patientId){
        return appointmentService.findByPatient(patientId);
    }
}
