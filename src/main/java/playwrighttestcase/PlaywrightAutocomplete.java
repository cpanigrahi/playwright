package playwrighttestcase;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlaywrightAutocomplete {

	@Test
	public void autoComplete() {

		Playwright play = Playwright.create();
		
		Browser browser = play.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		//maximize browser in playwright
		BrowserContext newContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(1400, 650));
		
		//Handle dropdown in playwright
		Page page = newContext.newPage();

		page.navigate("http://autopract.com/selenium/form5//");
		
		page.locator("//input[@value='four']").check();
		
		page.locator("//input[@value='four']").uncheck();
			  
		page.onDialog(dialog -> {

			dialog.accept();

			});

	}

}
