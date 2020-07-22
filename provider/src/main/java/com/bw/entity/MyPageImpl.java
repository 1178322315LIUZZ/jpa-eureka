package com.bw.entity;

import lombok.Data;
import org.springframework.data.domain.PageImpl;

import java.util.List;

@Data
public class MyPageImpl<T> {

    private  long lotalElements=0;
    private  List<T> content=null;
    private  int totalPages=0;
    private  int pageNum=0;
    private  int pageSize=0;

    public MyPageImpl(PageImpl<T> pil) {
        lotalElements = pil.getTotalElements();
        content =pil.getContent();
        totalPages =pil.getTotalPages();
        pageNum =pil.getNumber();
        pageSize = pil.getSize();
    }

    public MyPageImpl() {

    }



}
