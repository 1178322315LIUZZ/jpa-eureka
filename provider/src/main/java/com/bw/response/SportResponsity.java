package com.bw.response;

import com.bw.entity.Levels;
import com.bw.entity.Sport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SportResponsity extends JpaRepository<Sport,Integer>, JpaSpecificationExecutor<Sport> {

}
