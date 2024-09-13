package automationCore;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constants.Constants;
import utilities.WaitUtility;

public class Base 
{
	protected static WebDriver driver;
	public Properties prop;
	public FileInputStream file;
	public void initialiseBrowser(String browser) {
	try
	{
		prop=new Properties();
		file=new FileInputStream(Constants.CONFIG_FILE);
		prop.load(file);
	}
	catch(FileNotFoundException e)
	{
		e.printStackTrace();
	}
	catch(IOException e)
	{
		e.printStackTrace();
	}
		if(browser.equals("Chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(browser.equals("Firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if(browser.equals("Edge"))
		{
			driver=new EdgeDriver();
		}
		else
		{
			throw new RuntimeException("Invalid Browser");
		}
		//driver.get(prop.getProperty(browser));
		driver.get("https://qalegend.com/billing/public/login");
		driver.manage().window().maximize();
		WaitUtility.waitUsingImplicitWait(driver);
	}
	@BeforeMethod(alwaysRun=true)
	@Parameters("browser")
	public void setUp(String browsername)
	{
		initialiseBrowser(browsername);
	}
@AfterMethod(alwaysRun=true)
	public void closeBrowser(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			takeScreenShot(result);
		}
		driver.close();
	}
	public void takeScreenShot(ITestResult result) throws IOException
	{
		TakesScreenshot takescreenshot=(TakesScreenshot)driver;
		File screenshot=takescreenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot,new File("./Screenshot/"+result.getName()+".png"));
	}

}



















