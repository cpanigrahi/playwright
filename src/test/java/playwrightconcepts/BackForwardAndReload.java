package playwrightconcepts;

import java.nio.file.Paths;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class BackForwardAndReload {

	@Test
	public void backAndForward() throws InterruptedException {

		Playwright playwright = Playwright.create();
		Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(1600, 800));
		Page page = context.newPage();

		page.navigate("https://the-internet.herokuapp.com/");

		page.getByText("Context Menu").click();

		page.waitForTimeout(2000);

		page.goBack();

		page.waitForTimeout(2000);

		page.goForward();

		page.waitForTimeout(2000);

		page.reload();

		page.waitForTimeout(2000);

		page.screenshot(
				new Page.ScreenshotOptions().setPath(Paths.get("./Screenshots/getTooltipText.png")).setFullPage(true));

		page.close();
		context.close();
		browser.close();
		playwright.close();

	}

}
