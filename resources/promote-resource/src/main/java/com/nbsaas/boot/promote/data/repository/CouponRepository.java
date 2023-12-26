package com.nbsaas.boot.promote.data.repository;

import com.nbsaas.boot.promote.data.entity.Coupon;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import java.io.Serializable;

public interface CouponRepository  extends  JpaRepositoryImplementation<Coupon, Serializable>{

}