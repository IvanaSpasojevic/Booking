package object;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import resource.BookingHomePageConstants;

public class BookingHomePage {

	public static void enterDestination(WebDriver driver) {

		driver.findElement(By.id(BookingHomePageConstants.SEARCHBOX_ID)).sendKeys("Paris");

		driver.findElement(By.xpath(BookingHomePageConstants.PARIS_XPATH)).click();
	}

	public static void chooseDate(WebDriver driver) {

		try {
			Thread.sleep(3000);
		} catch (Exception e) {
		}

		while (!conteinsOctober(driver)) {
			driver.findElement(By.cssSelector(BookingHomePageConstants.NEXT_BUTTON_CSS)).click();
		}

		try {
			Thread.sleep(3000);
		} catch (Exception e) {
		}

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,250)");

		driver.findElement(By.xpath(BookingHomePageConstants.DATE_IN_XPATH)).click();

		driver.findElement(By.xpath(BookingHomePageConstants.DATE_OUT_XPATH)).click();

	}

	private static boolean conteinsOctober(WebDriver driver) {
		try {
			String innerHtml = driver.findElement(By.xpath(BookingHomePageConstants.DIV_SECOND_CALENDAR_XPATH))
					.getAttribute("innerHTML");
			if (innerHtml.contains("October"))
				return true;
			else
				return false;
		} catch (Exception e) {
			return false;
		}

	}

	public static void passengersNum(WebDriver driver) {

		driver.findElement(By.id(BookingHomePageConstants.GUESTS_TOGGLE_ID)).click();

		driver.findElement(By.xpath(BookingHomePageConstants.ADD_CHILD_XPATH)).click();

		driver.findElement(By.xpath(BookingHomePageConstants.CHILD_AGE_BUTTON_XPATH)).click();

		driver.findElement(By.xpath(BookingHomePageConstants.CHILD_AGE_XPATH)).click();

	}

	public static void search(WebDriver driver) {

		driver.findElement(By.xpath(BookingHomePageConstants.SEARCH_XPATH)).click();

	}

	public static boolean conteinsParis(WebDriver driver) {

		try {
			String innerHtml = driver.findElement(By.xpath(BookingHomePageConstants.RESULT_HEADER_XPATH))
					.getAttribute("innerHTML");
			if (innerHtml.contains("Paris:"))
				return true;
			else
				return false;
		} catch (Exception e) {
			return false;
		}
	}

}
