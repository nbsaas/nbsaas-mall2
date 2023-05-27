package com.nbsaas.life.statistics.api.domain.response;

import lombok.Data;

import java.util.List;

@Data
public class UserStatistics {

    /**
     * 注册用户
     */
    private List<Long> users;


}
