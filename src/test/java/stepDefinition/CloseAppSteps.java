package stepDefinition;

import io.cucumber.java.en.Then;

public class CloseAppSteps extends BaseClass{

	@Then("close browser")
	public void close_browser() {
		if (driver != null) {
			driver.close();
			log.info("Browser closed");
			//driver.quit();
		}
	}
}
