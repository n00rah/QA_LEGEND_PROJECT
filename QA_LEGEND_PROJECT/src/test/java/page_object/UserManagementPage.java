package page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WebElementUtility;

public class UserManagementPage
{
	WebDriver driver;
	public UserManagementPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//span[@class='title' and contains(text(),'Users')]")
	WebElement usersTab;
	@FindBy(xpath="//span[@class='title' and contains(text(),'Roles')]")
	WebElement rolesTab;
	@FindBy(xpath="//span[@class='title' and contains(text(),'Sales Commission ')]")
	WebElement salesCommissionAgentsTab;
	
public void cliclOnUsersTab()
{
	UserManagementPage usermanagement=new UserManagementPage(driver);
	usersTab.click();
}
public boolean verifyUsersTabIsEnabled()
{
	return WebElementUtility.verifyisEnabled(usersTab);

}
public boolean verifyRolesTabIsEnabled()
{
	return WebElementUtility.verifyisEnabled(rolesTab);
	
}
public boolean verifySalesCommisionAgentsTabIsEnabled()
{
	return WebElementUtility.verifyisEnabled(salesCommissionAgentsTab);
	
}

}
