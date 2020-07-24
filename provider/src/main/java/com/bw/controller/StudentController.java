package com.bw.controller;

import com.bw.entity.MyPageImpl;
import com.bw.entity.Sport;
import com.bw.entity.Student;
import com.bw.entity.Levels;
import com.bw.service.StudentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Api("provide所提供的接口大全")
@RestController
public class StudentController {
    @Autowired
    StudentService userService;

    @RequestMapping("text")
    public MyPageImpl<Student> page(@RequestParam(defaultValue = "0") int pageNum, @RequestParam(defaultValue = "3")  int pageSize){
        return userService.lists(pageNum,pageSize);
    }

    @RequestMapping("list")
    public PageInfo<Student> list(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "3")  int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Student> list = userService.list();
        return new PageInfo<Student>(list);
    }
    @ApiOperation(value="用户列表的实现过程",notes="pagenum,pagesize,studnet对应着传过来的参数")
    @RequestMapping("lists")
    public PageInfo<Student> lists(@RequestParam(defaultValue = "0") int pageNum, @RequestParam(defaultValue = "3")  int pageSize, @RequestBody Student student){
       // System.err.println(student);
        Pageable pageable = PageRequest.of(pageNum,pageSize);
        return userService.lists(pageable,student);
    }
    @RequestMapping("add")
    public boolean add(@RequestBody Student student){
        return userService.add(student);
    }
    @RequestMapping("del")
    public boolean del(@RequestBody String sid){
        return userService.del(sid);
    }
    @RequestMapping("level")
    public List<Levels> listlve(){
        return userService.level();
    }
    @RequestMapping("sport")
    public List<Sport> sports(){
        return userService.sport();
    }
}
