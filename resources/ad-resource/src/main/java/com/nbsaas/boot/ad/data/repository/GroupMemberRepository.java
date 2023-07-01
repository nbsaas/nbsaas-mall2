package com.nbsaas.boot.ad.data.repository;

import com.nbsaas.boot.chat.data.entity.GroupMember;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import java.io.Serializable;

public interface GroupMemberRepository  extends  JpaRepositoryImplementation<GroupMember, Serializable>{

}