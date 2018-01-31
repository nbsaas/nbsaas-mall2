package com.quhaodian.shiro.utils;

import com.quhaodian.shiro.realm.ShiroUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;

import com.quhaodian.area.data.entity.Area;
import com.quhaodian.user.data.entity.UserInfo;

public class UserUtil {
	/**
	 * 获取当前用户对象shiro
	 * 
	 * @return shirouser
	 */
	public static ShiroUser getCurrentShiroUser() {
		ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
		return user;
	}

	/**
	 * 获取当前用户session
	 * 
	 * @return session
	 */
	public static Session getSession() {
		Session session = SecurityUtils.getSubject().getSession();
		return session;
	}

	/**
	 * 获取当前用户httpsession
	 * 
	 * @return httpsession
	 */
	public static Session getHttpSession() {
		Session session = SecurityUtils.getSubject().getSession();
		return session;
	}

	/**
	 * 获取当前用户对象
	 * 
	 * @return user
	 */
	public static UserInfo getCurrentUser() {
		UserInfo result=null;
		Session session = SecurityUtils.getSubject().getSession();
		if (null != session) {
			result=(UserInfo) session.getAttribute("user");
			
		} 
		if(result==null){
			result=new UserInfo();
			result.setId(-1l);
		}
		return result;
		
		

	}

	public static UserInfo setCurrentUser(UserInfo user) {
		Session session = SecurityUtils.getSubject().getSession();
		if (null != session) {
			session.setAttribute("user", user);
			return (UserInfo) session.getAttribute("user");
		} else {
			return null;
		}

	}

	public static Area setCurrentCity(Area area) {
		Session session = SecurityUtils.getSubject().getSession();
		Area result=new Area();
		result.setId(area.getId());
		result.setName(area.getName());
		if (null != session) {
			session.setAttribute("area", result);
			return (Area) session.getAttribute("area");
		} else {
			return result;
		}

	}

	public static Area getCurrentCity() {
		Session session = SecurityUtils.getSubject().getSession();
		if (null != session) {
			Area e = (Area) session.getAttribute("area");
			if (e == null) {
				e = new Area();
				e.setId(113);
				e.setName("西安");
			}
			return e;
		} else {
			Area e = new Area();
			e.setId(113);
			e.setName("西安");
			return e;
		}

	}
}
