package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PIMPage  extends BasePage{
	public PIMPage(WebDriver driver){
		super(driver);
	}
	
	
	@FindBy (linkText="Add Employee")
	WebElement addEmployee;
	
	@FindBy(xpath="//input[@name=\"firstName\"]")
	WebElement txtFname;
	
	@FindBy (xpath="name=\"middleName\"")
	WebElement txtMidleNmae;
	
	@FindBy (xpath="//input[@name=\"lastName\"]")
	WebElement txtLName;
	
	

	
	
}
