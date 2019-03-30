package com.example.uk.ford.Repository;

import com.example.uk.ford.data.StudentData;
import com.example.uk.ford.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//@Component
@Repository
public interface StudentRepositoryInterface extends JpaRepository<StudentData, Long> {

    Student findByStudentName(String studentName); // My customized method as per JPA convention

    Optional<Student> findByStudentRollGreaterThan(String studentRoll);  // My customized method as per JPA convention  https://www.youtube.com/watch?v=WTEGvLXxyOY

    @Query("from StudentData where standard=?1 order by studentName")  // My customized method as per JPA convention  https://www.youtube.com/watch?v=WTEGvLXxyOY
    Optional<Student> findAllByStandardSorted(String standard);

}
