package playwrightconcepts;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.FileChooser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class UploadMultipleFiles {

	@Test
	public void fileUpload() throws InterruptedException {

		Playwright playwright = Playwright.create();

		Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));

		BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(1600, 800));

		Page page = context.newPage();

		page.navigate("https://davidwalsh.name/demo/multiple-file-upload.php");

		FileChooser fileChooser = page.waitForFileChooser(() -> {
			page.locator("#filesToUpload").click();
		});

		if (fileChooser.isMultiple()) {

			fileChooser.setFiles(new Path[] { Paths.get("./Tiago.png"), Paths.get("./Altroz.png") });

		}

		Thread.sleep(3000);

		page.locator("#file-submit").click();

		Thread.sleep(3000);

		System.out.println(page.locator("h3").textContent());

		SoftAssert soft = new SoftAssert();

		soft.assertEquals(page.locator("h3").textContent(), "File Uploaded!", "Text is not validated");

		System.out.println("Test Completed");

		page.close();

		context.close();

		browser.close();

		playwright.close();

	}

}