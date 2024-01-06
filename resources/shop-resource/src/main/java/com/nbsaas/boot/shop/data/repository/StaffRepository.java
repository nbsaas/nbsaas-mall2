package com.nbsaas.boot.shop.data.repository;

import com.nbsaas.boot.shop.data.entity.Staff;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import java.io.Serializable;

public interface StaffRepository  extends  JpaRepositoryImplementation<Staff, Serializable>{

}