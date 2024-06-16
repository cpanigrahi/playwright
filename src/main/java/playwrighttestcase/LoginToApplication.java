package playwrighttestcase;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class LoginToApplication {

	@Test
	public void loginToApplication() {

		Playwright play = Playwright.create();

		Browser browser = play.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		// maximize browser in playwright
		BrowserContext newContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(1400, 650));

		Page page = newContext.newPage();

		// navigate to the url
		page.navigate("https://online.actitime.com/widentechinfo/login.do");

		// Verify title of the page

		// send values in playwright in a text box
		page.locator("#username").type("widentechinfo@gmail.com");

		page.locator("//input[@name = 'pwd']").type("widentech");

		page.locator("//div[text()= 'Login ']").click();

		page.close();

		browser.close();

		play.close();

//		Playwright playwright = Playwright.create();
//		
//		LaunchOptions lp = new LaunchOptions();
//		 
//		lp.setChannel("chrome");
//		
//		lp.setHeadless(false);
//		
//		Browser browser = playwright.chromium().launch(lp);
//		
//		Browser browser = playwright.webkit().launch(new LaunchOptions().setHeadless(false));
//		
//		Page page = browser.newPage();

//		WebDriverManager.firefoxdriver().setup();
//
//		WebDriver driver = new FirefoxDriver();
//
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		driver.get("https://online.actitime.com/cognizant/login.do");
//
//		driver.close();

//		// Create a request specification 
//		RequestSpecification request= RestAssured.given();
//		
//		//Adding URI
//		request.baseUri("https://restful-booker.herokuapp.com/booking");
//		
//		// Calling GET method on URI. After hitting we get Response
//		Response response = request.get();
//		
//		// Let's print response body.
//		String resString = response.asString();
//		System.out.println("Respnse Details : " + resString);
//
//		/*
//		 * To perform validation on response like status code or value, we need to get
//		 * ValidatableResponse type of response using then() method of Response
//		 * interface. ValidatableResponse is also an interface.
//		 */
//		ValidatableResponse valRes = response.then();
//		// It will check if status code is 200
//		valRes.statusCode(200);
//		// It will check if status line is as expected
//		valRes.statusLine("HTTP/1.1 200 OK");

//		String jsonString = "{\"username\" : \"admin\",\"password\" : \"password123\"}";
//		
//		// Create a request specification 
//		RequestSpecification request= RestAssured.given();
//		
//		// Setting content type to specify format in which request payload will be sent.
//		// ContentType is an ENUM. 
//		request.contentType(ContentType.JSON);
//		//Adding URI
//		request.baseUri("https://restful-booker.herokuapp.com/auth");
//		// Adding body as string
//		request.body(jsonString);
//		
//		// Calling POST method on URI. After hitting we get Response
//		Response response = request.post();
//		
//		// Printing Response as string
//		System.out.println(response.asString());
//		
//	
//		ValidatableResponse validatableResponse = response.then();
//		
//		// Validate status code as 200
//		validatableResponse.statusCode(200);
//		
//		// Validate token field is null
//		// SInce response is one to one mapping so passing key name will give you value.
//		// Below method validates that value of token is not null.
//		validatableResponse.body("token", Matchers.notNullValue());
//		
//		// Validate token length is 15
//		validatableResponse.body("token.length()", Matchers.is(15));
//		
//		// Validate token is an alphanumeric value
//		validatableResponse.body("token", Matchers.matchesRegex("^[a-z0-9]+$"));
	}

}
