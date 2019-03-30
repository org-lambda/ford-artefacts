package com.example.uk.ford.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    private long studentId;

    @NotEmpty
    @Size(min = 5, max = 30)
    private String studentName;

    @NotNull
    @Range(min = 1, max = 100)
    private int studentRoll;

    @NotEmpty
    @Size(min = 1, max = 20)
    private String standard;

    private String phone;

    @Email
    private String email;

}
