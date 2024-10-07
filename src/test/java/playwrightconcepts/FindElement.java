package playwrightconcepts;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class FindElement {

	@Test
	public void findElement() throws InterruptedException {

		Playwright playwright = Playwright.create();

		Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));

		BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(1600, 800));

		Page page = context.newPage();

		page.navigate("https://www.dezlearn.com/webtable-example/");

		Locator elements = page.locator("//table[@class='tg']/tbody/tr/td");

		System.out.println(elements.first().textContent());

		System.out.println(elements.nth(2).textContent());

		System.out.println(elements.nth(-5).textContent());

		Thread.sleep(3000);

		page.close();

		context.close();

		browser.close();

		playwright.close();

	}

}
