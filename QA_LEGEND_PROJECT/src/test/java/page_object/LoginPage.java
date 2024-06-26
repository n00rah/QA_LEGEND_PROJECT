package page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(id="username")
	WebElement usernameField;
	@FindBy(xpath="//input[@name='password']")
	WebElement passwordField;
	@FindBy(xpath="//button[@class='btn btn-primary']")
	WebElement loginButton;
	@FindBy(xpath="//strong[text()='These credentials do not match our records.']")
	WebElement errorMessage;
	@FindBy(xpath="//a[@class='btn btn-link']")
	WebElement forgotPasswordButton;
	
	public void enterUserName(String username)
	{
		usernameField.sendKeys(username);
	}
	public void enterPassWord(String password)
	{
		passwordField.sendKeys(password);
	}
	public HomePage clickOnLoginButton()
	 {
		 loginButton.click();
		 return new HomePage(driver);
		 
	 }
	public String invalidLoginErrorMessage()
	{
		String errormsg=errorMessage.getText();
		return errormsg;
	}
	public String homePageTitle()
	{
		String homepagetitle=driver.getTitle();
		System.out.println(homepagetitle);
		return homepagetitle;
	}
	public ResetPage clickOnforgotPassword()
	{
		forgotPasswordButton.click();
		return new ResetPage(driver);
	}
	

}
