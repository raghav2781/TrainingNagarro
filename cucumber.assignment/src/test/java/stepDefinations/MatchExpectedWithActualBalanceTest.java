package stepDefinations;

import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import demo.cucumber.assignment.GetMiniStatement;
import demo.cucumber.assignment.HomePage;
import projectUtilities.BasePage;

public class MatchExpectedWithActualBalanceTest extends BasePage {

	@Given("^open chrome and get url of bank$")
	public void open_chrome_and_get_url_of_bank() throws Exception {
		invokeDriver();
	}

	@When("^login by providing \"([^\"]*)\" and \"([^\"]*)\"$")
	public void login_by_providing_and(String username, String password) throws Exception {
		HomePage home = new HomePage();
		home.signIn(username, password);
	}

	@When("^open mini statement with customer \"([^\"]*)\" and check balance$")
	public void open_mini_statement_with_customer_and_check_balance(String accountNumber) {
		GetMiniStatement mini = new GetMiniStatement();
		mini.miniStatement(accountNumber);
	}

	@Then("^check whether the actual balance is being match with expected balance$")
	public void check_whether_the_actual_balance_is_being_match_with_expected_balance() {
		GetMiniStatement mini = new GetMiniStatement();
		ExtentTest logger=extent.createTest("check whether the actual balance is being match with expected balance");
		try {
			Assert.assertEquals(mini.actualBalance(), "10000");
			logger.log(Status.PASS, "atual balance, matched with expected balance");
		} catch (Exception e) {
			logger.log(Status.FAIL, "atual balance, not matched with expected balance");
		}
	}

	@Then("^close browser$")
	public void close_browser() {
		driver.quit();
	}

}
