package com.application.testngtestcases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.application.utillib.BaseTest;

public class ActimeTimePageTest extends BaseTest {

	String abc;

	@Test()
	public void emailtest1() throws InterruptedException, IOException {

		loginPlib.loginToActitime(prop.getProperty("username"), prop.getProperty("password"));
		logoutPlib.clickOnReport();
		logoutPlib.logOut();
	}

	@Test
	public void zypher() throws InterruptedException {
		loginPlib.loginToActitime(prop.getProperty("username"), prop.getProperty("password"));
		logoutPlib.clickOnReport();
		logoutPlib.logOut();

	}

}
