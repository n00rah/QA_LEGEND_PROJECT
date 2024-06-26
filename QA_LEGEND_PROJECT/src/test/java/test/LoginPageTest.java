package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import dataProvider.DataProviders;
import page_object.HomePage;
import page_object.LoginPage;
import utilities.ExcelUtility;

public class LoginPageTest extends Base
{
	@Test
	public  void verifyLoginWithValidCredentials()
	{
		String username=ExcelUtility.getStringData(1,0,"LoginPage");
		String password=ExcelUtility.getIntegerData(1,1,"LoginPage");
		LoginPage login=new LoginPage(driver);
		login.enterUserName(username);
		login.enterPassWord(password);
		HomePage home=login.clickOnLoginButton();
		String actualtext=home.getUserNameTextDisplay();
		String expectedtext=ExcelUtility.getStringData(1,2,"LoginPage");
		Assert.assertEquals(actualtext, expectedtext,"User Login with valid credentials failed");
		
	}
	
	@Test(dataProvider="InvalidLogincredentials",dataProviderClass=DataProviders.class)
	public void verifyErrorMsgWhileLoginWithInvalidCredentials(String username,String password)
	{
		LoginPage login=new LoginPage(driver);
		login.enterUserName(username);
		login.enterPassWord(password);
		HomePage home=login.clickOnLoginButton();
		String actualErrorMessage=login.invalidLoginErrorMessage();
		String expectedErrorMessage=ExcelUtility.getStringData(1,3,"LoginPage");
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage,"LOGIN SUCCESSFULL WITH INVALID CREDENTIALS");
	}	
	

}
