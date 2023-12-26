package com.nbsaas.boot.talk.data.repository;

import com.nbsaas.boot.talk.data.entity.Talk;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import java.io.Serializable;

public interface TalkRepository  extends  JpaRepositoryImplementation<Talk, Serializable>{

}