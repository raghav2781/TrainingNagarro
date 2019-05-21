package demo.cucumber.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import projectUtilities.BasePage;

public class HomePage extends BasePage {
	public void signIn(String userName, String password) throws Exception {
		WebElement logInButton = driver.findElement(By.xpath("//input[@value='LOGIN']"));
		WebElement userNameField = driver.findElement(By.xpath("//input[@name='uid']"));
		WebElement passwordField = driver.findElement(By.xpath("//input[@name='password']"));
		// Thread.sleep(10000);
		userNameField.sendKeys(userName);
		passwordField.sendKeys(password);
		logInButton.click();
	}

}
