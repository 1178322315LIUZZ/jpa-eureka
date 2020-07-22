package com.bw.service;

import com.bw.entity.MyPageImpl;
import com.bw.entity.Student;
import com.github.pagehelper.PageInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "provider",fallback = StudentRong.class)
public interface StudentServices {
    @RequestMapping("/text")
    public MyPageImpl<Student> lists(@RequestParam(defaultValue = "0") int pageNum, @RequestParam(defaultValue = "3")  int pageSize);
    @RequestMapping("/list")
    PageInfo<Student> tolist(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "3")  int pageSize);
}
