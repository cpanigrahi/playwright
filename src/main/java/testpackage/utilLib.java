package testpackage;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class utilLib {

	static Page page;
	static Playwright playwright;
	static Browser browser;
	static BrowserContext context;

	public static void launchBrowser() {
		playwright = Playwright.create();
		browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		context = browser.newContext();
		page = context.newPage();
		page.navigate("https://the-internet.herokuapp.com/");
	}

	public static void takeScreenshot(String screenshotpath) {
		page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(screenshotpath)).setFullPage(true));
	}

	public static void closeBrowser() {
		page.close();

		browser.close();

		playwright.close();
	}

	public static void click(String xpath) {
		page.locator(xpath).click();
	}

}
