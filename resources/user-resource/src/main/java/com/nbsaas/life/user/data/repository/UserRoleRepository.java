package com.nbsaas.life.user.data.repository;

import com.nbsaas.life.user.data.entity.UserRole;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import java.io.Serializable;

public interface UserRoleRepository  extends  JpaRepositoryImplementation<UserRole, Serializable>{

}