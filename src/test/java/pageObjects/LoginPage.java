package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	
	public LoginPage(WebDriver driver){
		super(driver);
		
	}
	
	@FindBy(xpath="//input[@name=\"username\"]")
	WebElement txtUserName;
	
	@FindBy (xpath="//input[@name=\"password\"]")
	WebElement txtPassword;
	
	@FindBy (xpath="//button[@type=\"submit\"]")
	WebElement btnLoginButton;
	
	@FindBy (xpath="//p[@class=\"oxd-text oxd-text--p oxd-alert-content-text\"]")
	WebElement invalidLoginError;
	
	@FindBy (xpath="//img[@class=\"oxd-userdropdown-img\"]")
	WebElement profileImg; 
	
	
	public void enterUsername(String name) {
		txtUserName.sendKeys(name);
	}
	public void enterPassword(String pass) {
		txtPassword.sendKeys(pass);
	}
	
	public void clickLogin() {
		btnLoginButton.click();
	}
	
	public boolean loginSuccess() {
		return driver.getCurrentUrl().contains("dashboard");
	}
	
	public boolean loginFail() {
		return invalidLoginError.isDisplayed();
	}
	
	

}
