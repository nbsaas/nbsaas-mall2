package com.nbsaas.life.user.data.repository;

import com.nbsaas.life.user.data.entity.UserPassword;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import java.io.Serializable;

public interface UserPasswordRepository  extends  JpaRepositoryImplementation<UserPassword, Serializable>{

}