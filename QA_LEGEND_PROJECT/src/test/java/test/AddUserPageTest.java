package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
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
		String emailId=firstName+lastName+"@gmail.com";
		String actualemailId=emailId;
		String userName=firstName+"00"+lastName;
		String password=firstName+"11"+lastName;
		
		LoginPage login=new LoginPage(driver);
		login.enterUserName(ExcelUtility.getStringData(1,0,"LoginPage"));
		login.enterPassWord(ExcelUtility.getIntegerData(1,1,"LoginPage"));
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
		Assert.assertEquals(actualemailId, expectedemailId,"ADDING NEW USER FAILED");
				
	}
	@Test(retryAnalyzer=RetryAnalyzer.class)
	public void verifyUserLoginWithNewlyaddeduser()
	{

		String prefix=RandomDataUtility.getPrefix();
		String firstName=RandomDataUtility.getFirstName();
		String lastName=RandomDataUtility.getLastName();
		String emailId=firstName+lastName+"@gmail.com";
		String actualemailId=emailId;
		String userName=firstName+"00"+lastName;
		String password=firstName+"11"+lastName;
		
		LoginPage login=new LoginPage(driver);
		login.enterUserName(ExcelUtility.getStringData(1,0,"LoginPage"));
		login.enterPassWord(ExcelUtility.getIntegerData(1,1,"LoginPage"));
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
		String expectedtext=firstName+" "+lastName;
		Assert.assertEquals(actualtext,expectedtext,"NEWLY ADDED USER LOGIN FAILED");
				
	}


}
