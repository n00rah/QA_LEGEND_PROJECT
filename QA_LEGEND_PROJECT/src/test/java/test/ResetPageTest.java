package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import page_object.LoginPage;
import page_object.ResetPage;
import utilities.ExcelUtility;

public class ResetPageTest extends Base
{
	@Test
	public void verifyResetPageTitle()
	{
		LoginPage login=new LoginPage(driver);
		ResetPage reset=new ResetPage(driver);
		login.clickOnforgotPassword();
		String actualtitle=reset.resetPageTitle();
		System.out.println(actualtitle);
		String expectedtitle=ExcelUtility.getStringData(1,0,"ResetPage");
		Assert.assertEquals(actualtitle, expectedtitle,"RESET PAGE TITLE MISMATCH");
		
	}
	@Test
	
	public void verifyErrorMessageWithInvalidEmailId()
	{
		LoginPage login=new LoginPage(driver);
		ResetPage reset=new ResetPage(driver);
		login.clickOnforgotPassword();
		String emailid=ExcelUtility.getStringData(1,1,"ResetPage");
		reset.enterEmailAddress(emailid);
		reset.clickOnPasswordResetLink();
		String actualerrormsg=reset.invalidEmailErrorMessage();
		String expectederrormsg=ExcelUtility.getStringData(1,2,"ResetPage");
		Assert.assertEquals(actualerrormsg, expectederrormsg,"PASSWORD RESET LINK MAILED SUCCESSFULLY");
		
	}
	@Test
	public void verifyPasswordResetwithValidEmailId()
	{
		LoginPage login=new LoginPage(driver);
		ResetPage reset=new ResetPage(driver);
		login.clickOnforgotPassword();
		String emailid=ExcelUtility.getStringData(1,3,"ResetPage");
		reset.enterEmailAddress(emailid);
		reset.clickOnPasswordResetLink();
		String actualMailSendStatus=reset.validEmailAlertMessage();
		System.out.println(actualMailSendStatus);
		String expectedMailSendStatus=ExcelUtility.getStringData(1,4, "ResetPage");
		Assert.assertEquals(actualMailSendStatus, expectedMailSendStatus,"PASSWORD RESET LINK SHARING UNSUCCESSFULL");
		
	}


}
