package com.nbsaas.boot.ad.data.repository;

import com.nbsaas.boot.chat.data.entity.GroupRoom;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import java.io.Serializable;

public interface GroupRoomRepository  extends  JpaRepositoryImplementation<GroupRoom, Serializable>{

}