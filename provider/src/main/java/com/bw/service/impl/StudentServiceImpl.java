package com.bw.service.impl;

import com.bw.entity.Levels;
import com.bw.entity.MyPageImpl;
import com.bw.entity.Sport;
import com.bw.entity.Student;
import com.bw.response.LevelResponsity;
import com.bw.response.SportResponsity;
import com.bw.response.StudentResponsity;
import com.bw.service.StudentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentResponsity studentResponsity;
    @Autowired
    LevelResponsity levelResponsity;
    @Autowired
    SportResponsity sportResponsity;
    @Override
    public MyPageImpl<Student> lists(int pageNum, int pageSize) {
        Pageable pageable = PageRequest.of(pageNum,pageSize);
        PageImpl<Student> all = (PageImpl<Student>) studentResponsity.findAll(pageable);
        return new MyPageImpl<Student>(all);
    }

    @Override
    public List<Student> list() {
        return studentResponsity.findAll();
    }

    @Override
    public PageInfo<Student> lists(Pageable pageable,Student student) {
        Specification<Student> studentSpecification = new Specification<Student>() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> list=new ArrayList<Predicate>();
                if(student.getSname()!=null){
                    Predicate sname = criteriaBuilder.like(root.get("sname"), "%" + student.getSname() + "%");
                    list.add(sname);
                }
                if(student.getDate()!=null){
                   // Predicate date = criteriaBuilder.lessThan(root.get("date"),student.getDate());
                    Predicate date = criteriaBuilder.greaterThan(root.get("date"),student.getDate());
                    list.add(date);
                }
                Predicate[] predicates = list.toArray(new Predicate[list.size()]);
                Predicate and = criteriaBuilder.and(predicates);
                return and;
            }
        };
        Page<Student> all = studentResponsity.findAll(studentSpecification, pageable);
        PageInfo<Student> pageInfo = new PageInfo<Student>(all.getContent());
        pageInfo.setTotal(all.getTotalElements());
        pageInfo.setPageNum(all.getNumber());
        pageInfo.setPageSize(all.getSize());
        return pageInfo;
    }

    @Override
    public boolean add(Student student) {
        Student student1 = studentResponsity.saveAndFlush(student);
        if(student1.getSid()!=0){
            return true;
        }
        return false;
    }

    @Override
    public boolean del(String sid) {
        String[] split = sid.split(",");
        for (String s : split) {
            studentResponsity.deleteById(Integer.parseInt(s));
        }
        return true;
    }

    @Override
    public List<Levels> level() {
        return levelResponsity.findAll();
    }

    @Override
    public List<Sport> sport() {
        return sportResponsity.findAll();
    }

}
