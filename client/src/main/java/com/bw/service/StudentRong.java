package com.bw.service;

import com.bw.entity.MyPageImpl;
import com.bw.entity.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentRong implements StudentServices{
    @Override
    public MyPageImpl<Student> lists(int pageNum, int pageSize) {
        System.out.println("数据异常，请检查后在进行操作");
        return null;
    }
}