package project.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BasePage {
	public static ExtentReports extent;
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static Actions action;
	public static int rowNumber = 0;
	public static XSSFSheet sh;
	// invoking driver functon 
	public void invokeDriver() throws Exception, InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\sudeeprana\\Desktop\\Selenium\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		openURL();
		wait = new WebDriverWait(driver, 5);
		action = new Actions(driver);

	}
  //for writing data in Excel sheet if row and column are new 
	public void writeDataInNewRowNewColumn(String data, int sheet, int row, int column) throws Exception {
		File src = new File("./config/ExcelReport.xlsx");
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		sh = wb.getSheetAt(sheet);
		sh.createRow(row).createCell(column).setCellValue(data);
		FileOutputStream fout = new FileOutputStream(src);
		wb.write(fout);

	}
	//for writing data in Excel sheet if row is existed and column is new
	public void writeDataInExistedRowNewColumn(String data, int sheet, int row, int column) throws Exception {
		File src = new File("./config/ExcelReport.xlsx");
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		sh = wb.getSheetAt(sheet);
		sh.getRow(row).createCell(column).setCellValue(data);
		FileOutputStream fout = new FileOutputStream(src);
		wb.write(fout);

	}
	//For creating extent report
	public void extentReport() {

		ExtentHtmlReporter reporter = new ExtentHtmlReporter(
				"C:\\Users\\sudeeprana\\workspace\\redbus.assignment\\ExtentReport\\report.html");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
	}
	// For getting Home page
	public void openURL() throws InterruptedException, FileNotFoundException, IOException {
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(
				"https://www.redbus.in/?gclid=Cj0KCQjwtr_mBRDeARIsALfBZA5u8lM0nal3BFHcviAeS2cKbLCkwoJg_wmev4s2T5BBkmJkLh-8uQ4aAgwwEALw_wcB");
	}
	//After suite function
	@AfterSuite
	public void afterClass() {
		driver.quit();
		extent.flush();
		
	}
	//Before suite function
	@BeforeSuite
	public void beforeClass() throws Exception {
		invokeDriver();
		extentReport();
	}

}
