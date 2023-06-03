package com.nbsaas.life.system.data.repository;

import com.nbsaas.life.system.data.entity.Dict;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import java.io.Serializable;

public interface DictRepository extends JpaRepositoryImplementation<Dict, Serializable> {

}