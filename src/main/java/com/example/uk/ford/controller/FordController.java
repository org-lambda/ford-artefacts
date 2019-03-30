package com.example.uk.ford.controller;

import com.example.uk.ford.ExceptionHandler.FordException;
import com.example.uk.ford.model.FordResponse;
import com.example.uk.ford.model.Student;
import com.example.uk.ford.service.FordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
//@RequestMapping("/students")
@Api(value = "This is Ford Controller ", description = "The API demonstrates CRUD operation using MySql")
public class FordController {

    private FordService fordService;

    @Autowired
    public void FordController(FordService fordService){
        this.fordService = fordService;
    }

    @ApiOperation("Returns student details by Id")
    @ApiResponses(value = {@ApiResponse(code = 302, message = "Student retrieved Successfully"), @ApiResponse(code = 401, message = "Student is Unauthorized"), @ApiResponse(code = 403, message = "Application is Forbidden"), @ApiResponse(code = 404, message = "Resource is not found")})
    @GetMapping(value = "/retrieve/{studentid}")
    public ResponseEntity<FordResponse> retrieve(@PathVariable("studentid") long studentId) throws FordException{
        Student student = fordService.findById(studentId);
        FordResponse resp = new FordResponse();
        ResponseEntity responseEntity = null;
        if(student != null){
            resp.setStudent(student);
            responseEntity = new ResponseEntity(resp, HttpStatus.FOUND);
        }else{
            resp.setSuccessMsg("Student doesn't exists");
            responseEntity = new ResponseEntity(resp, HttpStatus.NOT_FOUND);
        }

        return responseEntity;
    }

    @ApiOperation("Returns all student details")
    @ApiResponses(value = {@ApiResponse(code = 302, message = "All students retrieved Successfully"), @ApiResponse(code = 401, message = "Student is Unauthorized"), @ApiResponse(code = 403, message = "Application is Forbidden"), @ApiResponse(code = 404, message = "Resource is not found")})
    @GetMapping(value = "/retrieve/")
    public ResponseEntity<FordResponse> retrieveAll() throws FordException{
        List<Student> student = fordService.findAll();
        FordResponse resp = new FordResponse();
        ResponseEntity responseEntity = null;
        if(student.size() > 0){
            resp.setStudentDetails(student);
            responseEntity = new ResponseEntity(resp, HttpStatus.FOUND);
        }
        else{
            resp.setSuccessMsg("No Student record available");
            responseEntity = new ResponseEntity(resp, HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

    @ApiOperation("Insert a student details")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "Student created Successfully"), @ApiResponse(code = 401, message = "Student is Unauthorized"), @ApiResponse(code = 403, message = "Application is Forbidden"), @ApiResponse(code = 404, message = "Resource is not found")})
    @PostMapping(value = "/addstudent/")
    public ResponseEntity<FordResponse> create(@RequestBody @Valid Student student, BindingResult result) throws FordException{
        FordResponse resp = new FordResponse();
        ResponseEntity responseEntity = null;
        if(result.hasErrors()){
            resp.setStudent(student);
            resp.setErrorMsg("Input details are not correct. Please provide correct data");
            responseEntity = new ResponseEntity(resp, HttpStatus.NOT_FOUND);
            return responseEntity;
        }
        student = fordService.createOrUpdate(student);
        resp.setSuccessMsg("Student created successfully");
        resp.setStudent(student);
        responseEntity = new ResponseEntity(resp, HttpStatus.CREATED);
        return responseEntity;
    }

    @ApiOperation("Update student details")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Student created Successfully"), @ApiResponse(code = 401, message = "Student is Unauthorized"), @ApiResponse(code = 403, message = "Application is Forbidden"), @ApiResponse(code = 404, message = "Resource is not found")})
    @PutMapping(value = "/update/{studentid}")
    public ResponseEntity<FordResponse> update(@PathVariable("studentid") long studentId, @RequestBody @Valid Student student, BindingResult result) throws FordException{
        FordResponse respUpdate = new FordResponse();
        ResponseEntity responseEntityUpdate = null;
        if(result.hasErrors()){
            respUpdate.setStudent(student);
            respUpdate.setErrorMsg("Update details are not correct. Please provide correct data");
            responseEntityUpdate = new ResponseEntity(respUpdate, HttpStatus.NOT_FOUND);
            return responseEntityUpdate;
        }
         Student studentDetails = fordService.findById(studentId);
         if(studentDetails != null){
             student = fordService.createOrUpdate(student);
             respUpdate.setSuccessMsg("Student updated successfully");
             respUpdate.setStudent(student);
             responseEntityUpdate = new ResponseEntity(respUpdate, HttpStatus.OK);
             return responseEntityUpdate;
         }

        responseEntityUpdate = new ResponseEntity(respUpdate, HttpStatus.NOT_FOUND);
        return responseEntityUpdate;
    }


    @ApiOperation("Delete a student details")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Student created Successfully"), @ApiResponse(code = 401, message = "Student is Unauthorized"), @ApiResponse(code = 403, message = "Application is Forbidden"), @ApiResponse(code = 404, message = "Resource is not found")})
    @DeleteMapping(value = "/delete/{studentid}")
    public ResponseEntity<FordResponse> delete(@PathVariable("studentid") long studentId) throws FordException {
        FordResponse respDelete = new FordResponse();
        fordService.delete(studentId);
        respDelete.setSuccessMsg("Student details deleted successfully for the id:: " + studentId);
        ResponseEntity responseEntityUpdate = new ResponseEntity(respDelete, HttpStatus.OK);
        return responseEntityUpdate;
    }

}
