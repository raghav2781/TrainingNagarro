package stepDefinations;



import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import demo.cucumber.assignment.GetNewCustomerElementOnUserPage;
import projectUtilities.BasePage;

public class CheckingNewCustomerElementOnUserPage extends BasePage {
	
	@Given("^open user page$")
	public void open_user_page() {
	   
	}

	@Then("^check whether New Customer element present or not on user page$")
	public void check_whether_New_Customer_element_present_or_not_on_user_page(){
		ExtentTest logger=extent.createTest("check whether New Customer element present or not on user page");
		GetNewCustomerElementOnUserPage element=new GetNewCustomerElementOnUserPage();
		try{Assert.assertEquals("New Customer", element.actualText());
		logger.log(Status.PASS, "element present");
		
		}catch(Exception e){
			logger.log(Status.FAIL, "element not present");
		}
	}

	@Then("^dismis browser$")
	public void dismis_browser() throws Throwable {
	    driver.quit();
	}



}
