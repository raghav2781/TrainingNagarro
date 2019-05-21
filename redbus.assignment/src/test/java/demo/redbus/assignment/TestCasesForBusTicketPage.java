package demo.redbus.assignment;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pages.BusTicketPage;
import project.utilities.BasePage;

public class TestCasesForBusTicketPage extends BasePage {

	@Test(priority = 13)
	public void areTopRoutesElementsEnabledOnBusTicketPageTest() throws Exception {
		writeDataInNewRowNewColumn(
				"Test14- To check whether the all topRoutes elements are enabled on BusTicket page or not", 0,
				rowNumber, 0);
		ExtentTest test = extent.createTest("Top routes elements enable on bus ticket page Test");
		BusTicketPage page = new BusTicketPage();
		int size = page.allTopRoutesElements.size();
		int count = 0;
		for (WebElement route : page.allTopRoutesElements) {

			try {
				Assert.assertTrue(route.isEnabled());
				count++;
			} catch (Exception e) {
				break;
			}

		}
		if (count == size) {
			test.log(Status.PASS, "all elements are enabled");
			writeDataInExistedRowNewColumn("PASS", 0, rowNumber, 1);
		} else {
			test.log(Status.FAIL, "All elements are not enabled");
			writeDataInExistedRowNewColumn("FAIL", 0, rowNumber, 1);
		}
		rowNumber++;
	}

	@Test(priority = 14)
	public void areAllVisibleBusOperatorsEnabledOnBusTicketPageTest() throws Exception {
		writeDataInNewRowNewColumn(
				"Test15- To check whether the all visible BusOperators elements are enabled on BusTicket page or not",
				0, rowNumber, 0);
		ExtentTest test = extent.createTest("Bus operators elements enable on bus ticket page Test");
		BusTicketPage page = new BusTicketPage();
		int size = page.allVisibleBusOperators.size();
		int count = 0;
		for (WebElement route : page.allVisibleBusOperators) {

			try {
				Assert.assertTrue(route.isEnabled());
				count++;
			} catch (Exception e) {
				break;
			}

		}
		if (count == size) {
			test.log(Status.PASS, "all elements are enabled");
			writeDataInExistedRowNewColumn("PASS", 0, rowNumber, 1);
		} else {
			test.log(Status.FAIL, "All elements are not enabled");
			writeDataInExistedRowNewColumn("FAIL", 0, rowNumber, 1);
		}
		rowNumber++;
	}

	@Test(priority = 15)
	public void areAllVisibleCitiesEnabledOnBusTicketPageTest() throws Exception {
		writeDataInNewRowNewColumn(
				"Test16- To check whether the all visible Cities elements are enabled on BusTicket page or not", 0,
				rowNumber, 0);
		ExtentTest test = extent.createTest("all visible cities enable on bus ticket page Test");
		BusTicketPage page = new BusTicketPage();
		int size = page.allVisibleCities.size();
		int count = 0;
		for (WebElement route : page.allVisibleCities) {

			try {
				Assert.assertTrue(route.isEnabled());
				count++;
			} catch (Exception e) {
				break;
			}
		}
		if (count == size) {
			test.log(Status.PASS, "all elements are enabled");
			writeDataInExistedRowNewColumn("PASS", 0, rowNumber, 1);
		} else {
			test.log(Status.FAIL, "All elements are not enabled");
			writeDataInExistedRowNewColumn("FAIL", 0, rowNumber, 1);
		}
		rowNumber++;

	}

	@Test(priority = 16)
	public void areAllVisibleRTCBusOperatorsEnabledOnBusTicketPageTest() throws Exception {
		writeDataInNewRowNewColumn(
				"Test17- To check whether the all visible RTC's Bus Operators elements are enabled on BusTicket page or not",
				0, rowNumber, 0);
		ExtentTest test = extent.createTest("all visible RTC's bus operators enable on bus ticket page Test");
		BusTicketPage page = new BusTicketPage();
		int size = page.allVisibleRTCBusOperators.size();
		int count = 0;
		for (WebElement route : page.allVisibleRTCBusOperators) {
			try {
				Assert.assertTrue(route.isEnabled());
				count++;
			} catch (Exception e) {
				break;
			}
		}
		if (count == size) {
			test.log(Status.PASS, "all elements are enabled");
			writeDataInExistedRowNewColumn("PASS", 0, rowNumber, 1);
		} else {
			test.log(Status.FAIL, "All elements are not enabled");
			writeDataInExistedRowNewColumn("FAIL", 0, rowNumber, 1);
		}
		rowNumber++;

		driver.get("https://www.redbus.in/");
	}

	@Test(priority = 12)
	public void titleVerificationOfBusTicketPage() throws Exception {
		writeDataInNewRowNewColumn(
				"Test13- To check whether the Title of BusTicket page is matched with expected one or not", 0,
				rowNumber, 0);
		// driver.get("https://www.redbus.in/bus-tickets/");
		ExtentTest test = extent.createTest("title verification of bus ticket page");
		BusTicketPage page = new BusTicketPage();
		page.clickOnBusTicketPage();
		try {
			Assert.assertEquals(page.titleOfBusTicket(),
					"Online Bus Tickets Booking: Book Bus Ticket & Bus Reservation -redBus");
			test.log(Status.PASS, "title verified");
			writeDataInExistedRowNewColumn("PASS", 0, rowNumber, 1);
		} catch (AssertionError e) {
			test.log(Status.FAIL, "title not verified");
			writeDataInExistedRowNewColumn("FAIL", 0, rowNumber, 1);
		}
		rowNumber++;
	}
}
