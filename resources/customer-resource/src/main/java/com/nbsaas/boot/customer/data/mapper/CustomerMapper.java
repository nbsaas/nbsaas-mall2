package com.nbsaas.boot.customer.data.mapper;

import com.nbsaas.boot.common.ext.domain.simple.CountSimple;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CustomerMapper {

    /**
     * 最近12个月的客户数量
     * @return
     */
    List<CountSimple> countByRecent12Month();

    List<CountSimple> countByYear(@Param("year") Integer year);

}
