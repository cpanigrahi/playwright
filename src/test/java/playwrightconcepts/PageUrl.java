package playwrightconcepts;

import java.nio.file.Paths;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PageUrl {

	@Test
	public void getUrl() {

		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium()
				.launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
		BrowserContext context = browser.newContext();
		Page page = context.newPage();

		page.navigate("https://online.actitime.com/widentechinfo/login.do");
		String applicationURl = page.url();
		System.out.println(applicationURl);
		page.waitForLoadState();
		page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("./Screenshots/getUrl.png")).setFullPage(true));

		page.close();
		context.close();
		browser.close();
		playwright.close();

	}

}
