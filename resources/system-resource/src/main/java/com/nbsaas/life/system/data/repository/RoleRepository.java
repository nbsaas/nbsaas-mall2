package com.nbsaas.life.system.data.repository;

import com.nbsaas.life.system.data.entity.Role;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import java.io.Serializable;

public interface RoleRepository  extends  JpaRepositoryImplementation<Role, Serializable>{

}