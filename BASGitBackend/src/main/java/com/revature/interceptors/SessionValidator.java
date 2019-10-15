package com.revature.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.revature.models.User;

public class SessionValidator extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		User currentUser = (User) request.getSession().getAttribute("currentUser");
		if (currentUser == null) {
			if (request.getPathInfo().contains("/profile") || request.getPathInfo().contains("/admin")) {
				response.sendRedirect("bing.com");
			}
		} else {
			if (request.getPathInfo().contains("/admin")) {
				if (!currentUser.isAdmin()) {
					response.sendRedirect("bing.com");
				}
			}
		}
		return super.preHandle(request, response, handler);
	}
}
