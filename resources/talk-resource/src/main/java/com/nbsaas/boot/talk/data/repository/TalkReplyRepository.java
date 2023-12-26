package com.nbsaas.boot.talk.data.repository;

import com.nbsaas.boot.talk.data.entity.TalkReply;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import java.io.Serializable;

public interface TalkReplyRepository  extends  JpaRepositoryImplementation<TalkReply, Serializable>{

}