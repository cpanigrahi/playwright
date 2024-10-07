package playwrightconcepts;

import org.testng.annotations.Test;

import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class CheckBoxAndRadioButton {

	@Test
	public void checkBox() throws InterruptedException {

		Playwright playwright = Playwright.create();

		Page page = playwright.firefox().launch(new LaunchOptions().setHeadless(false)).newContext().newPage();

		page.navigate("https://www.tutorialspoint.com/selenium/practice/check-box.php");

		page.waitForTimeout(2000);

		page.check("#c_bs_1");

		page.waitForTimeout(2000);

		page.locator("#c_bs_1").click();

		page.waitForTimeout(2000);

		page.locator("//a[@href='radio-button.php']").click();

		page.waitForTimeout(2000);

		page.locator("//input[@value='igottwo']").click();

		page.waitForTimeout(2000);
		
		page.check("//input[@value='igotthree']");

		page.close();

		playwright.close();

	}

}
