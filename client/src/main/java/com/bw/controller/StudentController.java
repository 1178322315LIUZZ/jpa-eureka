package com.bw.controller;

import com.bw.entity.MyPageImpl;
import com.bw.entity.Student;
import com.bw.service.StudentServices;
import com.github.pagehelper.PageInfo;
import com.starter.upload.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

@RestController
@CrossOrigin
public class StudentController {
    @Resource
    StudentServices studentServices;
    @Autowired
    UploadService uploadService;
    @RequestMapping("list")
    public MyPageImpl<Student> list(@RequestParam(defaultValue = "0") int pageNum, @RequestParam(defaultValue = "3")  int pageSize){
        return studentServices.lists(pageNum,pageSize);
    }
    @RequestMapping("tolist")
    public PageInfo<Student> tolist(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "3")  int pageSize){
        return studentServices.tolist(pageNum,pageSize);
    }
    @RequestMapping("pagelist")
    public PageInfo<Student> pagelist(@RequestParam(defaultValue = "0") int pageNum, @RequestParam(defaultValue = "3")  int pageSize,Student student){
       // System.err.println(student);
        return studentServices.list(pageNum,pageSize,student);
    }
    @RequestMapping("upload")
    public String upload(MultipartFile file) throws Exception {
        return "http://localhost:8001/img/"+uploadService.upload(file);
    }
    @RequestMapping("toadd")
    public Boolean toadd(@RequestBody Student student){
        return studentServices.adds(student);
    }
    @RequestMapping("delete")
    public boolean delete(String sid){
        return studentServices.delete(sid);
    }
}
