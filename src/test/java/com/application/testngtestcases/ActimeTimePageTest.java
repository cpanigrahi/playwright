package com.application.testngtestcases;

import org.testng.annotations.Test;

import com.application.utillib.BaseTest;

public class ActimeTimePageTest extends BaseTest {

	@Test
	public void emailtest1() throws InterruptedException {
		loginPlib.loginToActitime(prop.getProperty("username"), prop.getProperty("password"));
		logoutPlib.clickOnReport();
		logoutPlib.logOut();
	}

	@Test
	public void emailtest2() throws InterruptedException {
		loginPlib.loginToActitime(prop.getProperty("username"), prop.getProperty("password"));
		logoutPlib.clickOnReport();
		logoutPlib.logOut();
	}

}
