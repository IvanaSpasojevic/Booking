package test;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import object.BookingHomePage;
import object.Driver;
import object.HotelsPage;

public class BookingTest {

	WebDriver driver;

	@BeforeClass
	public void createDriver() {
	}

	@BeforeMethod
	public void openDriver() {
		driver = Driver.createDriver();
	}

	private void searchDestinationCommon() {

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		BookingHomePage.enterDestination(driver);

		BookingHomePage.chooseDate(driver);

		BookingHomePage.passengersNum(driver);

		BookingHomePage.search(driver);
	}

	@Test(priority = 1)
	public void searchDestination() {

		searchDestinationCommon();

		assertTrue(BookingHomePage.conteinsParis(driver));

	}

	@Test(priority = 2)
	public void findHotel() {

		searchDestinationCommon();

		HotelsPage.enterHotelName(driver);

		assertTrue(HotelsPage.findHotel(driver));

	}

	@AfterMethod
	public void closeDriver() {

		driver.close();

	}

}
