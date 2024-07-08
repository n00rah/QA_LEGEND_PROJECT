package page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constants;
import utilities.ExcelUtility;
import utilities.WaitUtility;

public class UsersPage 
{
	WebDriver driver;
	public UsersPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//a[@class='btn btn-block btn-primary']")
	WebElement addButton;
	@FindBy(xpath="//input[@class='form-control input-sm']")
	WebElement searchField;
	@FindBy(xpath="(//td)[4]")
	WebElement searchResult;
	@FindBy(xpath="//a[@class='btn btn-xs btn-primary']")
	WebElement editButton;
	@FindBy(id="submit_user_button")
	WebElement updateButton;
	@FindBy(id="select2-role-container")
	WebElement roleField;
	@FindBy(xpath="//a[@class='btn btn-xs btn-info']")
	WebElement viewButton;
	@FindBy(xpath="//h3[@class='profile-username']")
	WebElement profileName;
	@FindBy(xpath="//button[@class='btn btn-xs btn-danger delete_user_button']")
	WebElement deleteButton;
	@FindBy(xpath="//button[@class='swal-button swal-button--confirm swal-button--danger']")
	WebElement deletePopupOkButton;
	@FindBy(xpath="//td[text()='No matching records found']")
	WebElement searchResultAfterDelete;
	@FindBy(id="last_name")
	WebElement lastNameField;
	@FindBy(id="first_name")
	WebElement firstNameField;
	@FindBy(xpath="//h1[text()='Users        ']")
	WebElement pageHeading;
	public AddUserPage clickOnAddButton()
	{
		addButton.click();
		return new AddUserPage(driver);
	}
	public void enterSearchData(String searchdata)
	{
		
		searchField.sendKeys(searchdata);
	}
	public String getSearchResultText()
	{
		WaitUtility.waitForElement(driver, searchResult);
		String expectedemail=searchResult.getText();
		System.out.println(expectedemail);
		return expectedemail;	
	}
	public AddUserPage clickOnEditButton()
	{
		editButton.click();
		return new AddUserPage(driver);
	}
	public void clickOnUpdateButton()
	{
		updateButton.click();
	}
	public void clickOnViewButton()
	{
		viewButton.click();
	}
	public void clickOnDeleteButton()
	{
		deleteButton.click();
	}
	public void clearRoleField()
	{
		WaitUtility.waitForElement(driver,roleField);
		roleField.clear();
	}
	public void enterNewRole()
	{
		roleField.sendKeys(ExcelUtility.getStringData(1,1,"UsersPage"));
	}
	public String getNewRoleAfterEdit()
	{
		WaitUtility.waitForElement(driver,roleField);
		String role=roleField.getText();
		System.out.println(role);
		return role;
	}
	public String getProfileName()
	{
		String profiletext=profileName.getText();
		return profiletext;
		
	}
	public void clickOnDeletePopupOkButton()
	{
		deletePopupOkButton.click();
	}
	public String getSearchResultAfterDelete()
	{
		WaitUtility.waitForElement(driver, searchResultAfterDelete);
		String result=searchResultAfterDelete.getText();
		return result;
	}
	public String getFirstName()
	{
		String firstname=firstNameField.getText();
		return firstname;
	}
	public void clearLastName()
	{
		lastNameField.clear();
	}
	public void enterNewLastName()
	{
		lastNameField.sendKeys(ExcelUtility.getStringData(1,1,Constants.USERS_PAGE));
	}
	public String getPageHeading()
	{
		String heading=pageHeading.getText();
		return heading;
	}
}
