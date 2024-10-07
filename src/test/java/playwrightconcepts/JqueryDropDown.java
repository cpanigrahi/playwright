package playwrightconcepts;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class JqueryDropDown {

	@Test
	public void jqueryDropdown() throws InterruptedException {

		Playwright playwright = Playwright.create();

		Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));

		BrowserContext context = browser.newContext();

		Page page = context.newPage();

		page.navigate("https://www.lambdatest.com/selenium-playground/jquery-dropdown-search-demo");

		page.waitForLoadState();

		Locator country = page.locator("span.select2-selection").first();

		country.click();

		page.locator("span.select2-results ul li", new Page.LocatorOptions().setHasText("India")).click();

		Thread.sleep(2000);

		page.locator("select#files").selectOption("Ruby");

		Thread.sleep(2000);

		page.close();

		context.close();

		browser.close();

		playwright.close();

	}

}
