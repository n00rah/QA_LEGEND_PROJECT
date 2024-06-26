package page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage 
{
	WebDriver driver;
	public ProfilePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//a[text()='Profile']")
	WebElement profileTab;
	@FindBy(id="last_name")
	WebElement lastNameField;
	@FindBy(xpath="//button[text()='Update']")
	WebElement updateButton;
	
	public void clickOnProfileTab()
	{
		profileTab.click();
	}
	public void clearLastNameField()
	{
		lastNameField.clear();
	}
	public void enterLastName(String lastnamefield)
	{
		lastNameField.sendKeys(lastnamefield);
	}
	
	public void clickOnUpdateButton()
	{
		updateButton.click();
	}
}
