package projectUtilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BasePage {
	public static WebDriver driver;
	public static ExtentReports extent;
	public ExtentTest logger;

	public void invokeDriver() throws Exception, InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\sudeeprana\\Desktop\\Selenium\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		openURL();

	}

	public void openURL() throws InterruptedException, FileNotFoundException, IOException {
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://demo.guru99.com/V4/");
	}

	public void extentReport() {

		ExtentHtmlReporter reporter = new ExtentHtmlReporter(
				"C:\\Users\\sudeeprana\\workspace\\cucumber.assignment\\ExtentReport\\report.html");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
	}

	public void takescreenshot(String filename) throws Exception {

		TakesScreenshot sc = (TakesScreenshot) driver;
		File source = sc.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(source, new File("./screenshots/" + filename + ".png"));
	}

	public void moveFile(String sourcePath, String targetPath) throws Exception {

		File sourceFile = new File(sourcePath);
		if (sourceFile.exists() == true) {
			File destinationFile = new File(targetPath);
			destinationFile.mkdirs();
			Files.copy(sourceFile.toPath(), destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
		}
	}

	public static String date() {
		String pattern = "yyyy-MM-dd_hh_mm_ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		String date = simpleDateFormat.format(new Date());
		return date;
	}

}
