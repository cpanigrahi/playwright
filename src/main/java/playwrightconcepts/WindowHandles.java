package playwrightconcepts;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class WindowHandles {

	@Test
	public void windowHandles() throws InterruptedException {

		Playwright playwright = Playwright.create();

		Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));

		BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(1600, 800));

		Page page = context.newPage();

		page.navigate("https://www.tutorialspoint.com/selenium/practice/browser-windows.php");

		// page.locator("//button[text()='New Tab']").click();

		Page popup = page.waitForPopup(() -> {

			page.locator("//button[text()='New Tab']").click();

		});

		System.out.println("new tab: " + popup.title());

		System.out.println("new tab: " + popup.url());

		String value = page.locator("h1").nth(-2).textContent();

		System.out.println(value);

		popup.close();

		Thread.sleep(5000);

		page.close();

		browser.close();

		playwright.close();

	}

}
