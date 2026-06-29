package com.ty.SmartHospitalManagementSystem.service;

import com.ty.SmartHospitalManagementSystem.entity.Appointment;
import com.ty.SmartHospitalManagementSystem.entity.Doctor;
import com.ty.SmartHospitalManagementSystem.entity.Patient;
import com.ty.SmartHospitalManagementSystem.exception.ResourceNotFoundException;
import com.ty.SmartHospitalManagementSystem.repository.AppointmentRepository;
import com.ty.SmartHospitalManagementSystem.dto.request.AppointmentRequestDTO;
import com.ty.SmartHospitalManagementSystem.dto.response.AppointmentResponseDTO;
import com.ty.SmartHospitalManagementSystem.repository.DoctorRepository;
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
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PatientRepository patientRepository;

    //Save Appointment
    public ResponseEntity<ResponseStructure<AppointmentResponseDTO>> saveAppointment(AppointmentRequestDTO appointment) {
        //Creating appointment entity object and saving inside the database
        Optional<Doctor> doctor=doctorRepository.findById(appointment.getDoctorId());
        Optional<Patient> patient=patientRepository.findById(appointment.getPatientId());
        Appointment appointment1=new Appointment();
        appointment1.setId(appointment.getId());
        appointment1.setAppointmentTime(appointment.getAppointmentTime());
        appointment1.setAppointmentDate(appointment.getAppointmentDate());
        appointment1.setStatus(appointment.getStatus());
        if(doctor.isPresent()) {
            appointment1.setDoctor(doctor.get());
        }
        else{
            throw new ResourceNotFoundException("Doctor with id "+appointment.getDoctorId()+" not found");
        }
        if(patient.isPresent()) {
            appointment1.setPatient(patient.get());
        }
        else{
            throw new ResourceNotFoundException("Patient with id "+appointment.getPatientId()+" not found");
        }
        //Saving inside the database
        Appointment appointment2=appointmentRepository.save(appointment1);
        //Converting entity into responseDTO
        return mapToResponseDTO(appointment2);
    }
    //Save All Appointments
    public ResponseEntity<ResponseStructure<List<AppointmentResponseDTO>>> saveAllAppointments(List<AppointmentRequestDTO> appointments){
       //Creating list of appointment object
        List<Appointment> aa=new ArrayList<>();
        for(AppointmentRequestDTO a : appointments){
            Optional<Doctor> doctor= doctorRepository.findById(a.getDoctorId());
            Optional<Patient> patient=patientRepository.findById(a.getPatientId());
            Appointment a1=new Appointment();
            a1.setId(a.getId());
            a1.setAppointmentTime(a.getAppointmentTime());
            a1.setAppointmentDate(a.getAppointmentDate());
            a1.setStatus(a.getStatus());
            if(doctor.isPresent()) {
                a1.setDoctor(doctor.get());
            }
            else{
                throw new ResourceNotFoundException("Doctor with id "+a.getDoctorId()+" not found");
            }
            if(patient.isPresent()) {
                a1.setPatient(patient.get());
            }
            else{
                throw new ResourceNotFoundException("Patient with id "+a.getPatientId()+" not found");
            }
            aa.add(a1);
        }
        //Saving list of appointment objects
       List<Appointment> appointmentList= appointmentRepository.saveAll(aa);
        //Converting list of entity into reponseDTO
       return mapToResponseList(appointmentList);
    }
    //Upadte Appointment
    public ResponseEntity<ResponseStructure<AppointmentResponseDTO>> updateAppointment(AppointmentRequestDTO appointment){
        Appointment a=new Appointment();
        if(appointmentRepository.existsById(appointment.getId())) {
            a.setId(appointment.getId());
            a.setAppointmentTime(appointment.getAppointmentTime());
            a.setAppointmentDate(appointment.getAppointmentDate());
            a.setStatus(appointment.getStatus());
            Optional<Doctor> doctor=doctorRepository.findById(appointment.getDoctorId());
            if(doctor.isPresent()) {
                a.setDoctor(doctor.get());
            }
            else{
                throw new ResourceNotFoundException("Doctor with id "+appointment.getDoctorId()+"not found");
            }
            Optional<Patient> patient=patientRepository.findById(appointment.getPatientId());
            if(patient.isPresent()) {
                a.setPatient(patient.get());
            }
            else{
                throw new ResourceNotFoundException("Patient with id "+appointment.getPatientId()+" not found");
            }
        }
        else{
            throw new ResourceNotFoundException("Appointment with id "+appointment.getId()+" not found");
        }
        Appointment saved=appointmentRepository.save(a);
        return mapToResponseDTO(saved);
    }
    //Delete Appointment by id
    public ResponseEntity<ResponseStructure<String>> deleteAppointment(int id){
        Optional<Appointment> optional = appointmentRepository.findById(id);
        ResponseStructure<String> rs=new ResponseStructure<>();
        if(optional.isPresent()) {
            rs.setStatusCode(HttpStatus.OK.value());
            rs.setMessage("Deleted");
            appointmentRepository.deleteById(id);
            rs.setData("Appointment Deleted Succesfully");
        }
        else {
            throw new ResourceNotFoundException("Appointment with id " + id + " not found");
        }
        return new ResponseEntity<ResponseStructure<String>>(rs,HttpStatus.OK);
    }
    //Find Appointment by Id
    public ResponseEntity<ResponseStructure<AppointmentResponseDTO>> findAppointment(int id){
        Optional<Appointment> a = appointmentRepository.findById(id);
        if(a.isPresent()) {
            return mapToResponseDTO(a.get());
        }
        else{
            throw new ResourceNotFoundException("Appointment with id "+id+" not found");
        }
    }
    //Find All Appointments
    public ResponseEntity<ResponseStructure<List<AppointmentResponseDTO>>> findAllAppointments(){
        List<Appointment> list= appointmentRepository.findAll();
        return mapToResponseList(list);
    }
    //Find by doctor id
    public ResponseEntity<ResponseStructure<List<AppointmentResponseDTO>>> findByDoctor(int id){
        List<Appointment> appointment=appointmentRepository.findByDoctorId(id);
        if(!(appointment.isEmpty())) {
            return mapToResponseList(appointment);
        }
        else{
            throw new ResourceNotFoundException("Doctor with id "+id+" not found");
        }
    }
    //Find by patient id
    public ResponseEntity<ResponseStructure<List<AppointmentResponseDTO>>> findByPatient(int id){
        List<Appointment> a=appointmentRepository.findByPatientId(id);
        if(!(a.isEmpty())) {
            return mapToResponseList(a);
        }
        else{
            throw new ResourceNotFoundException("Patient with id "+id+" not found");
        }
    }
    //Entity object to ResponseStructure Object
    public ResponseEntity<ResponseStructure<AppointmentResponseDTO>> mapToResponseDTO(Appointment appointment){
        AppointmentResponseDTO appointmentResponseDTO = new AppointmentResponseDTO();
        appointmentResponseDTO.setAppointmentTime(appointment.getAppointmentTime());
        appointmentResponseDTO.setAppointmentDate(appointment.getAppointmentDate());
        appointmentResponseDTO.setStatus(appointment.getStatus());
        appointmentResponseDTO.setDoctorId(appointment.getDoctor().getId());
        appointmentResponseDTO.setPatientId(appointment.getPatient().getId());
        ResponseStructure<AppointmentResponseDTO> rs = new ResponseStructure<>();
        rs.setStatusCode(HttpStatus.OK.value());
        rs.setMessage("Successfully Saved");
        rs.setData(appointmentResponseDTO);
        return new ResponseEntity<ResponseStructure<AppointmentResponseDTO>>(rs,HttpStatus.OK);
    }
    //List of entity object to responseStructure object
    public ResponseEntity<ResponseStructure<List<AppointmentResponseDTO>>> mapToResponseList(List<Appointment> appointmentList) {
        List<AppointmentResponseDTO> dtos=new ArrayList<>();
        for(Appointment a:appointmentList) {
            AppointmentResponseDTO appointmentResponseDTO = new AppointmentResponseDTO();
            appointmentResponseDTO.setAppointmentTime(a.getAppointmentTime());
            appointmentResponseDTO.setAppointmentDate(a.getAppointmentDate());
            appointmentResponseDTO.setStatus(a.getStatus());
            appointmentResponseDTO.setDoctorId(a.getDoctor().getId());
            appointmentResponseDTO.setPatientId(a.getPatient().getId());
            dtos.add(appointmentResponseDTO);
        }
        ResponseStructure<List<AppointmentResponseDTO>> rs = new ResponseStructure<>();
        rs.setStatusCode(HttpStatus.OK.value());
        rs.setMessage("Successfully Saved");
        rs.setData(dtos);
        return new ResponseEntity<ResponseStructure<List<AppointmentResponseDTO>>>(rs,HttpStatus.OK);
    }
}
