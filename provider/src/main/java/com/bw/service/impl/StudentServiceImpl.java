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
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
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

}
