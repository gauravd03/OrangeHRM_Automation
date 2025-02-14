package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	public HomePage(WebDriver driver){
		super(driver);
		
	}
	
	@FindBy (xpath="//li[@class=\"oxd-main-menu-item-wrapper\"]//span[text()=\"PIM\"]")
	WebElement pimModule;

	@FindBy (xpath="//i[@class=\"oxd-icon bi-caret-down-fill oxd-userdropdown-icon\"]")
	WebElement profileDropdown;
	
	@FindBy (linkText="Logout")
	WebElement logout;
	
	public void clickOnPIMModule() {
		pimModule.click();
	}
	
	public void clickOnProfile() {
		profileDropdown.click();
	}
	
	public void clickLogout() {
		logout.click();
		
	}

}