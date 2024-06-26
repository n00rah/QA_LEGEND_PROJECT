package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import page_object.HomePage;
import page_object.LoginPage;
import page_object.ProfilePage;
import utilities.ExcelUtility;

public class ProfilePageTest extends Base
{
	@Test
	public void verifyProfileUpdate()
	{
		String userName=ExcelUtility.getStringData(1,0,"LoginPage");
		String passWord=ExcelUtility.getIntegerData(1,1,"LoginPage");
		String firstName=ExcelUtility.getStringData(1,0,"ProfilePage");
		String lastName=ExcelUtility.getStringData(1,1,"ProfilePage");
		
		LoginPage login=new LoginPage(driver);
		login.enterUserName(userName);
		login.enterPassWord(passWord);
		
		HomePage home=login.clickOnLoginButton();
		home.clickOnEndTourButton();
		home.clickOnProfileTab();
		
		ProfilePage profile=new ProfilePage(driver);
		profile.clickOnProfileTab();
		profile.clearLastNameField();
		profile.enterLastName(lastName);
		profile.clickOnUpdateButton();
		
		String actualUserName=home.getUserNameText();
		String expectedUserName=firstName+" "+lastName;
		Assert.assertEquals(actualUserName, expectedUserName,"PROFILE UPDATION FAILED");
				
	}

}
