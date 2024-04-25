package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchCustomerPage {

	WebDriver driver;

	public SearchCustomerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "SearchEmail")
	WebElement emailAddSearch;

	@FindBy(id = "search-customers")
	WebElement btnSearch;

	@FindBy(xpath = "//table[@id='customers-grid']")
	WebElement tableEmailResult;

	@FindBy(xpath = "//table[@id='customers-grid']//tbody/tr")
	List<WebElement> tableRows;

	@FindBy(xpath = "//table[@id='customers-grid']//tbody/tr[1]/td")
	List<WebElement> tableCols;
	
	@FindBy(id = "SearchFirstName")
	WebElement firstNameText;
	
	@FindBy(id = "SearchLastName")
	WebElement lastNameText;

	public void enterEmailAddress(String email) {
		emailAddSearch.clear();
		emailAddSearch.sendKeys(email);
	}

	public void clickSearchBtn() {
		emailAddSearch.click();
	}

	public boolean searchCustomerByEmail(String exp_email) {
		boolean found = false;

		// Total number of rows and total number of clos
		int totalRows = tableRows.size();
		// int totalCols = tableCols.size();

		for (int i = 1; i <= totalRows; i++) {
			WebElement emailWebElement = driver
					.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr[" + i + "]/td[2]"));
			String act_emailAddText = emailWebElement.getText();

			if (act_emailAddText.equals(exp_email)) {
				found = true;
			}

		}

		return found;
	}
	
	public void enterFirstName(String fName) {
		firstNameText.clear();
		firstNameText.sendKeys(fName);
	}
	
	public void enterLastName(String lName) {
		lastNameText.clear();
		lastNameText.sendKeys(lName);
	}
	
	
	public boolean searchCustomerByName(String exp_Name) {
		boolean found = false;

		// Total number of rows and total number of clos
		int totalRows = tableRows.size();
		// int totalCols = tableCols.size();

		for (int i = 1; i <= totalRows; i++) {
			WebElement fNameWebElement = driver
					.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr[" + i + "]/td[3]"));
			String act_NameText = fNameWebElement.getText();

			if (act_NameText.equals(exp_Name)) {
				found = true;
				break;
			}

		}

		return found;
	}
}
