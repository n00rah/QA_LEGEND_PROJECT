package page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResetPage 
{
	WebDriver driver;
	public ResetPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(id="email")
	WebElement emailId;
	@FindBy(xpath="//button[@class='btn btn-primary']")
	WebElement passwordResetLinkButton;
	@FindBy(xpath="//strong[text()='The email must be a valid email address.']")
	WebElement errorMessage;
	@FindBy(xpath="//div[@class='alert alert-success']")
	WebElement alertMessage;
			
	public String resetPageTitle() 
	{
		String resetpagetitle=driver.getTitle();
		System.out.println(resetpagetitle);
		return resetpagetitle;
	}
	public void enterEmailAddress(String email)
	{
		emailId.sendKeys(email);
	}
	public void clickOnPasswordResetLink()
	{
		passwordResetLinkButton.click();
	}

	public String invalidEmailErrorMessage()
	{
		String errormessage=errorMessage.getText();
		System.out.println(errormessage);
		return errormessage;
	}
	public String validEmailAlertMessage()
	{
		String alertmsg=alertMessage.getText();
		//System.out.println(alertmsg);
		return alertmsg;
	}
}
