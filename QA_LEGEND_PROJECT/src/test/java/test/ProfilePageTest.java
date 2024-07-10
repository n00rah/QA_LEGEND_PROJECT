package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Constants;
import constants.Messages;
import page_object.HomePage;
import page_object.LoginPage;
import page_object.ProfilePage;
import utilities.ExcelUtility;

public class ProfilePageTest extends Base
{
	@Test
	public void verifyProfileUpdate()
	{
		String userName=ExcelUtility.getStringData(1,0,Constants.LOGIN_PAGE);
		String passWord=ExcelUtility.getIntegerData(1,1,Constants.LOGIN_PAGE);
		String firstName=ExcelUtility.getStringData(1,0,Constants.PROFILE_PAGE);
		String lastName=ExcelUtility.getStringData(1,1,Constants.PROFILE_PAGE);
		
		LoginPage login=new LoginPage(driver);
		login.enterUserName(userName);
		login.enterPassWord(passWord);
		
		HomePage home=login.clickOnLoginButton();
		home.clickOnEndTourButton();
		ProfilePage profile=home.clickOnProfileTab();
		profile.clickOnProfileTab();
		profile.clearLastNameField();
		profile.enterLastName(lastName);
		profile.clickOnUpdateButton();
		
		String actualUserName=home.getUserNameText();
		String expectedUserName=firstName+Constants.INSERT_SPACE+lastName;
		Assert.assertEquals(actualUserName, expectedUserName,Messages.PROFILE_UPDATION_FAILED);
				
	}

}
