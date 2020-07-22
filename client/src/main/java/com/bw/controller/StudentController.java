package com.bw.controller;

import com.bw.entity.MyPageImpl;
import com.bw.entity.Student;
import com.bw.service.StudentServices;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@CrossOrigin
public class StudentController {
    @Resource
    StudentServices studentServices;
    @RequestMapping("list")
    public MyPageImpl<Student> list(@RequestParam(defaultValue = "0") int pageNum, @RequestParam(defaultValue = "3")  int pageSize){
        return studentServices.lists(pageNum,pageSize);
    }

}
