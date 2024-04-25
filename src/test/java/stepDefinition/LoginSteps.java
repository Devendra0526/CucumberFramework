package stepDefinition;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.AddNewCustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;
import utilities.ReadConfig;

public class LoginSteps extends BaseClass {

	
	///////Login////////////////////
	
	//we can add multiple @Before also pass the order execution
	@Before("@sanity")
	public void setup() {
		
		readConfig = new ReadConfig();
		
		
		log = LogManager.getLogger("LoginSteps");
				
		System.out.println("Setup for Sanity method executed");
		String browser = readConfig.getBrowser();
		switch(browser.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
			
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		default:
			driver = null;
			break;
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		log.info("setup1 executed................");
	}
	
//	@Before("@regression")
//	public void setup2() {
//		System.out.println("Setup2 for Regression method executed");
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		log.info("setup2 executed................");
//	}
	/*
	@Given("User launch Chrome browser")
	public void user_launch_chrome_browser() {
		
		
		
		loginPage = new LoginPage(driver);
		addNewCustomerPage = new AddNewCustomerPage(driver);
		searchCustomerPage = new SearchCustomerPage(driver);
		log.info("User lunch chrome browser");
	}

	@When("User open URL {string}")
	public void user_open_url(String url) {
		driver.get(url);
		log.info("URL open");
	}

	@When("User enter Email as {string} and password as {string}")
	public void user_enter_email_as_and_password_as(String email, String pwd) {
		loginPage.enterEmail(email);
		loginPage.enterPassword(pwd);
		log.info("Enter email and password");
	}

	@When("Click on login")
	public void click_on_login() {
		loginPage.clickLoginBtn();
		log.info("Click on login button");
	}
	
	@Then("Page Title should be {string}")
	public void page_title_should_be(String exp_title) {
		String act_title = driver.getTitle();
		if (act_title.equals(exp_title)) {
			log.warn("Test passed: page title matched");
			Assert.assertTrue(true); // pass
		} 
		else {
			log.warn("Test failled: page title not matched");
			Assert.assertTrue(false); // failed
		}
	}
	
	@When("User click on Log out link")
	public void user_click_on_log_out_link() {
		loginPage.clickLogoutBtn();
		log.info("Hit on Logout link");
	}*/

//	@Then("close browser")
//	public void close_browser() {
//		driver.close();
//		log.info("Browser closed");
//		//driver.quit();
//	}
	
	/////addCustomer/////////////
	
	@Given("User launch Chrome browser")
	public void user_launch_chrome_browser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		loginPage = new LoginPage(driver);
		addNewCustomerPage = new AddNewCustomerPage(driver);
		searchCustomerPage = new SearchCustomerPage(driver);
	}

	@When("User open URL {string}")
	public void user_open_url(String url) {
		driver.get(url);
	}

	@When("User enter Email as {string} and password as {string}")
	public void user_enter_email_as_and_password_as(String email, String pwd) {
		loginPage.enterEmail(email);
		loginPage.enterPassword(pwd);
	}

	@When("Click on login")
	public void click_on_login() {
		loginPage.clickLoginBtn();
	}
	
	@Then("Page Title should be {string}")
	public void page_title_should_be(String exp_title) {
		String act_title = driver.getTitle();
		if (act_title.equals(exp_title)) {
			Assert.assertTrue(true); // pass
		} else {
			Assert.assertTrue(false); // failed
		}
	}
	
	@When("User click on Log out link")
	public void user_click_on_log_out_link() {
		loginPage.clickLogoutBtn();
	}

//	@Then("close browser")
//	public void close_browser() {
//		driver.close();
//		//driver.quit();
//	}
	
	
	@Then("User can view Dashboard")
	public void user_can_view_dashboard() {
		String act_title = addNewCustomerPage.getPageTitle();
		String exp_title = "Dashboard / nopCommerce administration";
		if (act_title.equals(exp_title)) {
			log.info("User view Dashboard");
			Assert.assertTrue(true);
		}
		else {
			log.warn("User canot view Dashboard");
			Assert.assertTrue(false);
		}
	}

	@When("User click on Customer Menu")
	public void user_click_on_customer_menu() {
		addNewCustomerPage.clickOnCustomersMenu();
		log.info("User click on Customer Menu");
	}

	@When("Click on customer Menu Item")
	public void click_on_customer_menu_item() {
		addNewCustomerPage.clickOnCustomersMenuItem();
		log.info("User click on Customer Item");
	}

	@When("Click on Add new button")
	public void click_on_add_new_button() {
		addNewCustomerPage.clickOnAddnew();
		log.info("User click on Addnew Button");
	}

	@Then("User can view Add a new customer page")
	public void user_can_view_add_a_new_customer_page() {
		String act_title = addNewCustomerPage.getPageTitle();
		String exp_title = "Add a new customer / nopCommerce administration";
		if (act_title.equals(exp_title)) {
			log.info("Test passed: New cutomer added");
			Assert.assertTrue(true);
		}
		else {
			log.warn("Test failed: New customer Not added");
			Assert.assertTrue(false);
		}
	}

	@When("User enters customer information")
	public void user_enters_customer_information() {
		//addNewCustomerPage.enterEmail("testdevendra1234@gmail.com");
		addNewCustomerPage.enterEmail(generateEmailId()+"@gmail.com");
		addNewCustomerPage.enterPassword("test1");
		addNewCustomerPage.enterFirstName("Devendr");
		addNewCustomerPage.enterLastName("kumar");
		addNewCustomerPage.enterGender("Male");
		addNewCustomerPage.enterDob("02/26/1996");
		addNewCustomerPage.enterCompanyName("dkybrand");
		addNewCustomerPage.enterAdminContent("Admin content");
		addNewCustomerPage.enterManagerOfVendor("Vendor 1");
		
		log.info("Customer information");
	}

	@When("Click on Save button")
	public void click_on_save_button() {
		addNewCustomerPage.clickOnSave();
		log.info("click on Save button");
	}

	@Then("User can view confirmaition message {string}")
	public void user_can_view_confirmaition_message(String expectedConfirmationMessage) {
		String bodyText = driver.findElement(By.tagName("Body")).getText();
		if (bodyText.contains(expectedConfirmationMessage)) {
			log.info("Test passed: user view confirmation message");
			Assert.assertTrue(true); //Pass
		}
		else {
			log.info("Test faailed: user not received confirmation message");
			Assert.assertTrue(false); //Failed
		}
		
	}
	
	//////search customer//////////
	
	@When("Enter customer Email")
	public void enter_customer_email() {
		searchCustomerPage.enterEmailAddress("admin@yourStore.com");
		log.info("user search by email");
	}

	@When("Click on search button")
	public void click_on_search_button() {
		searchCustomerPage.clickSearchBtn();
		log.info("user click on Search Button");
	}

	@Then("User should found Email in the search table")
	public void user_should_found_email_in_the_search_table() {
		String exp_emailAdd = "admin@yourStore.com";
//		if (searchCustomerPage.searchCustomerByEmail(exp_emailAdd) == true) {
//			Assert.assertTrue(true);  //Pass
//		}
//		else {
//			Assert.assertTrue(false);  //Fail
//		}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		log.info("user found the email");
		Assert.assertTrue(searchCustomerPage.searchCustomerByEmail(exp_emailAdd));
	}
	
	
	///////search customer by name//////
	
	@When("Enter customer FirstName")
	public void enter_customer_first_name() {
		searchCustomerPage.enterFirstName("John");
		log.info("user search by FirstName");
	}

	@When("Enter customer LastName")
	public void enter_customer_last_name() {
		searchCustomerPage.enterLastName("Smith");
		log.info("user search by LastName");
	}

	@Then("User should found name in the search table")
	public void user_should_found_name_in_the_search_table() {
		String exp_Name = "John Smith";
		
//		if (searchCustomerPage.searchCustomerByName(exp_Name) == true) {
//			Assert.assertTrue(true); // Pass
//		} 
//		else {
//			Assert.assertTrue(false); // Fail
//		}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		log.info("user found the FirstName and LastName");
	Assert.assertTrue(searchCustomerPage.searchCustomerByName(exp_Name));
		
	}
	
	//we can add multiple @After
	//@After
	public void teaDown(Scenario sc) {
		System.out.println("Tear Down method executed");
		if (sc.isFailed()==true) {
			
			log.info("If test case failed : Take the ScreenShots");
			String filePath = "C:\\Users\\deven\\eclipse-workspace\\CucumberFramework\\ScreenShots\\failedScenario.png";
			
			//convert the object inot TakesScreeshot
			TakesScreenshot srcShots = ((TakesScreenshot)driver);
			
			//call getScreesShotAs() to create image file
			File srcFiles = srcShots.getScreenshotAs(OutputType.FILE);
			
			//move image to new destination
			File desFiles = new File(filePath);
			
			//copy file at destination
			try {
				FileUtils.copyFile(srcFiles, desFiles);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		log.info("Quite the browser");
		driver.quit();
	}
	
	@AfterStep
	public void addScreenShot(Scenario scenario) {
		
		if (scenario.isFailed()) {
			final byte[] screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenShot, "image/png", scenario.getName());	
		}
		
//		final byte[] screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//		scenario.attach(screenShot, "image/png", scenario.getName());
	}
	
	/*
	@BeforeStep
	public void beforeSetup() {
		System.out.println("It will execute beforeSetup method");
	}
	
	@AfterStep
	public void afterSetup() {
		System.out.println("It will execute afterSetup method");
	}*/
}
