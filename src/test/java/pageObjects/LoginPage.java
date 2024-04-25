package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "Email")
	WebElement emailText;
	
	@FindBy(id = "Password")
	WebElement passwordText;
	
	@FindBy(xpath = "//button[@class='button-1 login-button']")
	WebElement loginBtn;
	
	@FindBy(xpath = "//a[@href='/logout']")
	WebElement logoutBtn;
	
	public void enterEmail(String email) {
		emailText.clear();
		emailText.sendKeys(email);
	}
	
	public void enterPassword(String pwd) {
		passwordText.clear();
		passwordText.sendKeys(pwd);
	}
	
	public void clickLoginBtn() {
		loginBtn.click();
	}
	
	public void clickLogoutBtn() {
		logoutBtn.click();
	}

}
