package com.bw.response;

import com.bw.entity.Student;
import org.hibernate.query.NativeQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentResponsity extends JpaRepository<Student,Integer> {
    @Query(value="SELECT * FROM student", nativeQuery=true)
    List<Student> list();
}
