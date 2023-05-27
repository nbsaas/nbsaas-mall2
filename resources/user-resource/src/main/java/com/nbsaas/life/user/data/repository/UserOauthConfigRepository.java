package com.nbsaas.life.user.data.repository;

import com.nbsaas.life.user.data.entity.UserOauthConfig;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import java.io.Serializable;

public interface UserOauthConfigRepository  extends  JpaRepositoryImplementation<UserOauthConfig, Serializable>{

}