package com.nbsaas.life.area.data.repository;

import com.nbsaas.life.area.data.entity.Area;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import java.io.Serializable;

public interface AreaRepository  extends  JpaRepositoryImplementation<Area, Serializable>{

}