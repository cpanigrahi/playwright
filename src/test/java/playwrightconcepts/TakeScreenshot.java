package playwrightconcepts;

import java.nio.file.Paths;
import java.util.Arrays;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.ScreenshotOptions;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Tracing;
import com.microsoft.playwright.options.ScreenshotCaret;

public class TakeScreenshot {

	@Test
	public void screenshot() throws InterruptedException {

		Playwright playwright = Playwright.create();

		Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));

		BrowserContext context = browser.newContext();

		context.tracing().start(new Tracing.StartOptions().setScreenshots(true).setSnapshots(true).setSources(true));

		Page page = context.newPage();

		page.navigate("https://www.lambdatest.com/selenium-playground/simple-form-demo");

		page.waitForLoadState();

		// Take screenshot

		ScreenshotOptions options = new ScreenshotOptions();

		page.screenshot(options.setPath(Paths.get("./snaps/partial.png")));

		// Full page screenshot

		page.screenshot(options.setFullPage(true).setPath(Paths.get("./snaps/fullpage.jpg")));

		// Locator screenshot

		Locator file = page.getByText("Simple Form Demo");

		file.screenshot(new Locator.ScreenshotOptions().setPath(Paths.get("./snaps/locator.png")));

		// Masking screenshot

		Locator userTextBox = page.locator("input#user-message");

		userTextBox.fill("Chandan");

		userTextBox.scrollIntoViewIfNeeded();

		// Without masking
		page.screenshot(options.setFullPage(true).setPath(Paths.get("./snaps/WithoutMasking.jpg")));

		// With Masking
		page.screenshot(options.setFullPage(true).setPath(Paths.get("./snaps/Masking.jpg")).setFullPage(false)
				.setMask(Arrays.asList(userTextBox)));

		Thread.sleep(5000);

		userTextBox.clear();

		Thread.sleep(5000);

		userTextBox.click();

		// Caret hide / visible

		page.screenshot(
				new ScreenshotOptions().setCaret(ScreenshotCaret.INITIAL).setPath(Paths.get("./snaps/Initial.jpg")));

		page.screenshot(new ScreenshotOptions().setCaret(ScreenshotCaret.HIDE).setPath(Paths.get("./snaps/Hide.jpg")));

		context.tracing().stop(new Tracing.StopOptions().setPath(Paths.get("./trace.zip")));

		page.close();

		context.close();

		browser.close();

		playwright.close();

	}

}
