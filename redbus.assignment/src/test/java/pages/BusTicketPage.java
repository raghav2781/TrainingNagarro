package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import project.utilities.BasePage;

public class BusTicketPage extends BasePage {
	@FindBy(xpath="//a[contains(text(),'BUS TICKETS')]")
	private WebElement busTicketPage;
	@FindBy(xpath="/html[1]/body[1]/section[5]/div[1]/ul[1]/li/a")
	public List<WebElement> allTopRoutesElements;
	@FindBy(xpath="/html[1]/body[1]/section[5]/div[1]/ul[2]/li/a")
	public List<WebElement> allVisibleBusOperators;
	@FindBy(xpath="/html[1]/body[1]/section[5]/div[1]/ul[3]/li/a")
	public List<WebElement> allVisibleCities;
	@FindBy (xpath="/html[1]/body[1]/section[5]/div[1]/ul[4]/li/a")
	public List<WebElement> allVisibleRTCBusOperators;
	
	
	
	
	
	
	public BusTicketPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnBusTicketPage(){
		busTicketPage.click();
	}
	public String titleOfBusTicket(){
		return driver.getTitle();
	}
}
