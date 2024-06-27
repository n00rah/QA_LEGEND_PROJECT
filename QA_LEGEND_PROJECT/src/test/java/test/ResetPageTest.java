package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Constants;
import constants.Messages;
import page_object.LoginPage;
import page_object.ResetPage;
import utilities.ExcelUtility;

public class ResetPageTest extends Base
{
	@Test(groups="Sanity")
	public void verifyResetPageTitle()
	{
		LoginPage login=new LoginPage(driver);
		ResetPage reset=new ResetPage(driver);
		login.clickOnforgotPassword();
		String actualtitle=reset.resetPageTitle();
		System.out.println(actualtitle);
		String expectedtitle=ExcelUtility.getStringData(1,0,Constants.RESET_PAGE);
		Assert.assertEquals(actualtitle, expectedtitle,Messages.RESET_TITLE_MISMATCH);
		
	}
	@Test(groups="Smoke")
	
	public void verifyErrorMessageWithInvalidEmailId()
	{
		LoginPage login=new LoginPage(driver);
		ResetPage reset=new ResetPage(driver);
		login.clickOnforgotPassword();
		String emailid=ExcelUtility.getStringData(1,1,Constants.RESET_PAGE);
		reset.enterEmailAddress(emailid);
		reset.clickOnPasswordResetLink();
		String actualerrormsg=reset.invalidEmailErrorMessage();
		String expectederrormsg=ExcelUtility.getStringData(1,2,Constants.RESET_PAGE);
		Assert.assertEquals(actualerrormsg, expectederrormsg,Messages.SUCCESSFULL_RESETLINK);
		
	}
	@Test
	public void verifyPasswordResetwithValidEmailId()
	{
		LoginPage login=new LoginPage(driver);
		ResetPage reset=new ResetPage(driver);
		login.clickOnforgotPassword();
		String emailid=ExcelUtility.getStringData(1,3,Constants.RESET_PAGE);
		reset.enterEmailAddress(emailid);
		reset.clickOnPasswordResetLink();
		String actualMailSendStatus=reset.validEmailAlertMessage();
		System.out.println(actualMailSendStatus);
		String expectedMailSendStatus=ExcelUtility.getStringData(1,4,Constants.RESET_PAGE);
		Assert.assertEquals(actualMailSendStatus, expectedMailSendStatus,Messages.UNSUCCESSFULL_RESETLINK);
		
	}


}
