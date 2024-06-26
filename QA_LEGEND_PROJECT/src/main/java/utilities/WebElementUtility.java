package utilities;

import org.openqa.selenium.WebElement;

public class WebElementUtility 
{
	public static boolean verifyisEnabled(WebElement element)
	{
		boolean status=element.isEnabled();
		return status;
		
			
	}
	
}
