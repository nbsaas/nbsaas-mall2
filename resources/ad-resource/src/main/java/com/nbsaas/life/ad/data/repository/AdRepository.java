package com.nbsaas.life.ad.data.repository;

import com.nbsaas.life.ad.data.entity.Ad;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import java.io.Serializable;

public interface AdRepository  extends  JpaRepositoryImplementation<Ad, Serializable>{

}