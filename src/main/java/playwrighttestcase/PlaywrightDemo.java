package playwrighttestcase;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlaywrightDemo {

	@Test
	public void loginToApplication() throws InterruptedException {
		
		Playwright play = Playwright.create();
		
		Browser browser = play.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		//maximize browser in playwright
		BrowserContext newContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(1400, 650));
		
		
		//Handle dropdown in playwright
		Page page = newContext.newPage();
		
//		page.navigate("http://autopract.com/selenium/dropdown1/");
//		
//        //page.selectOption("//select[@class='custom-select']", "2");
//        
//        //page.selectOption("//select[@class='custom-select']", "Cricket");
//        
//        Locator dropDown = page.locator("//select[@class='custom-select']");
//        
//        //dropDown.selectOption("item2");
//        
//        dropDown.selectOption(new SelectOption().setLabel("Cricket")); 
//        //Handle dynamic drop down which is not started with select html tag
//        
//        page.navigate("http://autopract.com/selenium/dropdown4/");
//        
//        page.locator("//span[@class='caret']").click();
//        
//       // page.locator("//div[@class='dropdown-menu open']/ul/li").last().click();
//       
//        Locator data = page.locator("//div[@class='dropdown-menu open']/ul/li", new Page.LocatorOptions().setHasText("Austria"));
//        data.click();
		
		page.navigate("http://www.maths.surrey.ac.uk/explore/nigelspages/frame2.htm");

        FrameLocator middleFrame = page.frameLocator("//frame[@src='message.htm']");

        middleFrame.locator("//input[@name='name']").type("Naruto Uzumaki");
        
        middleFrame.locator("//textarea[@name='suggestions']").type("I Am Inside The Frame");
        
	}

}
