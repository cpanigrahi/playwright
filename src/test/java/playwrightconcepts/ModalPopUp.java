package playwrightconcepts;

import org.testng.annotations.Test;

import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class ModalPopUp {

	@Test
	public void moalPopup() throws InterruptedException {

		Playwright playwright = Playwright.create();

		Page page = playwright.firefox().launch(new LaunchOptions().setHeadless(false)).newContext().newPage();

		page.navigate("https://www.lambdatest.com/selenium-playground/bootstrap-modal-demo");

		page.locator("//button[@data-target='#myModal']").click();

		page.waitForTimeout(2000);

		page.locator("//button[text()='×']").first().click();

		page.waitForTimeout(2000);

		page.locator("//button[@data-target='#myMultiModal']").click();

		page.waitForTimeout(2000);

		page.locator("//button[@data-target='#mySecondModal']").click();

		page.waitForTimeout(2000);

		page.locator("(//button[text()='×'])[3]").click();

		page.waitForTimeout(2000);

		page.locator("(//button[text()='×'])[2]").click();

		page.waitForTimeout(2000);

		page.close();

		playwright.close();
	}

}
