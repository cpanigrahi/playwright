package playwrightconcepts;

import org.testng.annotations.Test;

import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class FrameHandling {

	@Test
	public void frameHandling() throws InterruptedException {

		Playwright playwright = Playwright.create();

		Page page = playwright.firefox().launch(new LaunchOptions().setHeadless(false)).newContext().newPage();

		page.navigate("https://www.lambdatest.com/selenium-playground/iframe-demo/");

		FrameLocator framelocator = page.frameLocator("#iFrame1");

		Locator elementLocator = framelocator.locator(".rsw-ce").first();

		elementLocator.clear();

		elementLocator.fill("My Name is Chandan Panigrahi");

		Thread.sleep(5000);

		page.close();

		playwright.close();

	}

}
