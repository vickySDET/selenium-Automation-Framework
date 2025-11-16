package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	
	public LoginPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath = "//input[@name=\"username\"]")
	WebElement username;
	
	@FindBy(xpath = "//input[@name=\"password\"]")
	WebElement password;
	
	@FindBy(xpath = "//button[@type=\"submit\"]")
	WebElement lgnbtn;
	
	public void setUsername(String name) {
		username.sendKeys(name);
	}
	
	public void setPassword(String pword) {
		password.sendKeys(pword);
	}
	
	public void clickLoginbtn() {
		lgnbtn.click();
	}
	
	
	

}
