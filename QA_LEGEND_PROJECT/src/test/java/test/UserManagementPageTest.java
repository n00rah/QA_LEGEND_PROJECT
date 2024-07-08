package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Constants;
import constants.Messages;
import page_object.HomePage;
import page_object.LoginPage;
import page_object.UserManagementPage;
import utilities.ExcelUtility;
import utilities.WebElementUtility;

public class UserManagementPageTest extends Base
{
	@Test
	
	public void verifyUsersTabIsEnabled()
	{
	LoginPage login=new LoginPage(driver);
	login.enterUserName(ExcelUtility.getStringData(1,0,Constants.ADDUSER_PAGE));
	login.enterPassWord(ExcelUtility.getIntegerData(1,1,Constants.ADDUSER_PAGE));
	HomePage home=login.clickOnLoginButton();
	home.clickOnEndTourButton();
	UserManagementPage usermanagement=home.clickOnUserManagement();
	boolean status=usermanagement.verifyUsersTabIsEnabled();
	Assert.assertTrue(status,Messages.USERS_DISABLED);
	}
	@Test
	public void verifyRoleTabIsEnabled()
	{
	LoginPage login=new LoginPage(driver);
	login.enterUserName(ExcelUtility.getStringData(1,0,Constants.ADDUSER_PAGE));
	login.enterPassWord(ExcelUtility.getIntegerData(1,1,Constants.ADDUSER_PAGE));
	HomePage home=login.clickOnLoginButton();
	home.clickOnEndTourButton();
	UserManagementPage usermanagement=home.clickOnUserManagement();
	boolean status=usermanagement.verifyRolesTabIsEnabled();
	System.out.println(status);
	Assert.assertTrue(status,Messages.ROLES_DISABLED);
	
}
	@Test
	public void verifySalesCommissionAgentsTabIsEnabled()
	{
	LoginPage login=new LoginPage(driver);
	login.enterUserName(ExcelUtility.getStringData(1,0,Constants.ADDUSER_PAGE));
	login.enterPassWord(ExcelUtility.getIntegerData(1,1,Constants.ADDUSER_PAGE));
	HomePage home=login.clickOnLoginButton();
	home.clickOnEndTourButton();
	UserManagementPage usermanagement=home.clickOnUserManagement();
	boolean status=usermanagement.verifySalesCommisionAgentsTabIsEnabled();
	Assert.assertTrue(status,Messages.SALESCOMMISSION_DISABLED);
}
}
