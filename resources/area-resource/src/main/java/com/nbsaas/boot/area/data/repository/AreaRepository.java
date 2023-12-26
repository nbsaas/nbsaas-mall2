package com.nbsaas.boot.area.data.repository;

import com.nbsaas.boot.area.data.entity.Area;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import java.io.Serializable;

public interface AreaRepository  extends  JpaRepositoryImplementation<Area, Serializable>{

}