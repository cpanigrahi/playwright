package com.application.pagelib;

import com.microsoft.playwright.Page;

public class LoginPageLib {

	Page page;

	public LoginPageLib(Page page) {
		this.page = page;
	}

	private String usernameTextBox = "//input[@id = 'username']";
	private String pwdTextBox = "//input[@name = 'pwd']";
	private String loginBtn = "//div[text()= 'Login ']";

	public void loginToActitime(String emailid, String password) throws InterruptedException {
		page.fill(usernameTextBox, emailid);
		page.fill(pwdTextBox, password);
		page.click(loginBtn);

	}

}
