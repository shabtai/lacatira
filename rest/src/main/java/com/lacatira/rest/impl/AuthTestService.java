package com.lacatira.rest.impl;

import com.lacatira.rest.AuthTest;
import org.springframework.stereotype.Service;


@Service("authTestService")
public class AuthTestService implements AuthTest {

	// an empty method that test user login.
	// This method will return OK code if login was successful
	public void auth() {
		//nothing to do

	}

}
