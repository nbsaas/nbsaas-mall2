package com.nbsaas.boot.ad.data.repository;

import com.nbsaas.boot.chat.data.entity.GroupMessage;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import java.io.Serializable;

public interface GroupMessageRepository  extends  JpaRepositoryImplementation<GroupMessage, Serializable>{

}