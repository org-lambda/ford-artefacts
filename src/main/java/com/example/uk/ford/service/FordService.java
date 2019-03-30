package com.example.uk.ford.service;

import com.example.uk.ford.ExceptionHandler.FordException;
import com.example.uk.ford.Repository.StudentRepositoryInterface;
import com.example.uk.ford.data.StudentData;
import com.example.uk.ford.model.Student;
import org.hibernate.id.IdentifierGenerationException;
import org.modelmapper.MappingException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class FordService {

    //private StudentRepository studentRepository;
    private StudentRepositoryInterface studentRepository;
    private ModelMapper modelMapper;

    @Autowired
    public void FordService(StudentRepositoryInterface studentRepository, ModelMapper modelMapper){
        this.studentRepository = studentRepository;
        this.modelMapper = modelMapper;
    }

    public Student findById(long studentId) throws FordException{
        Optional<StudentData> student = null;
        try{
            student = studentRepository.findById(studentId);
        }catch (JpaSystemException | IdentifierGenerationException ex){
            throw new FordException(" Exception inside FordService.findById() " , ex);
        }
        if(!student.isPresent()){
            return null;
        }
        else{
            Student studentDetail = new Student();
            modelMapper.map(student.get(), studentDetail);
            return studentDetail;
        }

    }

    public List<Student> findAll() throws FordException{
        List<StudentData> allStudentDetails = null;
        try{
         allStudentDetails = studentRepository.findAll();
        }catch (JpaSystemException | IdentifierGenerationException ex){
            throw new FordException(" Exception inside FordService.findAll() " , ex);
        }
        List<Student> studentDetailsResp = new ArrayList<>();

        allStudentDetails.parallelStream()
                .forEach(eachStudentDetail -> {
                    Student student = new Student();
                    modelMapper.map(eachStudentDetail, student);
                    studentDetailsResp.add(student);
                });

        return studentDetailsResp;

    }


    public Student createOrUpdate(Student student) throws FordException{
        StudentData studentData = new StudentData();
        modelMapper.map(student, studentData);
        try {
            studentData = studentRepository.save(studentData);
            modelMapper.map(studentData, student);
        }catch (MappingException | JpaSystemException | IdentifierGenerationException ex){
            throw new FordException(" Exception inside FordService.createOrUpdate() " , ex);
        }
        return student;
    }


    public void delete(long studentId) throws FordException{
        try{
        studentRepository.deleteById(studentId);
        }catch (JpaSystemException | IdentifierGenerationException ex){
            throw new FordException(" Exception inside FordService.createOrUpdate() " , ex);
        }
    }

}
