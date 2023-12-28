package com.nbsaas.boot.common.data.repository;

import com.nbsaas.boot.common.data.entity.SequenceTable;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import java.io.Serializable;

public interface SequenceTableRepository  extends  JpaRepositoryImplementation<SequenceTable, Serializable>{

}