package demo.redbus.assignment;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pages.HomePage;
import pages.KnowMorePage;
import project.utilities.BasePage;

public class TestCasesForHomePage extends BasePage {
	@Test(priority = 7)
	public void searchTest() throws Exception {
		writeDataInNewRowNewColumn("Test8- To check whether the searching for buses from Home page is working or not",
				0, rowNumber, 0);
		ExtentTest test = extent.createTest("searching bus from home page test");
		HomePage home = new HomePage();
		home.sourceDestinationOnwarddateReturndate("jaipur", "dehradun", "May 2019", "10");
		try {
			wait.until(ExpectedConditions
					.presenceOfElementLocated(By.xpath("//div[@class='onward-modify-btn g-button clearfix fl']")));
			test.log(Status.PASS, "working");
			writeDataInExistedRowNewColumn("PASS", 0, rowNumber, 1);
		} catch (Exception e) {
			test.log(Status.FAIL, "not working");
			writeDataInExistedRowNewColumn("FAIL", 0, rowNumber, 1);
		}
		Thread.sleep(3000);
		KnowMorePage page = new KnowMorePage();
		page.clickOnHomePage();
		rowNumber++;

	}

	@Test(priority = 5)
	public void productsNavigationBarTest() throws Exception {
		ExtentTest test = extent.createTest("testing the presnece of element in the navigation bar");
		writeDataInNewRowNewColumn(
				"Test6- To check whether the element in navigation bar on Home page are enabled or not", 0, rowNumber,
				0);
		HomePage home = new HomePage();
		int size = home.productsNavigation.size();
		int count = 0;
		for (WebElement element : home.productsNavigation) {
			try {
				Assert.assertTrue(element.isEnabled());
				count++;
			} catch (AssertionError e) {
				break;
			}
		}
		if (count == size) {
			test.log(Status.PASS, "All element present in navigation bar are clickable");
			writeDataInExistedRowNewColumn("PASS", 0, rowNumber, 1);
		} else {
			test.log(Status.FAIL, "All element present in navigation bar are not clickable");
			writeDataInExistedRowNewColumn("FAIL", 0, rowNumber, 1);
		}
		rowNumber++;
	}

	@Test(priority = 6)
	public void helpWindowTest() throws Exception {
		ExtentTest test = extent.createTest("redirect of help page from homepage test");
		writeDataInNewRowNewColumn("Test7- To check whether the Help page is redirected from Home page or not", 0,
				rowNumber, 0);
		HomePage home = new HomePage();
		String parent = driver.getWindowHandle();
		home.clickOnHelpButton();
		Set<String> allWindows = driver.getWindowHandles();
		for (String child : allWindows) {
			if (!parent.equalsIgnoreCase(child)) {
				driver.switchTo().window(child);
			}
		}
		WebElement crossButton = driver.findElement(By.xpath("//i[@class='icon-close']"));
		crossButton.click();
		Thread.sleep(1000);
		String title = driver.getTitle();
		try {
			Assert.assertEquals(title, "red:Care");
			test.log(Status.PASS, "help page is redirectable from home page");
			writeDataInExistedRowNewColumn("PASS", 0, rowNumber, 1);
		} catch (AssertionError e) {
			test.log(Status.FAIL, "help page is not redirectable from home page");
			writeDataInExistedRowNewColumn("FAIL", 0, rowNumber, 1);
		}
		driver.close();
		driver.switchTo().window(parent);
		rowNumber++;

	}

	@Test(priority = 8)
	public void redirectHomePagefromBusTicketWindowTest() throws Exception {
		ExtentTest test = extent.createTest("redirect home page from bus ticket window test");
		writeDataInNewRowNewColumn("Test9- To check whether the Home page is redirected from BusTicket page or not", 0,
				rowNumber, 0);
		HomePage home = new HomePage();
		home.clickOnBusTicket();
		Thread.sleep(5000);
		WebElement homePageButton = driver.findElement(By.xpath("//i[@class='icon-redBus_Logo logo-main']"));
		homePageButton.click();
		try {
			Assert.assertEquals(driver.getTitle(), "Book Bus Travels, AC Volvo Bus, Hotels & Bus Hire - redBus");
			test.log(Status.PASS, "home page is redirectable from bus ticket page");
			writeDataInExistedRowNewColumn("PASS", 0, rowNumber, 1);

		} catch (AssertionError e) {
			test.log(Status.FAIL, "home page is not redirectable from bus ticket page");
			writeDataInExistedRowNewColumn("FAIL", 0, rowNumber, 1);
		}
		rowNumber++;
	}

	@Test(priority = 9)
	public void redirectHomePagefromHotelsWindowTest() throws Exception {
		writeDataInNewRowNewColumn("Test10 To check whether the Home page is redirected from Hotels page or not", 0,
				rowNumber, 0);
		ExtentTest test = extent.createTest("redirect home page from Hotels window test");
		HomePage home = new HomePage();
		home.clickOnHotels();
		Thread.sleep(3000);
		WebElement homePageButton = driver.findElement(By.xpath("//a[@class='redbus-logo dib-vm']"));
		homePageButton.click();
		try {
			Assert.assertEquals(driver.getTitle(), "Book Bus Travels, AC Volvo Bus, Hotels & Bus Hire - redBus");
			test.log(Status.PASS, "home page is redirectable from hotels page");
			writeDataInExistedRowNewColumn("PASS", 0, rowNumber, 1);

		} catch (AssertionError e) {
			test.log(Status.FAIL, "home page is not redirectable from hotels page");
			writeDataInExistedRowNewColumn("FAIL", 0, rowNumber, 1);
		}
		rowNumber++;
	}

	@Test(priority = 10)
	public void redirectHomePagefromBusHireWindowTest() throws Exception {
		ExtentTest test = extent.createTest("tredirect home page from Bus Hire window test");
		writeDataInNewRowNewColumn("Test11- To check whether the Home page is redirected from BusHire page or not", 0, rowNumber, 0);
		HomePage home = new HomePage();
		home.clickOnBusHire();
		Thread.sleep(3000);
		WebElement homePageButton = driver.findElement(By.xpath("//a[@class='redbus-logo home-redirect']"));
		homePageButton.click();
		try {
			Assert.assertEquals(driver.getTitle(), "Book Bus Travels, AC Volvo Bus, Hotels & Bus Hire - redBus");
			test.log(Status.PASS, "home page is redirectable from Bus hire page");
			writeDataInExistedRowNewColumn("PASS", 0, rowNumber, 1);
		} catch (AssertionError e) {
			test.log(Status.FAIL, "home page is not redirectable Bus hire page");
			writeDataInExistedRowNewColumn("FAIL", 0, rowNumber, 1);
		}
		rowNumber++;
	}

	@Test(priority = 11)
	public void redirectHomePagefromPilgrimagesWindowTest() throws Exception {
		writeDataInNewRowNewColumn("Test12- To check whether the Home page is redirected from Pilgrimages page or not", 0, rowNumber, 0);
		ExtentTest test = extent.createTest("redirect home page from Pilgrimages window test");
		HomePage home = new HomePage();
		home.clickOnPilgrimages();
		Thread.sleep(1000);
		WebElement homePageButton = driver.findElement(By.xpath("//a[@class='redbus-logo']"));
		homePageButton.click();
		try {
			Assert.assertEquals(driver.getTitle(), "Book Bus Travels, AC Volvo Bus, Hotels & Bus Hire - redBus");
			test.log(Status.PASS, "home page is redirectable from pilgrimages page");
			writeDataInExistedRowNewColumn("PASS", 0, rowNumber, 1);
		} catch (AssertionError e) {
			test.log(Status.FAIL, "home page is not redirectable pilgrimages page");
			writeDataInExistedRowNewColumn("FAIL", 0, rowNumber, 1);
		}
		rowNumber++;
	}

	@Test(priority = 4)
	public void titleVerificationOfHomePageTest() throws Exception {
		writeDataInNewRowNewColumn("Test5- To check whether the Title of Home page is matched with expected one or not", 0, rowNumber, 0);
		ExtentTest test = extent.createTest("verification of title of home page");
		HomePage home = new HomePage();
		try {
			Assert.assertEquals(home.titleOfHomePage(), "Book Bus Travels, AC Volvo Bus, Hotels & Bus Hire - redBus");
			test.log(Status.PASS, "title verified");
			writeDataInExistedRowNewColumn("PASS", 0, rowNumber, 1);
		} catch (AssertionError e) {
			test.log(Status.FAIL, "title not verified");
			writeDataInExistedRowNewColumn("FAIL", 0, rowNumber, 1);
		}
		rowNumber++;
	}

	@Test(priority = 25)
	public void isFacebookPageRedirectingFromHomePageTest() throws Exception {
		ExtentTest test = extent.createTest("facebook page redirect from home page Test");
		writeDataInNewRowNewColumn("Test26- To check whether the Facebook page is redirected from HomePage page or not", 0, rowNumber, 0);
		// driver.get("https://www.redbus.in/");
		HomePage home = new HomePage();

		try {
			Assert.assertEquals(home.openFacebookPageAndGetTitle(), "https://www.facebook.com/redBus.in/");
			test.log(Status.PASS, "fb page is redirectable from home page");
			writeDataInExistedRowNewColumn("PASS", 0, rowNumber, 1);
		} catch (AssertionError e) {
			test.log(Status.FAIL, "fb page is not redirectable from home page");
			writeDataInExistedRowNewColumn("FAIL", 0, rowNumber, 1);

		}
		rowNumber++;
	}

	@Test(priority = 26)
	public void isTwitterPageRedirectingFromHomePageTest() throws Exception {
		ExtentTest test = extent.createTest("twitter page redirect from home page Test");
		writeDataInNewRowNewColumn("Test27- To check whether the Twitter is redirected from HomePage page or not", 0, rowNumber, 0);
		// driver.get("https://www.redbus.in/");
		HomePage home = new HomePage();

		try {
			Assert.assertEquals(home.openTwitterPageAndGetTitle(), "https://twitter.com/redBus_in");
			test.log(Status.PASS, "twitter page is redirectable from home page");
			writeDataInExistedRowNewColumn("PASS", 0, rowNumber, 1);
		} catch (AssertionError e) {
			test.log(Status.FAIL, "twitter page is not redirectable from home page");
			writeDataInExistedRowNewColumn("FAIL", 0, rowNumber, 1);
		}
		rowNumber++;
	}

	@Test(priority = 27)
	public void isSignButtonOnHomePageEnabledTest() throws Exception {
		writeDataInNewRowNewColumn("Test28- To check whether the sign inbutton is working properly", 0, rowNumber, 0);
		ExtentTest test = extent.createTest("sign in button enabled on home page Test");
		WebElement arrow = driver.findElement(By.xpath("//div[@id='sign-in-icon-down']"));
		arrow.click();
		try {
			Assert.assertTrue(driver.findElement(By.xpath("//li[@id='signInLink']")).isEnabled());
			test.log(Status.PASS, "sign in/sign up button is enabled on home page");
			writeDataInExistedRowNewColumn("PASS", 0, rowNumber, 1);
		} catch (AssertionError e) {
			test.log(Status.FAIL, "sign in/sign up button is not enabled on home page");
			writeDataInExistedRowNewColumn("FAIL", 0, rowNumber, 1);
		}
		rowNumber++;

	}

	@Test(priority = 28)
	public void ourGlobalPresenceOnHomePageClickableTest() throws Exception {
		ExtentTest test = extent.createTest("Our global presence cities on home page Test");
		writeDataInNewRowNewColumn("Test29- To check whether the all global presence cities are enabled on Home page or not", 0, rowNumber, 0);
		List<WebElement> allGlobalPresence = driver
				.findElements(By.xpath("/html[1]/body[1]/section[1]/div[2]/main[1]/div[1]/div[10]/div[1]/ul[1]/li"));
		int size = allGlobalPresence.size();
		int count = 0;
		for (WebElement country : allGlobalPresence) {
			try {
				Assert.assertTrue(country.isEnabled());
				count++;
			} catch (Exception e) {
				break;
			}
		}
		if (size == count) {
			test.log(Status.PASS, "all cities are present and enabled");
			writeDataInExistedRowNewColumn("PASS", 0, rowNumber, 1);
		} else {
			test.log(Status.FAIL, "all cities are not enabled");
			writeDataInExistedRowNewColumn("FAIL", 0, rowNumber, 1);
		}
		rowNumber++;

	}

	@Test(priority = 29)
	public void awardsAndRecognitionOnHomePageClickableTest() throws Exception {
		ExtentTest test = extent.createTest("Award and recognition enable on home page Test");
		writeDataInNewRowNewColumn("Test30- To check whether the All visible awards and reconition on Home page are enabled or not", 0, rowNumber, 0);
		List<WebElement> awards = driver.findElements(
				By.xpath("/html[1]/body[1]/section[1]/div[2]/main[1]/div[1]/div[8]/section[1]/div[1]/div[2]/div"));
		int size = awards.size();
		int count = 0;
		for (WebElement award : awards) {
			try {
				Assert.assertTrue(award.isEnabled());
				count++;
			} catch (AssertionError e) {
				break;
			}
		}
		if (size == count) {
			test.log(Status.PASS, "all awards and recognition are present and enabled");
			writeDataInExistedRowNewColumn("PASS", 0, rowNumber, 1);
		} else {
			test.log(Status.FAIL, "all awards and recognition are not enabled");
			writeDataInExistedRowNewColumn("FAIL", 0, rowNumber, 1);
		}
		rowNumber++;
	}


}
