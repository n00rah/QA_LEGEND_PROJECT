package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Constants;
import constants.Messages;
import dataProvider.DataProviders;
import page_object.HomePage;
import page_object.LoginPage;
import utilities.ExcelUtility;

public class LoginPageTest extends Base
{
	@Test(groups="Regression")
	public  void verifyLoginWithValidCredentials()
	{
		String username=ExcelUtility.getStringData(1,0,Constants.LOGIN_PAGE);
		String password=ExcelUtility.getIntegerData(1,1,Constants.LOGIN_PAGE);
		LoginPage login=new LoginPage(driver);
		login.enterUserName(username);
		login.enterPassWord(password);
		HomePage home=login.clickOnLoginButton();
		String actualtext=home.getUserNameTextDisplay();
		String expectedtext=ExcelUtility.getStringData(1,2,Constants.LOGIN_PAGE);
		Assert.assertEquals(actualtext, expectedtext,Messages.LOGIN_FAILED);
		
	}
	
	@Test(dataProvider="InvalidLogincredentials",dataProviderClass=DataProviders.class,groups="Sanity")
	public void verifyErrorMsgWhileLoginWithInvalidCredentials(String username,String password)
	{
		LoginPage login=new LoginPage(driver);
		login.enterUserName(username);
		login.enterPassWord(password);
		HomePage home=login.clickOnLoginButton();
		String actualErrorMessage=login.invalidLoginErrorMessage();
		String expectedErrorMessage=ExcelUtility.getStringData(1,3,Constants.LOGIN_PAGE);
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage,Messages.INVALIDLOGIN_SUCCESSFULL);
	}	
	

}
