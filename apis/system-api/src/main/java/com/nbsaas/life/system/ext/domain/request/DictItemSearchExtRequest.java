package com.nbsaas.life.system.ext.domain.request;

import com.nbsaas.boot.rest.filter.Operator;
import com.nbsaas.boot.rest.filter.Search;
import com.nbsaas.life.system.api.domain.request.DictItemSearchRequest;
import lombok.Data;

@Data
public class DictItemSearchExtRequest extends DictItemSearchRequest {

    @Search(name = "dict.id", operator = Operator.eq)
    private Long dict;
}
