package playwrightconcepts;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import java.util.List;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.SelectOption;

public class Dropdown {

	@Test
	public void selectDropdown() throws InterruptedException {

		Playwright playwright = Playwright.create();

		Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));

		BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(1500, 800));

		Page page = context.newPage();

		page.navigate("https://www.lambdatest.com/selenium-playground/select-dropdown-demo");

		page.waitForLoadState();

		Locator dropdownbox = page.locator("//select[@id='select-demo']");

		page.waitForTimeout(2000);

		// Select By Value

		dropdownbox.selectOption("Monday");
		Locator result = page.locator("p.selected-value");
		assertThat(result).containsText("Monday");

		page.waitForTimeout(2000);

		// Select by label

		dropdownbox.selectOption(new SelectOption().setValue("Wednesday"));
		System.out.println(result.textContent());
		assertThat(result).containsText("Wednesday");

		page.waitForTimeout(2000);

		// Select By index

		dropdownbox.selectOption(new SelectOption().setIndex(6));

		Thread.sleep(5000);

		Locator multiselect = page.locator("//select[@name='States']");

		multiselect.selectOption(new String[] { "Florida", "Ohio" });

		Locator list = multiselect.locator("option");

		System.out.println(list.count());

		List<String> lsitOfData = list.allInnerTexts();

		lsitOfData.forEach(option -> System.out.println(option));

		System.out.println(list.count());

		for (String string : lsitOfData) {
			System.out.println(string);
		}

		page.waitForTimeout(2000);

		page.close();

		context.close();

		browser.close();

		playwright.close();

	}

}
