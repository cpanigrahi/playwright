package playwrightconcepts;

import java.nio.file.Paths;
import java.util.List;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class AutoSuggestion {

	@Test
	public void autoSuggestion() throws InterruptedException {

		Playwright playwright = Playwright.create();

		Page page = playwright.firefox().launch(new LaunchOptions().setHeadless(false)).newContext(
				new Browser.NewContextOptions().setRecordVideoDir(Paths.get("./Videos")).setRecordVideoSize(640, 480))
				.newPage();

		page.navigate("https://www.google.com");

		Locator searchInput = page.locator("#APjFqb");

		searchInput.click();

		searchInput.fill("lambdatest");

		page.waitForTimeout(5000);

		List<Locator> suggestions = page.locator("ul[role='listbox'] li").all();

		for (Locator suggestion : suggestions) {

			String suggestionText = suggestion.innerText();

			System.out.println("Suggestion Values =  " + suggestionText);

			if (suggestionText.contains("pricing")) {

				suggestion.click();

				break;
			}

		}

		page.waitForTimeout(5000);

		page.close();

		playwright.close();
	}
}
