package playwrightconcepts;

import java.nio.file.Paths;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlaceHolderText {

	@Test
	public void placeHolder() {

		Playwright playwright = Playwright.create();
		Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext context = browser.newContext();
		Page page = context.newPage();

		page.navigate("https://online.actitime.com/widentechinfo/login.do");
		Locator locator = page.locator("#username");
		String getPlaceholderText = locator.getAttribute("placeholder");
		System.out.println(getPlaceholderText);
		page.waitForLoadState();
		page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("./Screenshots/getPlaceHolderText.png"))
				.setFullPage(true));

		page.close();
		context.close();
		browser.close();
		playwright.close();

	}

}
