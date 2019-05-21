package demo.cucumber.assignment;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import projectUtilities.BasePage;

public class GetMiniStatement extends BasePage {

	@FindBy(xpath="//a[contains(text(),'Mini Statement')]")
	private  WebElement miniStatementOption;
	
	@FindBy(xpath="//input[@name='accountno']")
	private  WebElement accountNumberTestField;
	
	
	@FindBy(xpath="//input[@name='AccSubmit']")
	private  WebElement submitButton;
	
	@FindBy(xpath="//td[contains(text(),'10000')]")
	private  WebElement actualBalance;
	
	@FindBy(xpath="//a[contains(text(),'Home')]")
	private WebElement homeButton;
	
public GetMiniStatement(){
	PageFactory.initElements(driver, this);
}
	public void miniStatement(String accountNumber){
		miniStatementOption.click();
		accountNumberTestField.sendKeys(accountNumber);
		submitButton.click();
	}
	public String actualBalance(){
		return actualBalance.getText();
		
	}
	public boolean displayedOrNot(){
		return homeButton.isDisplayed();
	}
	
	
	
	
}
