package com.goosun.glass.service.impl;

import org.springframework.security.core.context.SecurityContextHolder;

import com.goosun.glass.domain.User;

public class BaseService {

	protected User currentUser() {

		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal != null && principal instanceof User) {
			return (User) principal;
		}
		return null;
	}
}
