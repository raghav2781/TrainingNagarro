package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import project.utilities.BasePage;

public class HotelsPage extends BasePage {
	@FindBy(xpath = "//input[@id='checkin_date']")
	private WebElement fromDateBox;
	@FindBy(xpath = "/html[1]/body[1]/section[1]/header[1]/div[1]/div[1]/div[1]/nav[1]/ul[1]/li[2]/a[1]")
	private WebElement hotelsButton;
	@FindBy(xpath="//input[@id='search_key']")
	private WebElement searchBox;
	@FindBy(xpath="//button[@id='search_hotel']")
	private WebElement searchbuttton;
	@FindBy(xpath="//body/section[@id='rh_main']/main[@id='rh_content']/div[@class='content']/main[@id='home-page']/div[@class='top-block']/div[@class='search-widget']/div[@id='search_wrapper']/div[@class='suggestion-container clearfix']/div[@class='suggestions-box']/div[1]")
	private WebElement suggestedCity;
	@FindBy(xpath="//div[@class='hotels-list-main']//ul[1]//li")
	public List<WebElement> topHotelsInIndia;
	@FindBy(xpath="/html[1]/body[1]/section[1]/main[1]/div[1]/section[1]/div[2]/div[1]/ul[2]/li/a")
	public List<WebElement> allBangloreAreas;
	@FindBy(xpath="/html[1]/body[1]/section[1]/main[1]/div[1]/section[1]/div[2]/div[1]/ul[3]/li/a")
	public List<WebElement> allHydrabadAreas;
	@FindBy(xpath="/html[1]/body[1]/section[1]/main[1]/div[1]/section[1]/div[2]/div[1]/ul[4]/li/a")
	public List<WebElement> allChennaiAreas;
	@FindBy(xpath="/html[1]/body[1]/section[1]/main[1]/div[1]/section[1]/div[2]/div[1]/ul[5]/li/a")
	public List<WebElement> allPuneAreas;
	@FindBy(xpath="/html[1]/body[1]/section[1]/main[1]/div[1]/section[1]/div[2]/div[1]/ul[6]/li/a")
	public List<WebElement> allMumbaiAreas;

	public HotelsPage() {
		PageFactory.initElements(driver, this);
	}
	public void clickOnHotels() {
		hotelsButton.click();
	}
	public void search(String city){
		searchBox.sendKeys(city);
	}
	public void clickOnSuggestedCity(){
		suggestedCity.click();
	}
	public void fromDate(String monthYear, String date) throws InterruptedException {
		Thread.sleep(700);
		fromDateBox.click();
		Thread.sleep(2000);
		for (int i = 1; i < 13; i++) {
			WebElement dateTitle = driver
					.findElement(By.xpath("//div[@id='rb-calendar_checkin_date']/table[1]/tbody[1]/tr[1]/td[2]"));
			String dateText = dateTitle.getText();
			if (dateText.equals(monthYear)) {
				break;
			}
			if (i == 12) {
				System.out.println("you have entered wrong month or year");
			} else {
				WebElement nextButton = driver
						.findElement(By.xpath("//div[@id='rb-calendar_checkin_date']//button[contains(text(),'>')]"));
				nextButton.click();
				Thread.sleep(1000);
			}
		}
		Thread.sleep(1000);
		List<WebElement> days = driver.findElements(By.xpath("//div[@id='rb-calendar_checkin_date']//tr//td"));
		for (WebElement day : days) {
			String d = day.getText();
			if (d.equals(date)) {
				day.click();
			}
		}

	}
	public void toDate(String monthYear, String date) throws InterruptedException {
		
		Thread.sleep(2000);
		for (int i = 1; i < 13; i++) {
			Thread.sleep(2000);
			WebElement dateTitle = driver
					.findElement(By.xpath("//div[@id='rb-calendar_checkout_date']/table[1]//tbody[1]//tr[1]//td[2]"));
			String dateText = dateTitle.getText();
			if (dateText.equals(monthYear)) {
				break;
			}
			if (i == 12) {
				System.out.println("you have entered wrong month or year");
			} else {
				WebElement nextButton = driver
						.findElement(By.xpath("//div[@id='rb-calendar_checkout_date']//button[contains(text(),'>')]"));
				Thread.sleep(1000);
				nextButton.click();
				
			}
		}
		Thread.sleep(1000);
		List<WebElement> days = driver.findElements(By.xpath("//div[@id='rb-calendar_checkout_date']//tr//td"));
		for (WebElement day : days) {
			String d = day.getText();
			if (d.equals(date)) {
				day.click();
			}
		}

	}
	public void clickOnSearch(){
		searchbuttton.click();
	}
	public String titleOfHotelsPage(){
		return driver.getTitle();
	}
	}

