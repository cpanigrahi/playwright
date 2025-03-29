package playwrightconcepts;

import java.nio.file.Paths;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PageTile {

	@Test
	public void getTitle() {

		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium()
				.launch(new BrowserType.LaunchOptions().setChannel("msedge").setHeadless(false));
		BrowserContext context = browser.newContext();
		Page page = context.newPage();

		page.navigate("https://online.actitime.com/widentechinfo/login.do");
		String applicationTitle = page.title();
		System.out.println(applicationTitle);
		Assert.assertEquals(applicationTitle, "actiTIME - Login", "title is not matched");
		page.waitForLoadState();
		page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("./Screenshots/getTitle.png")).setFullPage(true));
		
		page.close();
		context.close();
		browser.close();
		playwright.close();

	}
}
