package com.bw.response;

import com.bw.entity.Levels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface LevelResponsity extends JpaRepository<Levels,Integer>, JpaSpecificationExecutor<Levels> {

}
