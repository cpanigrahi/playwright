package com.application.testngtestcases;

import org.testng.annotations.Test;

import com.application.utillib.BaseTest;

public class ActimePage extends BaseTest {

	@Test
	public void emailtest() throws InterruptedException {

		loginPlib.loginToActitime(prop.getProperty("username"), prop.getProperty("password"));

		logoutPlib.logOut();

	}

	@Test
	public void emailtest4() throws InterruptedException {

		loginPlib.loginToActitime(prop.getProperty("username"), prop.getProperty("password"));

		logoutPlib.logOut();

	}

}
