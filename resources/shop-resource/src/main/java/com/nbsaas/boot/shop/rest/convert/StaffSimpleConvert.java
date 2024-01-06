package com.nbsaas.boot.shop.rest.convert;

import com.nbsaas.boot.shop.data.entity.Staff;
import com.nbsaas.boot.shop.api.domain.simple.StaffSimple;

import com.nbsaas.boot.rest.api.Converter;

/**
* 列表对象转换器
*/

public class StaffSimpleConvert implements Converter<StaffSimple, Staff> {




@Override
public StaffSimple convert(Staff source) {
    StaffSimple result = new StaffSimple();

                result.setNote(source.getNote());
                result.setPhone(source.getPhone());
                result.setName(source.getName());
                result.setAvatar(source.getAvatar());
                result.setId(source.getId());
                result.setAddDate(source.getAddDate());
                result.setLastDate(source.getLastDate());


    return result;
}

}