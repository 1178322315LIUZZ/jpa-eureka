package com.bw.controller;

import com.bw.entity.MyPageImpl;
import com.bw.entity.Student;
import com.bw.service.StudentServices;
import com.github.pagehelper.PageInfo;
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
    @RequestMapping("tolist")
    public PageInfo<Student> tolist(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "3")  int pageSize){
        return studentServices.tolist(pageNum,pageSize);
    }
    @RequestMapping("pagelist")
    public PageInfo<Student> pagelist(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "3")  int pageSize){
        return studentServices.list(pageNum,pageSize);
    }

}
