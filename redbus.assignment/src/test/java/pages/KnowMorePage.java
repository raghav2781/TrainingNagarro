package pages;


import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import project.utilities.BasePage;

public class KnowMorePage extends BasePage {
	@FindBy(xpath="//a[@class='redbus-logo home-redirect']")
	private WebElement homeButton;
	@FindBy(xpath="//a[@class='know_more']")
	private WebElement knowMoreButton;
	@FindBy(xpath="//a[contains(text(),'Download redBus App')]")
	private WebElement dwnloadRedbusAppButton;
	@FindBy(xpath="//div[@class='store_links_wrapper']//div[1]//a[1]//img[1]")
	private WebElement appStoreButton;
	@FindBy (xpath="//div[@id='dark_bg']//div[@class='section_content_wrapper']//div[2]//a[1]//img[1]")
	private WebElement playStoreButton;
	@FindBy (xpath="//div[@id='dark_bg']//div[3]//a[1]//img[1]")
	private WebElement windowsStoreButton;

	
	
	
	public KnowMorePage() {
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	
	
	
	public void openKnowMorePage(){
		action.moveToElement(knowMoreButton).build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(knowMoreButton)).click();
	}
	
	public void clickOnDownloadRedBusApp(){
		dwnloadRedbusAppButton.click();
		
	}
	public void clickOnAppStoreButton(){
		appStoreButton.click();
	}
	public void clickOnPlayStoreButton(){
		playStoreButton.click();
	}
	public void clickOnWindowsPhoneStore(){
		windowsStoreButton.click();
	}
	public void clickOnHomePage(){
		homeButton.click();
	}

}
