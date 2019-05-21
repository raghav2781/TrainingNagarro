package demo.redbus.assignment;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pages.HotelsPage;
import project.utilities.BasePage;

public class TestCasesforHotelsPage extends BasePage {
	@Test(priority = 24)
	public void roomSearchTest() throws Exception {
		ExtentTest test = extent.createTest("room search from hotels page Test");
		writeDataInNewRowNewColumn("Test25- To check whether the searching of rooms on Hotels page is working or not", 0, rowNumber, 0);
		HotelsPage page = new HotelsPage();
		Thread.sleep(1000);
		// page.clickOnHotels();
		String city = "Mumbai";
		Thread.sleep(1000);
		page.search(city);
		Thread.sleep(1000);

		page.clickOnSuggestedCity();
		Thread.sleep(1000);
		page.fromDate("Jun 2019", "10");
		Thread.sleep(1000);
		page.toDate("Jun 2019", "12");
		Thread.sleep(2000);
		page.clickOnSearch();
		Thread.sleep(9000);
		String x = driver.getTitle();
		try {
			Assert.assertEquals(x, "Hotels in " + city + " - redBus");
			test.log(Status.PASS, "working");
			writeDataInExistedRowNewColumn("PASS", 0, rowNumber, 1);
		} catch (AssertionError e) {
			test.log(Status.FAIL, "not working");
			writeDataInExistedRowNewColumn("FAIL", 0, rowNumber, 1);
		}
		driver.get("https://www.redbus.in/");
		rowNumber++;
	}

	@Test(priority = 23)
	public void areAllTopHotelsInIndiaEnabledOnHotelsPageTest() throws Exception {
		writeDataInNewRowNewColumn("Test24- To check whether the searching of rooms on Hotels page is working or not", 0, rowNumber, 0);
		ExtentTest test = extent.createTest("testing the presnece of element in the navigation bar");
		HotelsPage page = new HotelsPage();
		// page.clickOnHotels();
		int size = page.topHotelsInIndia.size();
		int count = 0;
		for (WebElement hotel : page.topHotelsInIndia) {
			try {
				Assert.assertTrue(hotel.isEnabled());
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
		}rowNumber++;
		// driver.get("https://www.redbus.in/");

	}

	@Test(priority = 17)
	public void areAllBangloreAreasEnabledOnHotelsPageTest() throws Exception {
		writeDataInNewRowNewColumn("Test18- To check whether the all visible banglore location on Hotels page are enabled or not", 0, rowNumber, 0);
		ExtentTest test = extent.createTest("all banglore areas enable on hotel page Test");
		HotelsPage page = new HotelsPage();
		page.clickOnHotels();
		int size = page.allBangloreAreas.size();
		int count = 0;
		for (WebElement area : page.allBangloreAreas) {
			try {
				Assert.assertTrue(area.isEnabled());
				count++;
			} catch (AssertionError e) {
				break;
			}
		}
		if (count == size) {
			test.log(Status.PASS, "all elements are enabled");
			writeDataInExistedRowNewColumn("PASS", 0, rowNumber, 1);
		} else {
			test.log(Status.FAIL, "All elements are not enabled");
			writeDataInExistedRowNewColumn("FAIL", 0, rowNumber, 1);
		}rowNumber++;
	}

	@Test(priority = 19)
	public void areAllHydrabadAreasEnabledOnHotelsPageTest() throws Exception {
		writeDataInNewRowNewColumn("Test20- To check whether the all visible Hydrabad location on Hotels page are enabled or not", 0, rowNumber, 0);
		ExtentTest test = extent.createTest("all Hyderabad areas enable on hotel page Test");
		HotelsPage page = new HotelsPage();
		// page.clickOnHotels();
		int size = page.allHydrabadAreas.size();
		int count = 0;
		for (WebElement area : page.allHydrabadAreas) {
			try {
				Assert.assertTrue(area.isEnabled());
				count++;
			} catch (AssertionError e) {
				break;
			}
		}
		if (count == size) {
			test.log(Status.PASS, "all elements are enabled");
			writeDataInExistedRowNewColumn("PASS", 0, rowNumber, 1);
		} else {
			test.log(Status.FAIL, "All elements are not enabled");
			writeDataInExistedRowNewColumn("FAIL", 0, rowNumber, 1);
		}rowNumber++;
	}

	@Test(priority = 20)
	public void areAllChennaiAreasEnabledOnHotelsPageTest() throws Exception {
		writeDataInNewRowNewColumn("Test21- To check whether the all visible Chennai location on Hotels page are enabled or not", 0, rowNumber, 0);
		ExtentTest test = extent.createTest("all chennai areas enable on hotel page Test");
		HotelsPage page = new HotelsPage();
		// page.clickOnHotels();
		int size = page.allChennaiAreas.size();
		int count = 0;
		for (WebElement area : page.allChennaiAreas) {
			try {
				Assert.assertTrue(area.isEnabled());
				count++;
			} catch (AssertionError e) {
				break;
			}
		}
		if (count == size) {
			test.log(Status.PASS, "all elements are enabled");
			writeDataInExistedRowNewColumn("PASS", 0, rowNumber, 1);
		} else {
			test.log(Status.FAIL, "All elements are not enabled");
			writeDataInExistedRowNewColumn("FAIL", 0, rowNumber, 1);
		}rowNumber++;
	}

	@Test(priority = 21)
	public void areAllPuneAreasEnabledOnHotelsPageTest() throws Exception {
		writeDataInNewRowNewColumn("Test22- To check whether the all visible Pune location on Hotels page are enabled or not", 0, rowNumber, 0);
		ExtentTest test = extent.createTest("all Pune areas enable on hotel page Test");
		HotelsPage page = new HotelsPage();
		// page.clickOnHotels();
		int size = page.allPuneAreas.size();
		int count = 0;
		for (WebElement area : page.allPuneAreas) {
			try {
				Assert.assertTrue(area.isEnabled());
				count++;
			} catch (AssertionError e) {
				break;
			}
		}
		if (count == size) {
			test.log(Status.PASS, "all elements are enabled");
			writeDataInExistedRowNewColumn("PASS", 0, rowNumber, 1);
		} else {
			test.log(Status.FAIL, "All elements are not enabled");
			writeDataInExistedRowNewColumn("FAIL", 0, rowNumber, 1);
		}rowNumber++;
	}

	@Test(priority = 22)
	public void areAllMumbaiAreasEnabledOnHotelsPageTest() throws Exception {
		writeDataInNewRowNewColumn("Test23- To check whether the all visible Mumbai location on Hotels page are enabled or not", 0, rowNumber, 0);
		ExtentTest test = extent.createTest("all mumbai areas enable on hotel page Test");
		HotelsPage page = new HotelsPage();
		// page.clickOnHotels();
		int size = page.allMumbaiAreas.size();
		int count = 0;
		for (WebElement area : page.allMumbaiAreas) {
			try {
				Assert.assertTrue(area.isEnabled());
				count++;
			} catch (AssertionError e) {
				break;
			}
		}
		if (count == size) {
			test.log(Status.PASS, "all elements are enabled");
			writeDataInExistedRowNewColumn("PASS", 0, rowNumber, 1);
		} else {
			test.log(Status.FAIL, "All elements are not enabled");
			writeDataInExistedRowNewColumn("FAIL", 0, rowNumber, 1);
		}rowNumber++;
	}

	@Test(priority = 18)
	public void titleVerificationOfHotelsPage() throws Exception {
		writeDataInNewRowNewColumn("Test19- To check whether the Title of Hotels page is matched with expected one or not", 0, rowNumber, 0);
		ExtentTest test = extent.createTest("title verification of hotels page Test");
		HotelsPage page = new HotelsPage();
		try {
			Assert.assertEquals(page.titleOfHotelsPage(),
					"Online Hotel Booking: Cheap, Budget & Luxury Star Hotels India – redBus.in");
			test.log(Status.PASS, "title verified");
			writeDataInExistedRowNewColumn("PASS", 0, rowNumber, 1);
		} catch (AssertionError e) {
			test.log(Status.FAIL, "title not verified");
			writeDataInExistedRowNewColumn("FAIL", 0, rowNumber, 1);
		}rowNumber++;
	}
}
