package playwrightconcepts;

import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.List;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class BrokenLink {

	@Test
	public void brokenLinkTest() {

		Playwright playwright = Playwright.create();

		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(true));

		Page page = browser.newPage();

		page.navigate("https://www.facebook.com");

		try {

			List<ElementHandle> links = page.locator("a").elementHandles();

			for (ElementHandle link : links) {

				String linkUrl = link.getAttribute("href");

				if (linkUrl != null && !linkUrl.isEmpty()) {

					try {

						URL url = URI.create(linkUrl).toURL();
						HttpURLConnection connection = (HttpURLConnection) url.openConnection();
						connection.connect();

						if (connection.getResponseCode() == 200) {
							System.out.println(linkUrl + " = Valid Link");
						} else if (connection.getResponseCode() == 404) {
							System.out.println(linkUrl + " = Invalid Link");
						}

					} catch (Exception e) {
						System.out.println(e.getMessage());
					}

				}

				else {
					System.out.println("Link URL is null or empty");
				}
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		finally {
			page.close();
			browser.close();
			playwright.close();
		}

	}
}
