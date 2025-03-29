package playwrightconcepts;

import java.nio.file.Paths;

import org.testng.annotations.Test;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType.LaunchOptions;

public class AuthenticationPopUp {

	@Test
	public void authPopUp() throws InterruptedException {

		Playwright playwright = Playwright.create();

		Page page = playwright.firefox().launch(new LaunchOptions().setHeadless(false))
				.newContext(new Browser.NewContextOptions().setHttpCredentials("admin", "admin")
						.setRecordVideoDir(Paths.get("./Videos"))
						.setRecordVideoSize(1000, 600)
						.setViewportSize(1600, 800))
				.newPage();

		page.navigate("https://the-internet.herokuapp.com/digest_auth");

		page.waitForTimeout(2000);

		System.out.println(page.locator("p").textContent());

		page.close();

		playwright.close();

	}

}
