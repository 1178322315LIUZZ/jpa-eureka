package com.bw.service;

import com.bw.entity.MyPageImpl;
import com.bw.entity.Student;
import com.github.pagehelper.PageInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "provider",fallback = StudentRong.class)
public interface StudentServices {
    @RequestMapping("/text")
    public MyPageImpl<Student> lists(@RequestParam(defaultValue = "0") int pageNum, @RequestParam(defaultValue = "3")  int pageSize);
    @RequestMapping("/list")
    PageInfo<Student> tolist(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "3")  int pageSize);
    @RequestMapping("/lists")
    PageInfo<Student> list(@RequestParam(defaultValue = "0") int pageNum, @RequestParam(defaultValue = "3") int pageSize, Student student);
    @RequestMapping("/add")
    boolean adds(Student student);
    @RequestMapping("/del")
    boolean delete(String sid);











}
