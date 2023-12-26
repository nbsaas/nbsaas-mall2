package com.nbsaas.boot.customer.rest.convert;

import com.nbsaas.boot.customer.data.entity.Customer;
import com.nbsaas.boot.customer.api.domain.simple.CustomerSimple;

import com.nbsaas.boot.rest.api.Converter;
import java.util.HashMap;
import java.util.Map;

/**
* 列表对象转换器
*/

public class CustomerSimpleConvert implements Converter<CustomerSimple, Customer> {




@Override
public CustomerSimple convert(Customer source) {
    CustomerSimple result = new CustomerSimple();

                result.setAddress(source.getAddress());
                result.setSex(source.getSex());
                result.setIdNumber(source.getIdNumber());
                result.setBirthDate(source.getBirthDate());
                result.setAddDate(source.getAddDate());
                result.setSelfFile(source.getSelfFile());
                if(source.getAuditState()!=null){
                   Map<Integer,String> AuditStateMap=new HashMap<>();
                       AuditStateMap.put(0,"待审核");
                       AuditStateMap.put(1,"审核通过");
                       AuditStateMap.put(2,"审核失败");
                   String label=  AuditStateMap.get(source.getAuditState());
                   result.setAuditStateName(label);
                }
                result.setAuditState(source.getAuditState());
                result.setRealName(source.getRealName());
                result.setFrontIdCard(source.getFrontIdCard());
                result.setPhone(source.getPhone());
                result.setName(source.getName());
                result.setComment(source.getComment());
                result.setId(source.getId());
                result.setBackIdCard(source.getBackIdCard());
                result.setLastDate(source.getLastDate());


    return result;
}

}