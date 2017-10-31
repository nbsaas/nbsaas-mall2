package com.quhaodian.web.interceptor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.quhaodian.shiro.utils.UserUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SiteHandlerInterceptor extends HandlerInterceptorAdapter {

	private Logger logger = LoggerFactory.getLogger("ada");

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler)
			throws ServletException {
		logger.info("LogHandlerInterceptor  preHandle");
		return true;
	}

	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		if(modelAndView!=null){
			logger.info("LogHandlerInterceptor  postHandle "
					+ modelAndView.getViewName());
			String siteurl = "siteurl";
			if(url!=null){
				logger.info("LocalAddr:"+ request.getLocalAddr());
				logger.info("LocalAddr:"+ request.getLocalAddr());
				if(request.getLocalAddr().indexOf("192.168")>-1){
					siteurl="http://"+request.getLocalAddr()+":"+request.getLocalPort()+request.getContextPath()+"/";
				}else{
					siteurl=url;
				}
			}else{
				siteurl="http://"+request.getLocalAddr()+":"+request.getLocalPort()+request.getContextPath()+"/";
			}
			logger.info("url:"+ siteurl);
			modelAndView.addObject("siteurl", siteurl);
			modelAndView.addObject("sitename", "真真点评");
			modelAndView.addObject("city", UserUtil.getCurrentCity());
			modelAndView.addObject("user", UserUtil.getCurrentUser());
			Subject subject = SecurityUtils.getSubject();
			if (subject.isAuthenticated()) {
				if(UserUtil.getCurrentUser().getId()>0){
				}else{
					subject.logout();
				}
			}
			//FrontUtils.format(request, modelAndView);
		}

	}
}
