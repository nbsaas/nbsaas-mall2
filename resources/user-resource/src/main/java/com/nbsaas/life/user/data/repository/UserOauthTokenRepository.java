package com.nbsaas.life.user.data.repository;

import com.nbsaas.life.user.data.entity.UserOauthToken;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import java.io.Serializable;

public interface UserOauthTokenRepository  extends  JpaRepositoryImplementation<UserOauthToken, Serializable>{

}