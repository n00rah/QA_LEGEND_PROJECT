package page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class HomePage 
{
	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//button[@class='btn btn-default btn-sm']")
	WebElement endTourButton;
	@FindBy(xpath="(//h1)")
	WebElement userNameDisplay;
	@FindBy(xpath="(//span)[4]")
	WebElement profileTab;
	@FindBy(xpath="//span[text()='User Management']")
	WebElement userManagementTab;
	@FindBy(xpath="(//span)[8]")
	WebElement usersTab;
	@FindBy(xpath="(//span)[5]")
	WebElement homeTab;
	@FindBy(xpath="//a[text()='Sign Out']")
	WebElement signOutButton;
	
	
	public String getUserNameTextDisplay()
	{
		String usernametext=userNameDisplay.getText();
		return usernametext;
	}
	public void clickOnEndTourButton()
	{
		endTourButton.click();
	}
	public void clickOnProfileTab()
	{
		profileTab.click();
	}
	
	public String getUserNameText()
	{
		String username_text=profileTab.getText();
		System.out.println(username_text);
		return username_text;
	}
	public void clickOnUserManagement()
	{
		userManagementTab.click();
	}
	public UsersPage clickOnUsers()
	{
		usersTab.click();
		WaitUtility.waitForElement(driver,usersTab);
		return new UsersPage(driver);
	}
	public void clickOnHomeTab()
	{
		homeTab.click();
	}
	public void clickOnSignOut()
	{
		signOutButton.click();
	}

}
