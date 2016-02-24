package com.ada.common.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseAction {
	Logger logger = LoggerFactory.getLogger("log");

	public HttpSession getSession(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session == null) {
			logger.info("会话不存在");
			session = request.getSession(true);
		}
		return session;
	}


	protected String getCode(HttpServletRequest request) {
		HttpSession session = getSession(request);
		String smember = (String) session.getAttribute("code");
		return smember;
	}

	protected String setMember(HttpServletRequest request, String member) {
		HttpSession session = getSession(request);
		session.setAttribute("code", member);
		return member;
	}

	protected String login = "redirect:/login.htm";
}
