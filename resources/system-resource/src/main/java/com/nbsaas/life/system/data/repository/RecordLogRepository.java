package com.nbsaas.life.system.data.repository;

import com.nbsaas.life.system.data.entity.RecordLog;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import java.io.Serializable;

public interface RecordLogRepository  extends  JpaRepositoryImplementation<RecordLog, Serializable>{

}