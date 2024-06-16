package com.application.utillib;

import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.application.pagelib.LoginPageLib;
import com.application.pagelib.LogoutPage;
import com.microsoft.playwright.Page;

public class BaseTest {

	UtilLib pf;
	protected Page page;
	protected Properties prop;

	protected LoginPageLib loginPlib;

	protected LogoutPage logoutPlib;

	@Parameters({ "browser" })

	@BeforeTest
	public void setup(String browserName) {

		pf = new UtilLib();

		prop = pf.init_prop();

		if (browserName != null) {
			prop.setProperty("browser", browserName);
		}

		page = pf.initBrowser(prop);

		loginPlib = new LoginPageLib(page);

		logoutPlib = new LogoutPage(page);

	}

	@AfterTest
	public void tearDown() {
		page.context().browser().close();
	}

}