package com.nbsaas.life.system.data.repository;

import com.nbsaas.life.system.data.entity.Application;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import java.io.Serializable;

public interface ApplicationRepository  extends  JpaRepositoryImplementation<Application, Serializable>{

}