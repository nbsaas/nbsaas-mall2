package com.nbsaas.life.user.data.repository;

import com.nbsaas.life.user.data.entity.UserLoginLog;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import java.io.Serializable;

public interface UserLoginLogRepository  extends  JpaRepositoryImplementation<UserLoginLog, Serializable>{

}