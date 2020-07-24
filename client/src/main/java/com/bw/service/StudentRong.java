package com.bw.service;

import com.bw.entity.Levels;
import com.bw.entity.MyPageImpl;
import com.bw.entity.Sport;
import com.bw.entity.Student;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentRong implements StudentServices{
    @Override
    public MyPageImpl<Student> lists(int pageNum, int pageSize) {
        System.out.println("数据异常，请检查后在进行操作");
        return null;
    }

    @Override
    public PageInfo<Student> tolist(int pageNum, int pageSize) {
        System.out.println("数据异常，请检查后在进行操作");
        return null;
    }

    @Override
    public PageInfo<Student> list(int pageNum, int pageSize, Student student) {
        System.out.println("数据异常，请检查后在进行操作");
        return null;
    }

    @Override
    public boolean adds(Student student) {
        System.out.println("数据异常，请检查后在进行操作");
        return false;
    }

    @Override
    public boolean delete(String sid) {
        System.out.println("数据异常，请检查后在进行操作");
        return false;
    }

    @Override
    public List<Levels> level() {
        System.out.println("数据异常，请检查后在进行操作");
        return null;
    }

    @Override
    public List<Sport> sports() {
        System.out.println("数据异常，请检查后在进行操作");
        return null;
    }
}
