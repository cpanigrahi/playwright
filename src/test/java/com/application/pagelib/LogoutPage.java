package com.application.pagelib;

import com.microsoft.playwright.Page;

public class LogoutPage {

	Page page;

	public LogoutPage(Page page) {
		this.page = page;
	}

	private String logoutLink = "(//a[@id='logoutLink'])[1]";
	private String reportLink = "//div[@id='container_reports']";

	public void logOut() throws InterruptedException {
		page.locator(logoutLink).click();

	}

	public void clickOnReport() {

		page.click(reportLink);

	}

}
