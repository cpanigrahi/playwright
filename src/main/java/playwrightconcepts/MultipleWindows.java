package playwrightconcepts;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class MultipleWindows {

	@Test
	public void windowHandles() throws InterruptedException {

		Playwright playwright = Playwright.create();

		Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));

		BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(1600, 800));

		Page page = context.newPage();

		page.navigate("https://www.lambdatest.com/selenium-playground/window-popup-modal-demo");

		Page popup = page.waitForPopup(() -> {
			page.locator("//a[@title='Follow @Lambdatesting on Twitter']").click();
		});

		popup.waitForLoadState();

		Thread.sleep(5000);

		System.out.println("ChildWindow = " + popup.title());

		System.out.println("ParentWindow = " + page.title());

		System.out.println(popup.getByText("Log in").textContent());

		Thread.sleep(5000);

		popup.close();

		page.close();

	}

}
