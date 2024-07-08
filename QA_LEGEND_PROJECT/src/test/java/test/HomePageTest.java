package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Constants;
import constants.Messages;
import page_object.HomePage;
import page_object.LoginPage;
import utilities.ExcelUtility;

public class HomePageTest extends Base
{
	@Test
	
public void verifyUserLoginDate()
{
	String username=ExcelUtility.getStringData(1,0,Constants.LOGIN_PAGE);
	String password=ExcelUtility.getIntegerData(1,1,Constants.LOGIN_PAGE);
	LoginPage login=new LoginPage(driver);
	login.enterUserName(username);
	login.enterPassWord(password);
	HomePage home=login.clickOnLoginButton();
	home.clickOnEndTourButton();
	String homePageDate=home.getLoginDate();
	String currentDate=home.getCurrentDate();
	Assert.assertEquals(homePageDate, currentDate,Messages.DATE_MISMATCH);	
}
}
