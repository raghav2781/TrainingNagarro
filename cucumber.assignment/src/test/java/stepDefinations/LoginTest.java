package stepDefinations;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import demo.cucumber.assignment.HomePage;
import projectUtilities.BasePage;

public class LoginTest extends BasePage {
	
	

	@Given("^open chrome and get url$")
	public void open_chrome_and_get_url() throws Exception {
		invokeDriver();

	}

	@When("^login by providing correct \"(.*)\" and \"(.*)\"")
	public void login_by_providing_correct_username_and_password(String username, String password) throws Exception {
		HomePage home = new HomePage();
		home.signIn(username, password);

	}

	@Then("^check whether logged in or not$")
	public void check_whether_logged_in_or_not() {
		ExtentTest logger=extent.createTest("login withcorrect credentials");
		try {
			driver.switchTo().alert().dismiss();
			logger.log(Status.FAIL, "not loginable with correct credential");
		} catch (Exception e) {
			logger.log(Status.PASS, "loginable with correct credential");
		}
	}

	@Then("^quit driver$")
	public void quit_driver() {


	}

}
