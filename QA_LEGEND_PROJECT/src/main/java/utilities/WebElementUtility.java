package utilities;

import org.openqa.selenium.WebElement;

public class WebElementUtility 
{
	public static boolean verifyisEnabled(WebElement element)
	{
		boolean status=element.isEnabled();
		return status;		
	}
	public static boolean verifyisSelected(WebElement element)
	{
		boolean status=element.isSelected();
		return status;		
	}
	public static boolean verifyisDisplayed(WebElement element)
	{
		boolean status=element.isDisplayed();
		return status;		
	}
}
