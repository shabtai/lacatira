package com.nsn.cloudstreet.rest.impl;

import org.springframework.stereotype.Service;

import com.nsn.cloudstreet.rest.AuthTest;

@Service("authTestService")
public class AuthTestService implements AuthTest {

	// an empty method that test user login.
	// This method will return OK code if login was successful
	public void auth() {
		//nothing to do

	}

}
