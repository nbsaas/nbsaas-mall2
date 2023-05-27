package com.nbsaas.life.controller.statistics;

import com.nbsaas.boot.rest.response.ListResponse;
import com.nbsaas.boot.rest.response.ResponseObject;
import com.nbsaas.life.statistics.api.apis.UserStatisticsApi;
import com.nbsaas.life.statistics.api.domain.response.UserStatistics;
import com.nbsaas.life.statistics.api.domain.simple.LabelNum;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RequestMapping("/userStatistics")
@RestController
public class UserStatisticsController {

    @RequestMapping("/today")
    public ResponseObject<Long> today() {
        return userStatisticsApi.today();
    }

    @RequestMapping("/week")
    public ResponseObject<Long> week() {
        return userStatisticsApi.week();
    }

    @RequestMapping("/month")
    public ResponseObject<Long> month() {
        return userStatisticsApi.month();
    }

    @RequestMapping("/total")
    public ResponseObject<Long> total() {
        return userStatisticsApi.total();
    }

    @RequestMapping("/statistics")
    public ResponseObject<UserStatistics> statistics(String year) {
        return userStatisticsApi.statistics(year);
    }

    @RequestMapping("/lastYear")
    public ListResponse<LabelNum> lastYear() {
        return userStatisticsApi.lastYear();
    }

    @Resource
    private UserStatisticsApi userStatisticsApi;
}
