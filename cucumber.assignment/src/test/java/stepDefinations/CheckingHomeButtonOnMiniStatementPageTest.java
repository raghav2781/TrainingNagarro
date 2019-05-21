package stepDefinations;

import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import demo.cucumber.assignment.GetMiniStatement;
import projectUtilities.BasePage;

public class CheckingHomeButtonOnMiniStatementPageTest extends BasePage {

	@When("^open mini statement with customer \"([^\"]*)\"$")
	public void open_mini_statement_with_customer(String accountNumber) {
		GetMiniStatement mini = new GetMiniStatement();
		mini.miniStatement(accountNumber);
	}

	@Then("^check whether the home button is displayed or not$")
	public void check_whether_the_home_button_is_displayed_or_not() throws Exception {
		ExtentTest logger = extent.createTest("check whether the home button is displayed or not");
		GetMiniStatement mini = new GetMiniStatement();
		try {
			Assert.assertTrue(mini.displayedOrNot());
			logger.log(Status.PASS, "displayed");
		} catch (AssertionError e) {
			logger.log(Status.FAIL, "not displayed");
			takescreenshot("home_button_is_not_present");
		}

	}

}
