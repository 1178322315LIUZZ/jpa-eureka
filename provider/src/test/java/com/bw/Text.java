package com.bw;

import com.bw.entity.MyPageImpl;
import com.bw.entity.Student;
import com.bw.response.StudentResponsity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

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
}
