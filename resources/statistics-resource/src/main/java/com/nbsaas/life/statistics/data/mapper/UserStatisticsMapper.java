package com.nbsaas.life.statistics.data.mapper;

import com.nbsaas.life.statistics.api.domain.simple.LabelNum;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserStatisticsMapper {

    Long today();

    Long month();


    Long week();


    Long total();

    List<LabelNum> year(@Param("yearDate") String year);


    List<LabelNum> lastYear();

}
