package playwrightconcepts;

import java.nio.file.Paths;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class MaximizeBrowser {
	@Test
	public void maximize() {

		Playwright playwright = Playwright.create();
		Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(1600, 800));
		Page page = context.newPage();

		page.navigate("https://online.actitime.com/widentechinfo/login.do");
		page.waitForLoadState();
		page.screenshot(
				new Page.ScreenshotOptions().setPath(Paths.get("./Screenshots/getTitle.png")).setFullPage(true));

		page.close();
		context.close();
		browser.close();
		playwright.close();

	}

}
