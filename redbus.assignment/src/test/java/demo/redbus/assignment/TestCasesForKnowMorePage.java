package demo.redbus.assignment;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pages.KnowMorePage;
import project.utilities.BasePage;

public class TestCasesForKnowMorePage extends BasePage {

	@Test(priority = 0)
	public void knowMoreWindowTest() throws Exception {
		ExtentTest test = extent.createTest("know More Window Test");
		writeDataInNewRowNewColumn("Test1-To Check whether the KnowMore page is redirected from Home page or not", 0, rowNumber, 0);
		
		KnowMorePage page = new KnowMorePage();
		page.openKnowMorePage();
		String title = driver.getTitle();
		try {
			Assert.assertEquals(title, "Track My Bus - redBus");
			test.log(Status.PASS, "KnowMore page is getting redirect from home page");
			writeDataInExistedRowNewColumn("PASS", 0, rowNumber, 1);
		} catch (AssertionError e) {
			test.log(Status.FAIL, "KnowMore page is not getting redirect from home page");
			writeDataInExistedRowNewColumn("PASS", 0, rowNumber, 1);
		}
		page.clickOnHomePage();
		rowNumber++;

	}

	@Test(priority = 1)
	public void redirectAppStoreFromKnowMoreWindowTest() throws Exception {
		writeDataInNewRowNewColumn("Test2-To Check whether the AppStore page is redirected from KnowMore page or not", 0, rowNumber, 0);
		
		ExtentTest test = extent.createTest("redirect AppStore From KnowMore page Test");
		KnowMorePage page = new KnowMorePage();
		page.openKnowMorePage();
		page.clickOnDownloadRedBusApp();
		page.clickOnAppStoreButton();
		String parent = driver.getWindowHandle();
		Set<String> allWindow = driver.getWindowHandles();
		for (String child : allWindow) {
			if (!parent.equalsIgnoreCase(child)) {
				driver.switchTo().window(child);

			}

		}
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@id='ac-gn-firstfocus']")));
		String url = driver.getCurrentUrl();
		try {
			Assert.assertEquals(url, "https://itunes.apple.com/in/app/redbus/id733712604?mt=8");
			test.log(Status.PASS, "App store is redirectable from know more page");
			writeDataInExistedRowNewColumn("PASS", 0, rowNumber, 1);
		} catch (AssertionError e) {
			test.log(Status.FAIL, "App store is not redirectable from know more page");
			writeDataInExistedRowNewColumn("FAIL", 0, rowNumber, 1);
		}
		driver.close();
		driver.switchTo().window(parent);
		rowNumber++;

	}

	@Test(priority = 2)
	public void redirectPlayStoreFromKnowMoreWindowTest() throws Exception {
		writeDataInNewRowNewColumn("Test3- To check Whether the PlayStore Page is redirected from KnowMore Page or not",0, rowNumber, 0);
		
		ExtentTest test = extent.createTest("redirect Play Store From KnowMore page Test");
		KnowMorePage page = new KnowMorePage();
		// page.openKnowMorePage();
		// page.clickOnDownloadRedBusApp();
		page.clickOnPlayStoreButton();
		String parent = driver.getWindowHandle();
		Set<String> allWindow = driver.getWindowHandles();
		for (String child : allWindow) {
			if (!parent.equalsIgnoreCase(child)) {
				driver.switchTo().window(child);

			}

		}
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//img[@class='gb_ma']")));
		String url = driver.getCurrentUrl();
		try {
			Assert.assertEquals(url, "https://play.google.com/store/apps/details?id=in.redbus.android&hl=en");
			test.log(Status.PASS, "Play store is redirectable from know more page");
			writeDataInExistedRowNewColumn("PASS", 0, rowNumber, 1);

		} catch (AssertionError e) {
			test.log(Status.FAIL, "Play store is not redirectable from know more page");
			writeDataInExistedRowNewColumn("FAIL", 0, rowNumber, 1);
		}
		driver.close();
		driver.switchTo().window(parent);

		Thread.sleep(2000);
		rowNumber++;
	}

	@Test(priority = 3)
	public void redirectWindowStoreFromKnowMoreWindow() throws Exception {
		writeDataInNewRowNewColumn("Test4- To check whether the WindowsAppStore is redirected from KnowMore page or not", 0, rowNumber, 0);
		
		ExtentTest test = extent.createTest("redirect Windows app Store From KnowMore page Test");
		KnowMorePage page = new KnowMorePage();

		page.clickOnWindowsPhoneStore();
		Thread.sleep(3000);
		String parent = driver.getWindowHandle();
		Set<String> allWindow = driver.getWindowHandles();
		for (String child : allWindow) {
			if (!parent.equalsIgnoreCase(child)) {
				driver.switchTo().window(child);

			}

		}
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@id='uhfLogo']")));
		String title = driver.getTitle();
		try {
			Assert.assertEquals(title, "Buy redBus.in - Microsoft Store en-IN");
			test.log(Status.PASS, "Window app store is redirectable from know more page");
			writeDataInExistedRowNewColumn("PASS", 0, rowNumber, 1);
		} catch (AssertionError e) {
			test.log(Status.FAIL, "Windows app store is not redirectable from know more page");
			writeDataInExistedRowNewColumn("FAIL", 0, rowNumber, 1);
		}
		driver.close();
		driver.switchTo().window(parent);
		page.clickOnHomePage();
		Thread.sleep(2000);
		rowNumber++;
	}

}
