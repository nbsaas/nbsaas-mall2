package com.nbsaas.life.system.data.mapper;

import com.nbsaas.life.system.api.domain.simple.MenuSimple;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MenuMapper {

    List<MenuSimple> findByUser(@Param("userId") Long userId);
}
