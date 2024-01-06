package com.nbsaas.boot.customer.rest.convert;

import com.nbsaas.boot.customer.data.entity.Customer;
import com.nbsaas.boot.customer.api.domain.response.CustomerResponse;

import com.nbsaas.boot.utils.BeanDataUtils;
import com.nbsaas.boot.rest.api.Converter;
import java.util.HashMap;
import java.util.Map;
/**
* 实体对象转化成响应对象
*/

public class CustomerResponseConvert  implements Converter<CustomerResponse,Customer> {

    @Override
    public CustomerResponse convert(Customer source) {
        CustomerResponse  result = new  CustomerResponse();
        BeanDataUtils.copyProperties(source, result);
                    if(source.getStructure()!=null){
                        result.setStructureName(source.getStructure().getName());
                    }
                    if(source.getDataScope()!=null){
                        result.setDataScopeName(String.valueOf(source.getDataScope()));
                    }
                    if(source.getAuditState()!=null){
                    Map<Integer,String> AuditStateMap=new HashMap<>();
                        AuditStateMap.put(0,"待审核");
                        AuditStateMap.put(1,"审核通过");
                        AuditStateMap.put(2,"审核失败");
                    String label=  AuditStateMap.get(source.getAuditState());
                    result.setAuditStateName(label);
                    }
                    result.setAuditState(source.getAuditState());
                    if(source.getStructure()!=null){
                        result.setStructure(source.getStructure().getId());
                    }
                    if(source.getState()!=null){
                        result.setStateName(String.valueOf(source.getState()));
                    }
        return result;
    }

}

