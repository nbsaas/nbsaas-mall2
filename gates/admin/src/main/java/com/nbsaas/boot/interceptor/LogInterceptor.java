package com.nbsaas.boot.interceptor;

import com.nbsaas.boot.rest.enums.StoreState;
import com.nbsaas.boot.user.api.apis.UserAccessLogApi;
import com.nbsaas.boot.user.api.domain.request.UserAccessLogDataRequest;
import com.nbsaas.boot.user.ext.domain.response.UserInfoExtResponse;
import com.nbsaas.boot.utils.UserUtils;
import org.springframework.lang.Nullable;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogInterceptor extends HandlerInterceptorAdapter {

    @Resource
    private UserAccessLogApi logApi;

    public static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("X-Real-IP");
        if (StringUtils.hasText(ip) && !"unknown".equalsIgnoreCase(ip)) {
            return ip;
        }
        ip = request.getHeader("X-Forwarded-For");
        if (StringUtils.hasText(ip) && !"unknown".equalsIgnoreCase(ip)) {
            // 多次反向代理后会有多个IP值，第一个为真实IP。
            int index = ip.indexOf(',');
            if (index != -1) {
                return ip.substring(0, index);
            } else {
                return ip;
            }
        } else {
            return request.getRemoteAddr();
        }
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        request.setAttribute("time", System.currentTimeMillis());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) {
        try {
            handleLog(request);
        } catch (Exception e) {

        }

    }

    private void handleLog(HttpServletRequest request) {
        UserInfoExtResponse user = UserUtils.user();
        if (user != null) {
            UserAccessLogDataRequest data=new UserAccessLogDataRequest();
            data.setCreator(user.getId());
            data.setIp(getIpAddr(request));
            data.setStoreState(StoreState.normal);
            Long time = (Long) request.getAttribute("time");
            if (time != null) {
                time = System.currentTimeMillis() - time;
                data.setConsumeTime(time);
            }
            data.setUrl(request.getRequestURI());
            logApi.create(data);
        }

    }
}
