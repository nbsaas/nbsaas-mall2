package com.nbsaas.life.user.data.repository;

import com.nbsaas.life.user.data.entity.UserInfo;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import java.io.Serializable;

public interface UserInfoRepository  extends  JpaRepositoryImplementation<UserInfo, Serializable>{

}