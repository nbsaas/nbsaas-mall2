package com.nbsaas.boot.ad.data.repository;

import com.nbsaas.boot.ad.data.entity.AdPosition;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import java.io.Serializable;

public interface AdPositionRepository  extends  JpaRepositoryImplementation<AdPosition, Serializable>{

}