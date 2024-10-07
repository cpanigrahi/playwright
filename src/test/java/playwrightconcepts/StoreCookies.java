package playwrightconcepts;

import java.nio.file.Paths;

import org.testng.annotations.Test;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class StoreCookies {

	@Test(priority = 2)
	public void application() {

		Playwright playwright = Playwright.create();
		BrowserContext browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false))
				.newContext();

		Page page = browser.newPage();

		page.navigate("https://practicetestautomation.com/practice-test-login/");

		page.locator("//input[@id='username']").fill("student");
		page.locator("//input[@id='password']").fill("Password123");

		page.locator("//button[@id='submit']").click();

		page.waitForTimeout(3000);

		String textContent = page
				.locator("//strong[contains(text(),'Congratulations student. You successfully logged i')]")
				.textContent();

		System.out.println(textContent);

		page.waitForTimeout(3000);

		browser.storageState(new BrowserContext.StorageStateOptions().setPath(Paths.get("./auth.json")));

		page.waitForTimeout(3000);

		page.close();

		browser.close();

		playwright.close();

	}

}
