package playwrightconcepts;

import java.util.List;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class MultipleWindows2 {

	@Test
	public void windowHandles() throws InterruptedException {

		Playwright playwright = Playwright.create();

		Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));

		BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(1600, 800));

		Page page = context.newPage();

		page.navigate("https://www.lambdatest.com/selenium-playground/window-popup-modal-demo");

		Page tabs = page.waitForPopup(new Page.WaitForPopupOptions().setPredicate(p -> p.context().pages().size() == 4),
				() -> {

					page.locator("#followall").click();
				});

		List<Page> pages = tabs.context().pages();

		System.out.println(pages.size());

		pages .forEach(tab -> {
			tab.waitForLoadState();
			System.out.println(tab.title());
		});

		tabs.close();

		page.close();
		
		

	}

}
