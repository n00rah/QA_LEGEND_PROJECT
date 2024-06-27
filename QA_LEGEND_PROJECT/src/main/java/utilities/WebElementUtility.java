package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WebElementUtility {
	public static boolean verifyisEnabled(WebElement element) {
		boolean status = element.isEnabled();
		return status;
	}

	public static boolean verifyisSelected(WebElement element) {
		boolean status = element.isSelected();
		return status;
	}

	public static boolean verifyisDisplayed(WebElement element) {
		boolean status = element.isDisplayed();
		return status;
	}

	public static void verifyMouseRightClick(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.contextClick(element).build().perform();
	}

	public static void verifyMouseDoubleClick(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.doubleClick(element).build().perform();
	}

	public static void verifyMouseOver(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}

	public void verifyMoveToElement(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}

	public void verifyMoveByOffset(WebDriver driver, int xOffset, int yOffset) {
		Actions action = new Actions(driver);
		action.moveByOffset(xOffset, yOffset);
	}

	public void verifyMoveToElementOffset(WebDriver driver, WebElement element, int xOffset, int yOffset) {
		Actions action = new Actions(driver);
		action.moveToElement(element, xOffset, yOffset);
	}

	public void verifyMoveToLocation(WebDriver driver, WebElement element, int xCordinate, int yCordinate) {
		Actions action = new Actions(driver);
		action.moveToLocation(xCordinate, yCordinate);
	}

	public void verifyClickAndHold(WebDriver driver) {
		Actions action = new Actions(driver);
		action.clickAndHold();
	}

	public static void verifyMouseRelease(WebDriver driver) {
		Actions action = new Actions(driver);
		action.release();
	}

	public static void verifyDragAndDrop(WebDriver driver, WebElement drag, WebElement drop) {
		Actions action = new Actions(driver);
		action.dragAndDrop(drag, drop).build().perform();
	}

	public static void verifyDragAndDropOffset(WebDriver driver, WebElement drag, int xoffset, int yoffset) {
		Actions action = new Actions(driver);
		action.dragAndDropBy(drag, xoffset, yoffset).build().perform();
	}

}
