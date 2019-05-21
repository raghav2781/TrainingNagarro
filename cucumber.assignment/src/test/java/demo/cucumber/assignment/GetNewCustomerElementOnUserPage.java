package demo.cucumber.assignment;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import projectUtilities.BasePage;

public class GetNewCustomerElementOnUserPage extends BasePage {
	@FindBy(xpath="//a[contains(text(),'New Customer')]")
	WebElement newCustomer;
	
	public GetNewCustomerElementOnUserPage(){
		PageFactory.initElements(driver, this);
	}
	
	public String actualText(){
		return newCustomer.getText();
	}
	

}
