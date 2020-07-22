package com.bw.controller;

import com.bw.entity.MyPageImpl;
import com.bw.entity.Student;
import com.bw.response.StudentResponsity;
import com.bw.service.StudentService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    @Autowired
    StudentService userService;

    @RequestMapping("text")
    public MyPageImpl<Student> page(@RequestParam(defaultValue = "0") int pageNum, @RequestParam(defaultValue = "3")  int pageSize){
        return userService.lists(pageNum,pageSize);
    }
    @RequestMapping("list")
    public PageInfo<Student> list(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "3")  int pageSize){
        Pageable pageable = PageRequest.of(pageNum,pageSize);
        return new PageInfo<Student>(userService.list(pageable));
    }
}
