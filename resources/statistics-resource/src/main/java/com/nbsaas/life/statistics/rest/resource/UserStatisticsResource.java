package com.nbsaas.life.statistics.rest.resource;

import com.nbsaas.boot.rest.response.ListResponse;
import com.nbsaas.boot.rest.response.ResponseObject;
import com.nbsaas.life.statistics.api.apis.UserStatisticsApi;
import com.nbsaas.life.statistics.api.domain.response.UserStatistics;
import com.nbsaas.life.statistics.api.domain.simple.LabelNum;
import com.nbsaas.life.statistics.data.mapper.UserStatisticsMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserStatisticsResource implements UserStatisticsApi {

    @Resource
    private UserStatisticsMapper userStatisticsMapper;


    @Override
    public ResponseObject<Long> today() {
        ResponseObject<Long> result = new ResponseObject<>();
        result.setData(userStatisticsMapper.today());
        return result;
    }

    @Override
    public ResponseObject<Long> week() {
        ResponseObject<Long> result = new ResponseObject<>();
        result.setData(userStatisticsMapper.week());
        return result;
    }

    @Override
    public ResponseObject<Long> month() {
        ResponseObject<Long> result = new ResponseObject<>();
        result.setData(userStatisticsMapper.month());
        return result;
    }

    @Override
    public ResponseObject<Long> total() {
        ResponseObject<Long> result = new ResponseObject<>();
        result.setData(userStatisticsMapper.total());
        return result;
    }


    @Override
    public ResponseObject<UserStatistics> statistics(String yearDate) {
        if (yearDate == null) {
            yearDate = new SimpleDateFormat("yyyy").format(new Date());
        }
        ResponseObject<UserStatistics> result = new ResponseObject<>();
        UserStatistics statistics = new UserStatistics();
        result.setData(statistics);
        //1.注册用户按年统计
        List<Long> users = userStatisticsMapper.year(yearDate).
                stream().map(LabelNum::getNum).collect(Collectors.toList());
        statistics.setUsers(users);

        return result;
    }

    @Override
    public ListResponse<LabelNum> lastYear() {
        ListResponse<LabelNum> result=new ListResponse<>();
        result.setData(userStatisticsMapper.lastYear());
        return result;
    }
}
