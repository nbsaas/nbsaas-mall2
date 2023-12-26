package com.nbsaas.boot.listenter;

import com.nbsaas.boot.user.api.apis.UserLoginLogApi;
import com.nbsaas.boot.user.api.domain.request.UserLoginLogDataRequest;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


@Component
@EnableAsync
public class UserLoginListener {

    @Resource
    private UserLoginLogApi userLoginLogApi;


    @Async
    @EventListener(UserLoginLogDataRequest.class)
    public void notifyDistribution(UserLoginLogDataRequest event) {
        userLoginLogApi.create(event);
    }
}
