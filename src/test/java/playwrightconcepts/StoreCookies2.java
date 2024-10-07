package playwrightconcepts;

import java.nio.file.Paths;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class StoreCookies2 {

	@Test(priority = 2)
	public void application() {
		Playwright playwright1 = Playwright.create();
		BrowserContext browser1 = playwright1.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false))
				.newContext(new Browser.NewContextOptions().setStorageStatePath(Paths.get("./auth.json")));

		Page page1 = browser1.newPage();

		page1.navigate("https://practicetestautomation.com/practice-test-login/");

		page1.waitForTimeout(3000);

		String textContent1 = page1
				.locator("//strong[contains(text(),'Congratulations student. You successfully logged i')]")
				.textContent();
		System.out.println(textContent1);

		page1.waitForTimeout(3000);

		page1.close();

		browser1.close();

		playwright1.close();

	}

}
