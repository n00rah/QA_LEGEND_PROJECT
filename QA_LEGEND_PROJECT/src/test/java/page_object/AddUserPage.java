package page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelUtility;
import utilities.PageUtility;

public class AddUserPage {
	WebDriver driver;

	public AddUserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "surname")
	WebElement prefixField;
	@FindBy(xpath = "//input[@id='first_name']")
	WebElement firstNameField;
	@FindBy(id = "last_name")
	WebElement lastNameField;
	@FindBy(id = "email")
	WebElement emailIdField;
	@FindBy(xpath = "//select[@class='form-control select2 select2-hidden-accessible' and @id='role']")
	WebElement roleSelectionField;
	@FindBy(id = "username")
	WebElement userNameField;
	@FindBy(id = "password")
	WebElement passwordField;
	@FindBy(xpath = "//input[@name='confirm_password']")
	WebElement confirmPasswordField;
	@FindBy(id = "cmmsn_percent")
	WebElement salesCommisionField;
	@FindBy(id = "submit_user_button")
	WebElement saveButton;

	public void enterPrefix(String prefix) {
		prefixField.sendKeys(prefix);
	}

	public void enterFirstName(String firstName) {
		firstNameField.sendKeys(firstName);
	}

	public void enterLastName(String lastName) {
		lastNameField.sendKeys(lastName);

	}

	public void enterEmail(String emailId) {
		emailIdField.sendKeys(emailId);
	}

	public void getSelectRole() {
		PageUtility.selectByVisibleText(roleSelectionField, "Specialist");
	}

	public void enterUserName(String userName) {
		userNameField.sendKeys(userName);
	}

	public void enterPassword(String password) {
		passwordField.sendKeys(password);
	}

	public void enterConfirmPassword(String password) {
		confirmPasswordField.sendKeys(password);
	}

	public void enterSalesCommissionPercent() {
		salesCommisionField.sendKeys(ExcelUtility.getIntegerData(1, 2, "AddUserPage"));
	}

	public void clickOnSaveButton() {
		saveButton.click();
	}

	public void clearSalesCommisiionField() {
		salesCommisionField.clear();
	}

	public void enterNewSalesCommissionPercentage() {
		salesCommisionField.sendKeys(ExcelUtility.getIntegerData(1, 3, "UsersPage"));
	}

}
