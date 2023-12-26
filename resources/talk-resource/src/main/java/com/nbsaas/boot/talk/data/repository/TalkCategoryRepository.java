package com.nbsaas.boot.talk.data.repository;

import com.nbsaas.boot.talk.data.entity.TalkCategory;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import java.io.Serializable;

public interface TalkCategoryRepository  extends  JpaRepositoryImplementation<TalkCategory, Serializable>{

}