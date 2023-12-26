package com.nbsaas.boot.ad.data.repository;

import com.nbsaas.boot.ad.data.entity.Ad;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import java.io.Serializable;

public interface AdRepository  extends  JpaRepositoryImplementation<Ad, Serializable>{

}