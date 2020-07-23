package com.bw.response;

import com.bw.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface StudentResponsity extends JpaRepository<Student,Integer>, JpaSpecificationExecutor<Student> {

}
