package com.example.uk.ford;

import com.example.uk.ford.model.Student;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class Test {

    public static void main(String[] args) throws Exception {

        // Create ObjectMapper
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        Student student = new Student();
        student.setStudentId(1);
        student.setStudentName("Soumojit Acharyya");
        student.setStandard("Java Developer");
        student.setEmail("acharyyasoumojit@gmail.com");
        student.setPhone("919830579752");

        // Convert object to JSON string
        String json = mapper.writeValueAsString(student);
        System.out.println(json);

        // Save JSON string to file
       /* FileOutputStream fileOutputStream = new FileOutputStream("employee.json");
        mapper.writeValue(fileOutputStream, employee);
        fileOutputStream.close();*/
    }
}
