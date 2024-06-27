package utilities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	public static void selectByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}

	public static void selectByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	public static void selectByVisibleText(WebElement element, String visibletext) {
		Select select = new Select(element);
		select.selectByVisibleText(visibletext);
	}

	public static void clickOnAlertAcceptButton(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	public static void clickOnAlertDeleteButton(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}

	public static void enterDataInPromptAlert(WebDriver driver, String text) {
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(text);
	}

	public static void verifyFrameSwitchingUsingWebElement(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}

	public static void verifyFrameSwitchingUsingIndexNumber(WebDriver driver, int index) {
		driver.switchTo().frame(index);

	}

	public static void verifyFrameSwitchingUsingId(WebDriver driver, int index, String id) {
		driver.switchTo().frame(id);
	}

	public static void verifyFrameSwitchingUsingName(WebDriver driver, int index, String framename) {
		driver.switchTo().frame(framename);
	}
}
