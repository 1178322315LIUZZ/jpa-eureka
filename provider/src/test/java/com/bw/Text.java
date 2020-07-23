package com.bw;

import com.bw.entity.MyPageImpl;
import com.bw.entity.Student;
import com.bw.response.StudentResponsity;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class Text {
    @Autowired
    StudentResponsity studentResponsity;
    @Test
    public void text(){
        Pageable of = PageRequest.of(1, 3);
        Page<Student> all = studentResponsity.findAll(of);
        all.forEach(System.err::println);
        //System.out.println(all);
    }
    @Test
    public void text1(){
        Pageable pageable = PageRequest.of(1,3);
        PageImpl<Student> userPage = (PageImpl<Student>) studentResponsity.findAll(pageable);
        MyPageImpl<Student> sss=new MyPageImpl<Student>(userPage);
        System.out.println(sss);
    }
    @Test
    public void text2(){
        Pageable pageable = PageRequest.of(1,3);
        Page<Student> all = studentResponsity.findAll(pageable);
        long totalElements = all.getTotalElements();
        System.err.println(totalElements);
        List<Student> content = all.getContent();
        PageInfo<Student> page=new PageInfo<Student>(content);
        page.setTotal(totalElements);
        System.out.println(page);
        List<Student> list = page.getList();
        list.forEach(System.err::println);
    }
    @Test
    public void text6(){
        Student student = new Student();
        student.setSname("张");
        student.setSex("女");
        ExampleMatcher sname = ExampleMatcher.matching()
                .withMatcher("sname", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("sex", ExampleMatcher.GenericPropertyMatchers.contains());
        Example<Student> of = Example.of(student, sname);
        List<Student> all = studentResponsity.findAll(of);
        all.forEach(System.err::println);
    }
    @Test
    public void text4(){
        Pageable pageable = PageRequest.of(1,1);
        Student student=new Student();
        student.setSname("张");
        Specification specification=new Specification<Student>(){
            @Override
            public Predicate toPredicate(Root<Student> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
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
        Page<Student> all = studentResponsity.findAll(specification, pageable);
        System.err.println(all.getTotalElements());
        System.err.println(all.getNumber());
        System.err.println(all.getSize());
        all.getContent().forEach(System.err::println);
    }
    @Test
    public void text7(){
        Pageable pageable = PageRequest.of(0,3);
        Student student=new Student();
        student.setSname("张");
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
        //all.getContent().forEach(System.err::println);
        PageInfo<Student> pageInfo = new PageInfo<Student>(all.getContent());
        pageInfo.setTotal(all.getTotalElements());
        pageInfo.setPageNum(all.getNumber());
        pageInfo.setPageSize(all.getSize());
        pageInfo.getList().forEach(System.err::println);
    }
}
