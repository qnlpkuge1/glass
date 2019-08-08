package com.goosun.glass.service;

import org.springframework.security.core.context.SecurityContextHolder;

import com.goosun.glass.domain.User;

public abstract class BaseService {

	protected User currentUser() {

		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal != null && principal instanceof User) {
			return (User) principal;
		}
		return null;
	}
}
