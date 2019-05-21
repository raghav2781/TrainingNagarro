package pages;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import project.utilities.BasePage;

public class HomePage extends BasePage {
	@FindBy(xpath = "//input[@id='src']")
	private WebElement source;
	@FindBy(xpath = "//input[@id='dest']")
	private WebElement destination;
	@FindBy(xpath = "//div[@class='fl search-box date-box gtm-onwardCalendar']")
	private WebElement dateBox;
	@FindBy(xpath = "//button[@id='search_btn']")
	private WebElement searchButton;
	@FindBy(xpath="//span[@class='fbicon icon-Facebook']")
	private WebElement facebookButton;
	@FindBy(xpath="//span[@class='twittericon icon-Twitter']")
	private WebElement twitterButton;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public void sourceDate(String monthYear, String date) throws InterruptedException {
		Thread.sleep(700);
		dateBox.click();

		for (int i = 1; i < 13; i++) {
			WebElement dateTitle = driver
					.findElement(By.xpath("//div[@id='rb-calendar_onward_cal']/table[1]/tbody[1]/tr[1]/td[2]"));
			String dateText = dateTitle.getText();
			if (dateText.equals(monthYear)) {
				break;
			}
			if (i == 12) {

				System.out.println("you have entered wrong month or year");
			} else {

				WebElement nextButton = driver
						.findElement(By.xpath("//div[@id='rb-calendar_onward_cal']//button[contains(text(),'>')]"));
				nextButton.click();
				Thread.sleep(1000);
			}

		}
		Thread.sleep(1000);
		List<WebElement> days = driver.findElements(By.xpath("//div[@id='rb-calendar_onward_cal']//tr//td"));
		for (WebElement day : days) {
			String d = day.getText();
			if (d.equals(date)) {
				day.click();
			}
		}

	}

	public void sourceDestinationOnwarddateReturndate(String sourceName, String destinationName, String monthYear,
			String date) throws InterruptedException {
		System.out.println("sudeep");
		// String date=dateTitle.;

		source.sendKeys(sourceName);
		Thread.sleep(700);
		destination.click();
		destination.sendKeys(destinationName);
		sourceDate(monthYear, date);
		searchButton.click();

	}

	@FindBy(xpath = "/html[1]/body[1]/section[1]/header[1]/div[1]/div[1]/div[1]/nav[1]/ul/li/a")
	public List<WebElement> productsNavigation;

	public void clickOnBusTicket() {
		productsNavigation.get(0).click();
	}

	public void clickOnHotels() {
		productsNavigation.get(1).click();
	}

	public void clickOnBusHire() {
		productsNavigation.get(2).click();
	}

	public void clickOnPilgrimages() {
		productsNavigation.get(3).click();
	}

	@FindBy(xpath = "//a[contains(text(),'Help')]")
	private WebElement helpButton;

	public void clickOnHelpButton() {
		helpButton.click();
	}

	public String titleOfHomePage() {
		return driver.getTitle();
	}
	
	public String openFacebookPageAndGetTitle() throws InterruptedException{
		
		action.moveToElement(facebookButton).build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(facebookButton)).click();
		String parent=driver.getWindowHandle();
		Set<String> allWindows=driver.getWindowHandles();
		for(String child:allWindows){
			if(!parent.equalsIgnoreCase(child)){
				driver.switchTo().window(child);
			}
		}
	   Thread.sleep(3000);
		String urlOfFacebookPage=driver.getCurrentUrl();
		driver.close();
		Thread.sleep(2000);
		driver.switchTo().window(parent);
		return urlOfFacebookPage;
	}
	public String openTwitterPageAndGetTitle() throws InterruptedException{
		action.moveToElement(twitterButton).build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(twitterButton)).click();
		String parent=driver.getWindowHandle();
		Set<String> allWindows=driver.getWindowHandles();
		for(String child:allWindows){
			if(!parent.equalsIgnoreCase(child)){
				driver.switchTo().window(child);
			}
		}
	   Thread.sleep(3000);
		String urlOfTwitterPage=driver.getCurrentUrl();
		driver.close();
		Thread.sleep(2000);
		driver.switchTo().window(parent);
		return urlOfTwitterPage;
	}
}
