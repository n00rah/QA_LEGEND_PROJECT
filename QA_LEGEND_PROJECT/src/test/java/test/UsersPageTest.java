package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Constants;
import constants.Messages;
import page_object.AddUserPage;
import page_object.HomePage;
import page_object.LoginPage;
import page_object.UsersPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;
import utilities.WaitUtility;

public class UsersPageTest extends Base
{
	@Test
	public void verifyViewFunctionality()
	{
		LoginPage login=new LoginPage(driver);
		login.enterUserName(ExcelUtility.getStringData(1,0,Constants.LOGIN_PAGE));
		login.enterPassWord(ExcelUtility.getIntegerData(1,1,Constants.LOGIN_PAGE));
		HomePage home=login.clickOnLoginButton();
		home.clickOnEndTourButton();
		home.clickOnUserManagement();
		home.clickOnUsers();
		UsersPage user=new UsersPage(driver);
		user.enterSearchData(ExcelUtility.getStringData(1,0,Constants.USERS_PAGE));
		user.clickOnViewButton();
		String actualProfileName=user.getProfileName();
		String expectedProfileName=ExcelUtility.getStringData(1,4,Constants.USERS_PAGE);
		Assert.assertEquals(actualProfileName,expectedProfileName,Messages.FAILED_VIEW);
	}
	@Test
	public void verifyEditFunctionality()
	{
		LoginPage login=new LoginPage(driver);
		login.enterUserName(ExcelUtility.getStringData(1,0,Constants.LOGIN_PAGE));
		login.enterPassWord(ExcelUtility.getIntegerData(1,1,Constants.LOGIN_PAGE));
		HomePage home=login.clickOnLoginButton();
		home.clickOnEndTourButton();
		home.clickOnUserManagement();
		UsersPage user=home.clickOnUsers();
		user.enterSearchData(ExcelUtility.getStringData(1, 0,Constants.USERS_PAGE));
		AddUserPage adduser=user.clickOnEditButton();
		adduser.getSelectRole();
		user.clickOnUpdateButton();
		String actualPageHeading=user.getPageHeading();
		String expectedPageHeading=ExcelUtility.getStringData(1, 2,Constants.USERS_PAGE);
		Assert.assertEquals(actualPageHeading, expectedPageHeading,Messages.FAILED_EDIT);
		
	}
	
	@Test
	public void verifyDeleteFunctionality()
	{
		String prefix=RandomDataUtility.getPrefix();
		String firstName=RandomDataUtility.getFirstName();
		String lastName=RandomDataUtility.getLastName();
		String emailid=firstName+lastName+Constants.MAIL_EXTENSION;
		String actualEmailId=emailid;
		String userName=firstName+Constants.USERNAME_EXTENSION+lastName;
		String password=firstName+Constants.PASSWORD_EXTENSION+lastName;
		
		LoginPage login=new LoginPage(driver);
		login.enterUserName(ExcelUtility.getStringData(1,0,Constants.ADDUSER_PAGE));
		login.enterPassWord(ExcelUtility.getIntegerData(1,1,Constants.ADDUSER_PAGE));
		login.clickOnLoginButton();
		HomePage home=new HomePage(driver);
		home.clickOnEndTourButton();
		home.clickOnUserManagement();
		home.clickOnUsers();
		
		UsersPage user=new UsersPage(driver);
		user.clickOnAddButton();
		
		AddUserPage adduser=new AddUserPage(driver);
		adduser.enterPrefix(prefix);
		adduser.enterFirstName(firstName);
		adduser.enterLastName(lastName);
		adduser.enterEmail(emailid);
		adduser.getSelectRole();
		adduser.enterUserName(userName);
		adduser.enterPassword(password);
		adduser.enterConfirmPassword(password);
		adduser.enterSalesCommissionPercent();
		adduser.clickOnSaveButton();
		
		user.enterSearchData(emailid);
		user.clickOnDeleteButton();
		user.clickOnDeletePopupOkButton();
		user.enterSearchData(emailid);
		String actualtext=user.getSearchResultAfterDelete();
		String expectedtext=ExcelUtility.getStringData(1,3,Constants.USERS_PAGE);
		Assert.assertEquals(actualtext, expectedtext, Messages.FAILED_DELETE);
	}
		
}
