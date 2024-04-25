package stepDefinition;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import pageObjects.AddNewCustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;
import utilities.ReadConfig;

public class BaseClass {

	public static WebDriver driver;
	public LoginPage loginPage;
	public AddNewCustomerPage addNewCustomerPage;
	public SearchCustomerPage searchCustomerPage;
	public static Logger log;
	public ReadConfig readConfig;
	
	//It will generate random unique email id
	public String generateEmailId() {
		return RandomStringUtils.randomAlphabetic(5);
		
	}
}
