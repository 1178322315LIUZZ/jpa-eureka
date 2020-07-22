package com.bw.service.impl;

import com.bw.entity.MyPageImpl;
import com.bw.entity.Student;
import com.bw.response.StudentResponsity;
import com.bw.service.StudentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentResponsity studentResponsity;

    @Override
    public MyPageImpl<Student> lists(int pageNum, int pageSize) {
        Pageable pageable = PageRequest.of(pageNum,pageSize);
        PageImpl<Student> all = (PageImpl<Student>) studentResponsity.findAll(pageable);
        return new MyPageImpl<Student>(all);
    }

    @Override
    public List<Student> list(Pageable pageable) {
        return studentResponsity.findAll(pageable).getContent();
    }
}
