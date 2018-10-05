package com.spdev.lindacaretest.service.impl;

import org.springframework.stereotype.Service;

import com.spdev.lindacaretest.service.UserService;

/**
 * 
 * @author marco
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Override
	public boolean isUserExist(Long id) {
		// check DB or other services but here it's a stub.
		return (id != null && id > 0);
	}

}