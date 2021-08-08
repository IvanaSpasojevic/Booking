package object;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import resource.HotelsPageConstants;

public class HotelsPage {

	public static void enterHotelName(WebDriver driver) {

		driver.findElement(By.id(HotelsPageConstants.SEARCH_BOX_ID)).sendKeys(HotelsPageConstants.HOTEL_NAME);

		driver.findElement(By.xpath(HotelsPageConstants.SEARCH_DROPDOWN_XPATH)).click();

		driver.findElement(By.xpath(HotelsPageConstants.SEARCH_BUTTON_XPATH)).click();

		try {
			Thread.sleep(4000);
		} catch (Exception e) {
		}

		driver.findElement(By.xpath(HotelsPageConstants.HOTEL_LINK_XPATH)).click();

		try {
			Thread.sleep(4000);
		} catch (Exception e) {
		}

		switchTab(driver);

	}

	private static void switchTab(WebDriver driver) {
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.close();
		driver.switchTo().window(tabs.get(1));
	}

	public static boolean findHotel(WebDriver driver) {

		try {
			String innerHtml = driver.findElement(By.id(HotelsPageConstants.HOTEL_NAME_HEADER_ID))
					.getAttribute("innerHTML");
			if (innerHtml.contains("Novotel Paris Les Halles"))
				return true;
			else
				return false;
		} catch (Exception e) {
			return false;
		}
	}

}
