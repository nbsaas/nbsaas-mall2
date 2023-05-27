package com.nbsaas.life.statistics.api.apis;


import com.nbsaas.boot.rest.response.ListResponse;
import com.nbsaas.boot.rest.response.ResponseObject;
import com.nbsaas.life.statistics.api.domain.response.UserStatistics;
import com.nbsaas.life.statistics.api.domain.simple.LabelNum;

public interface UserStatisticsApi {

    ResponseObject<Long> today();

    ResponseObject<Long> week();

    ResponseObject<Long> month();

    ResponseObject<Long> total();

    ResponseObject<UserStatistics> statistics(String year);

    ListResponse<LabelNum> lastYear();

}
