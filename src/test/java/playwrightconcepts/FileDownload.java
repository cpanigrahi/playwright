package playwrightconcepts;

import java.nio.file.Paths;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Download;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class FileDownload {

	@Test
	public void fileDownload() throws InterruptedException {

		Playwright playwright = Playwright.create();

		Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));

		BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(1600, 800));

		Page page = context.newPage();

		page.navigate("https://the-internet.herokuapp.com/download");

		Download download = page.waitForDownload(() -> {

			page.click("//a[text()='LambdaTest.txt']");
		});

		System.out.println("Download url: " + download.url());

		System.out.println("Download page title: " + download.page().title());

		download.saveAs(Paths.get("./Files", download.suggestedFilename()));

		Thread.sleep(3000);

		page.close();

		context.close();

		browser.close();

		playwright.close();

	}

}
