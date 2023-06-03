package com.nbsaas.life.system.data.repository;

import com.nbsaas.life.system.data.entity.DictItem;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import java.io.Serializable;

public interface DictItemRepository extends JpaRepositoryImplementation<DictItem, Serializable> {

}