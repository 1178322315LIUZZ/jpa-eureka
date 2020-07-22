package com.bw.service;

import com.bw.entity.MyPageImpl;
import com.bw.entity.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "provider",fallback = StudentRong.class)
public interface StudentServices {
    @RequestMapping("/text")
    public MyPageImpl<Student> lists(@RequestParam(defaultValue = "0") int pageNum, @RequestParam(defaultValue = "3")  int pageSize);
}
