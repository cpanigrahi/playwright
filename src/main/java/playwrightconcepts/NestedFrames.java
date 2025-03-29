package playwrightconcepts;

import org.testng.annotations.Test;

import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class NestedFrames {

	@Test
	public void nestedFrames() throws InterruptedException {

		Playwright playwright = Playwright.create();

		Page page = playwright.firefox().launch(new LaunchOptions().setHeadless(false)).newContext().newPage();

		page.navigate("https://www.dezlearn.com/nested-iframes-example/");

		FrameLocator parentFrame = page.frameLocator("#parent_iframe");

		Locator clickHereLocator = parentFrame.locator("#u_5_5");

		clickHereLocator.click();

		Thread.sleep(3000);

		FrameLocator childFrame = parentFrame.frameLocator("#iframe1");

		Locator clickHere = childFrame.locator("#u_5_6");

		clickHere.click();

		Thread.sleep(2000);

		page.close();

		playwright.close();

	}

}
