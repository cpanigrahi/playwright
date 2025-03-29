package testpackage;

import org.testng.annotations.Test;

public class Checkbox extends utilLib {

	@Test
	public void checkBoxTest() {

		utilLib.launchBrowser();

		utilLib.takeScreenshot("url.png");

		page.waitForSelector("//a[text()='Checkboxes']");

		utilLib.click("//a[text()='Checkboxes']");

		page.waitForSelector("(//input[@type='checkbox'])[1]");

		utilLib.click("(//input[@type='checkbox'])[1]");

		utilLib.click("(//input[@type='checkbox'])[2]");

		utilLib.takeScreenshot("CheckBOX.png");

		utilLib.closeBrowser();

	}
}
