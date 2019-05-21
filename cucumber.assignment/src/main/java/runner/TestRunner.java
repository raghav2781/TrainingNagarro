package runner;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import projectUtilities.BasePage;

@CucumberOptions(features="./features", glue={"stepDefinations"})
public class TestRunner extends BasePage {
	
	private TestNGCucumberRunner testRunner;
	
	@BeforeClass
	public void setUP() throws Exception
	{
		testRunner = new TestNGCucumberRunner(this.getClass());
		
		
		
		
	}
	@Test(dataProvider="features")
	public void login(CucumberFeatureWrapper cucumberFeature)
	{
		testRunner.runCucumber(cucumberFeature.getCucumberFeature());
	}
	@DataProvider
	public Object[][] features()
	{
		return testRunner.provideFeatures();
	}
	@AfterSuite
	public void tearDown()
	{
		testRunner.finish();
		extent.flush();
	}

	
	@BeforeSuite
	public void beforeSuite() throws Exception{
		moveFile("C:\\Users\\sudeeprana\\workspace\\cucumber.assignment\\ExtentReport\\report.html", "./ExtentReport/archive/" + date() + "/report.html");
		extentReport();
	}
	
	


}
