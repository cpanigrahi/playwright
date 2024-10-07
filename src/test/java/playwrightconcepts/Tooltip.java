package playwrightconcepts;

import java.nio.file.Paths;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Tooltip {

	@Test
	public void toolTip() {

		Playwright playwright = Playwright.create();
		Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext context = browser.newContext();
		Page page = context.newPage();

		page.navigate("https://practice.expandtesting.com/tooltips");
		Locator locator = page.locator("#btn4");
		locator.hover();
		String data = locator.textContent();
		System.out.println(data);

		Assert.assertFalse(data.contains("titile"), "text not found");

		page.waitForLoadState();
		page.screenshot(
				new Page.ScreenshotOptions().setPath(Paths.get("./Screenshots/getTooltipText.png")).setFullPage(true));

		page.close();
		context.close();
		browser.close();
		playwright.close();

	}

}
