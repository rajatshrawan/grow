package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver;
	
	
	
	
	public LoginPage (WebDriver rdriver) {
		
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	 
	@FindBy(xpath="//input[@name='uid']")
	WebElement username;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath="//input[@value='LOGIN']")
	WebElement loginbutton;
	
	@FindBy(xpath="//a[contains(text(),'Log out')]")
	WebElement logout;
	
	public void setUserName(String uname) {
		username.sendKeys(uname);
	}
	public void setPassword(String pwd) {
		password.sendKeys(pwd);
	}
	
	public void clickLogin() {
		loginbutton.click();
		
	}
	public void clickLogout() {
		logout.click();
		
	}

}
