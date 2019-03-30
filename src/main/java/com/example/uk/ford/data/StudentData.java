package com.example.uk.ford.data;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "STUDENT")
public class StudentData extends ParentJPA{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "student_id")
    private long studentId;

    @Column(name = "student_name")
    private String studentName;

    @Column(name = "student_roll")
    private int studentRoll;

    @Column(name = "standard")
    private String standard;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

}
