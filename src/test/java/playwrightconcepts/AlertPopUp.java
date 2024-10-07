package playwrightconcepts;

import org.testng.annotations.Test;

import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class AlertPopUp {

	@Test
	public void alertPopUp() throws InterruptedException {

		Playwright playwright = Playwright.create();

		Page page = playwright.firefox().launch(new LaunchOptions().setHeadless(false)).newContext().newPage();

		page.onDialog(dialog -> {

			String messgae = dialog.message();

			System.out.println(messgae);

			dialog.accept("Chandan panigrahi");

			// dialog.dismiss();
		});

		page.navigate("https://the-internet.herokuapp.com/javascript_alerts");

		page.waitForTimeout(2000);

		page.getByText("Click for JS Alert").click();
		String stringMessage = page.textContent("#result");
		System.out.println(stringMessage);

		page.waitForTimeout(2000);

		page.getByText("Click for JS Confirm").click();
		stringMessage = page.textContent("#result");
		System.out.println(stringMessage);

		page.waitForTimeout(2000);

		page.getByText("Click for JS Prompt").click();
		stringMessage = page.textContent("#result");
		System.out.println(stringMessage);

		page.waitForTimeout(2000);

		page.close();

		playwright.close();
	}

}
