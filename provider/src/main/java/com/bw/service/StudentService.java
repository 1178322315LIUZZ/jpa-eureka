package com.bw.service;

import com.bw.entity.MyPageImpl;
import com.bw.entity.Student;
import com.github.pagehelper.PageInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface StudentService {

    MyPageImpl<Student> lists(int pageNum, int pageSize);
}