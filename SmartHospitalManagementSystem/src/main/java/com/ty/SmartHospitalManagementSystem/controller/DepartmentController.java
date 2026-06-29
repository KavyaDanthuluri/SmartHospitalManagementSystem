package com.ty.SmartHospitalManagementSystem.controller;

import com.ty.SmartHospitalManagementSystem.dto.request.DepartmentRequestDTO;
import com.ty.SmartHospitalManagementSystem.dto.response.DepartmentResponseDTO;
import com.ty.SmartHospitalManagementSystem.exception.ResourceAlreadyExistsException;
import com.ty.SmartHospitalManagementSystem.repository.DepartmentRepository;
import com.ty.SmartHospitalManagementSystem.service.DepartmentService;
import com.ty.SmartHospitalManagementSystem.utility.ResponseStructure;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private DepartmentRepository departmentRepository;

    @PostMapping("/save")
    public ResponseEntity<ResponseStructure<DepartmentResponseDTO>> addDepartment(@Valid @RequestBody DepartmentRequestDTO department) throws ResourceAlreadyExistsException {
        return departmentService.saveDepartment(department);
    }
    @PostMapping("/saveAll")
    public ResponseEntity<ResponseStructure<List<DepartmentResponseDTO>>> addAllDepartments(@Valid @RequestBody List<DepartmentRequestDTO> departments) throws ResourceAlreadyExistsException{
        return departmentService.saveAllDepartments(departments);
    }
    @GetMapping("/viewAll")
    public ResponseEntity<ResponseStructure<List<DepartmentResponseDTO>>> viewAllDepartments(){
        return departmentService.findAllDepartments();
    }
    @GetMapping("/view/{id}")
    public ResponseEntity<ResponseStructure<DepartmentResponseDTO>> viewDepartment(@PathVariable int id){
        return departmentService.findDepartment(id);
    }
    @PutMapping("/update")
    public ResponseEntity<ResponseStructure<DepartmentResponseDTO>> updateDepartment(@Valid @RequestBody DepartmentRequestDTO department) throws ResourceAlreadyExistsException{
        return departmentService.updateDepartment(department);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseStructure<String>> deleteDepartment(@PathVariable int id){
        return departmentService.deleteDepartment(id);
    }

}
