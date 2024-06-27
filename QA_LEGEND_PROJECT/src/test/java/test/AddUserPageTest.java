package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Constants;
import constants.Messages;
import listener.RetryAnalyzer;
import page_object.AddUserPage;
import page_object.HomePage;
import page_object.LoginPage;
import page_object.UsersPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class AddUserPageTest extends Base
{
	@Test
	public void verifyAddUser()
	{
		String prefix=RandomDataUtility.getPrefix();
		String firstName=RandomDataUtility.getFirstName();
		String lastName=RandomDataUtility.getLastName();
		String emailId=firstName+lastName+Constants.MAIL_EXTENSION;
		String actualemailId=emailId;
		String userName=firstName+Constants.USERNAME_EXTENSION+lastName;
		String password=firstName+Constants.PASSWORD_EXTENSION+lastName;
		
		LoginPage login=new LoginPage(driver);
		login.enterUserName(ExcelUtility.getStringData(1,0,Constants.LOGIN_PAGE));
		login.enterPassWord(ExcelUtility.getIntegerData(1,1,Constants.LOGIN_PAGE));
		login.clickOnLoginButton();
		HomePage home=new HomePage(driver);
		home.clickOnEndTourButton();
		home.clickOnUserManagement();
		home.clickOnUsers();
		UsersPage users=new UsersPage(driver);
		users.clickOnAddButton();
		AddUserPage adduser=new AddUserPage(driver);
		adduser.enterPrefix(prefix);
		adduser.enterFirstName(firstName);
		adduser.enterLastName(lastName);
		adduser.enterEmail(emailId);
		adduser.getSelectRole();
		adduser.enterUserName(userName);
		adduser.enterPassword(password);
		adduser.enterConfirmPassword(password);
		adduser.enterSalesCommissionPercent();
		adduser.clickOnSaveButton();
		users.enterSearchData(emailId);
		String expectedemailId=users.getSearchResultText();
		Assert.assertEquals(actualemailId, expectedemailId,Messages.NEWUSER_ADDFAILED);
				
	}
	@Test(retryAnalyzer=RetryAnalyzer.class)
	public void verifyUserLoginWithNewlyaddeduser()
	{

		String prefix=RandomDataUtility.getPrefix();
		String firstName=RandomDataUtility.getFirstName();
		String lastName=RandomDataUtility.getLastName();
		String emailId=firstName+lastName+Constants.MAIL_EXTENSION;
		String actualemailId=emailId;
		String userName=firstName+Constants.USERNAME_EXTENSION+lastName;
		String password=firstName+Constants.PASSWORD_EXTENSION+lastName;
		
		LoginPage login=new LoginPage(driver);
		login.enterUserName(ExcelUtility.getStringData(1,0,Constants.LOGIN_PAGE));
		login.enterPassWord(ExcelUtility.getIntegerData(1,1,Constants.LOGIN_PAGE));
		login.clickOnLoginButton();
		HomePage home=new HomePage(driver);
		home.clickOnEndTourButton();
		home.clickOnUserManagement();
		home.clickOnUsers();
		
		UsersPage users=new UsersPage(driver);
		users.clickOnAddButton();
		
		AddUserPage adduser=new AddUserPage(driver);
		adduser.enterPrefix(prefix);
		adduser.enterFirstName(firstName);
		adduser.enterLastName(lastName);
		adduser.enterEmail(emailId);
		adduser.getSelectRole();
		adduser.enterUserName(userName);
		adduser.enterPassword(password);
		adduser.enterConfirmPassword(password);
		adduser.enterSalesCommissionPercent();
		adduser.clickOnSaveButton();
		
		home.clickOnHomeTab();
		home.clickOnProfileTab();
		home.clickOnSignOut();
		login.enterUserName(userName);
		login.enterPassWord(password);
		login.clickOnLoginButton();
		
		String actualtext=home.getUserNameText();
		String expectedtext=firstName+Constants.INSERT_SPACE+lastName;
		Assert.assertEquals(actualtext,expectedtext,Messages.NEWUSER_LOGINFAILED);
				
	}


}
