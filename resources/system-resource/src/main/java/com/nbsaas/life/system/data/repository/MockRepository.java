package com.nbsaas.life.system.data.repository;

import com.nbsaas.life.system.data.entity.Mock;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import java.io.Serializable;

public interface MockRepository  extends  JpaRepositoryImplementation<Mock, Serializable>{

}