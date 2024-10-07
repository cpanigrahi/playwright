package playwrightconcepts;

import java.io.IOException;
import java.util.List;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class FindElements {

	@Test
	public void listOfElements() throws IOException {

		Playwright playwright = Playwright.create();

		Browser browser = playwright.chromium()
				.launch(new BrowserType.LaunchOptions().setChannel("msedge").setHeadless(false));

		BrowserContext context = browser.newContext();

		Page page = context.newPage();

		page.navigate("https://www.programsbuzz.com/search/node");

		page.waitForLoadState();

		page.locator("//input[@id='edit-keys']").fill("Playwright Java");

		page.locator("//input[@id='edit-submit']").click();

		List<Locator> linkText = page.locator("//h3[@class='search-result__title']/a").all();

		for (Locator elements : linkText) {

			System.out.println(elements.textContent());
		}

		List<ElementHandle> links = page.locator("a").elementHandles();

		for (ElementHandle link : links) {

			String href = link.getAttribute("href");

			if (href != null && !href.isEmpty()) {

				System.out.println(href.toString());

			}

		}

		page.close();
		context.close();
		browser.close();
		playwright.close();

	}
}