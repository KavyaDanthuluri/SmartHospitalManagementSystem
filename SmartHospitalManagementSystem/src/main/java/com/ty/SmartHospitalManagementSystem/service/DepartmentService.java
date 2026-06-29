package com.ty.SmartHospitalManagementSystem.service;

import com.ty.SmartHospitalManagementSystem.dto.request.DepartmentRequestDTO;
import com.ty.SmartHospitalManagementSystem.dto.response.DepartmentResponseDTO;
import com.ty.SmartHospitalManagementSystem.entity.Department;
import com.ty.SmartHospitalManagementSystem.exception.ResourceAlreadyExistsException;
import com.ty.SmartHospitalManagementSystem.exception.ResourceNotFoundException;
import com.ty.SmartHospitalManagementSystem.repository.DepartmentRepository;
import com.ty.SmartHospitalManagementSystem.utility.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    //Save a department
    public ResponseEntity<ResponseStructure<DepartmentResponseDTO>> saveDepartment(DepartmentRequestDTO department) throws ResourceAlreadyExistsException{
        Department department1=new Department();
        department1.setId(department.getId());
        if(!(departmentRepository.existsByDepartmentName(department.getDepartmentName()))) {
            department1.setDepartmentName(department.getDepartmentName());
        }
        else{
            throw new ResourceAlreadyExistsException("Department already exists");
        }
        department1.setDescription(department.getDescription());
        Department savedDepartment = departmentRepository.save(department1);
        return mapToResponseDTO(savedDepartment);
    }

    public ResponseEntity<ResponseStructure<DepartmentResponseDTO>> mapToResponseDTO(Department savedDepartment) {
        DepartmentResponseDTO departmentResponseDTO = new DepartmentResponseDTO();
        departmentResponseDTO.setId(savedDepartment.getId());
        departmentResponseDTO.setDepartmentName(savedDepartment.getDepartmentName());
        departmentResponseDTO.setDescription(savedDepartment.getDescription());
        ResponseStructure<DepartmentResponseDTO> rs= new ResponseStructure<>();
        rs.setMessage("Success");
        rs.setStatusCode(HttpStatus.OK.value());
        rs.setData(departmentResponseDTO);
        return new ResponseEntity<ResponseStructure<DepartmentResponseDTO>>(rs, HttpStatus.OK);
    }

    //Update a department
    public ResponseEntity<ResponseStructure<DepartmentResponseDTO>> updateDepartment(DepartmentRequestDTO department) throws ResourceAlreadyExistsException{
        Department department1=new Department();
        department1.setId(department.getId());
        if(!(departmentRepository.existsByDepartmentName(department.getDepartmentName()))) {
            department1.setDepartmentName(department.getDepartmentName());
        }
        else{
            throw new ResourceAlreadyExistsException("Department already exists");
        }
        department1.setDescription(department.getDescription());
        Department savedDepartment = departmentRepository.save(department1);
        return mapToResponseDTO(savedDepartment);
    }

    //Delete department by id
    public ResponseEntity<ResponseStructure<String>> deleteDepartment(int id){
        ResponseStructure<String> rs= new ResponseStructure<>();
        Optional<Department> optional = departmentRepository.findById(id);
        if(optional.isPresent()){
            rs.setStatusCode(HttpStatus.OK.value());
            rs.setMessage("Deleted");
            departmentRepository.deleteById(id);
            rs.setData( "Deleted Succesfully");
        }
        else
            throw new ResourceNotFoundException("Department with id "+id+" not found");
        return new ResponseEntity<ResponseStructure<String>>(rs,HttpStatus.OK);
    }

    //Fetch department by id
    public ResponseEntity<ResponseStructure<DepartmentResponseDTO>> findDepartment(int id){
        Optional<Department> department=departmentRepository.findById(id);
        if(department.isPresent()) {
            return mapToResponseDTO(department.get());
        }
        else {
            throw new ResourceNotFoundException("Department with id " + id + " not found");
        }
    }

    //Find all departments
    public ResponseEntity<ResponseStructure<List<DepartmentResponseDTO>>> findAllDepartments(){
        List<Department> departments= departmentRepository.findAll();
        return mapToResponseDTOList(departments);
    }

    public ResponseEntity<ResponseStructure<List<DepartmentResponseDTO>>> mapToResponseDTOList(List<Department> dtos){
        List<DepartmentResponseDTO> list = new ArrayList<>();
        for(Department d:dtos){
            DepartmentResponseDTO dto = new DepartmentResponseDTO();
            dto.setId(d.getId());
            dto.setDepartmentName(d.getDepartmentName());
            dto.setDescription(d.getDescription());
            list.add(dto);
        }
        ResponseStructure<List<DepartmentResponseDTO>> rs=new ResponseStructure<>();
        rs.setStatusCode(HttpStatus.OK.value());
        rs.setMessage("Success");
        rs.setData(list);
        return new ResponseEntity<ResponseStructure<List<DepartmentResponseDTO>>>(rs,HttpStatus.OK);
    }
    //Save all departments
    public ResponseEntity<ResponseStructure<List<DepartmentResponseDTO>>> saveAllDepartments(List<DepartmentRequestDTO> departments) throws ResourceAlreadyExistsException{
        List<Department> departments1=new ArrayList<>();
        for(DepartmentRequestDTO dto : departments){
            Department d = new Department();
            d.setId(dto.getId());
            d.setDescription(dto.getDescription());
            if(!(departmentRepository.existsByDepartmentName(dto.getDepartmentName()))) {
                d.setDepartmentName(dto.getDepartmentName());
            }
            else{
                throw new ResourceAlreadyExistsException("Department already exists");
            }
            d.setDepartmentName(dto.getDepartmentName());
            departments1.add(d);
        }
        List<Department> savedDepartments = departmentRepository.saveAll(departments1);
        return mapToResponseDTOList(departments1);
    }
}
