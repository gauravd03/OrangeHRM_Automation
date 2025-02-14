package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

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
	
	@FindBy (xpath="//div[@class=\"oxd-input-group oxd-input-field-bottom-space\"]//input[@class=\"oxd-input oxd-input--active\"]")
	WebElement txtEmpId;
	
	@FindBy (xpath="//span[@class=\"oxd-switch-input oxd-switch-input--active --label-right\"]")
	WebElement toggleBtnCreateLoginDetails;
	
	@FindBy (xpath="//label[text()=\"Username\"]/parent::div/following-sibling::div/child::input")
	WebElement txtUsername;
	
	@FindBy (xpath="//input[@value=\"1\"]")
	WebElement radioBtnEnabled;
	
	@FindBy (xpath="//input[@value=\"2\"]")
	WebElement radioBtnDisabled;
	
	@FindBy (xpath="//div[@class=\"orangehrm-employee-form\"]/div[4]/div/div[1]/descendant::input")
	WebElement txtPassword;
	
	@FindBy(xpath="//div[@class=\"orangehrm-employee-form\"]/div[4]/div/div[2]//div[1]/descendant::input")
	WebElement txtConfirmPassword;
	
	@FindBy (xpath ="//button[@type=\"submit\"]")
	WebElement btnSave;
	
	@FindBy (xpath=("//div[@class=\"oxd-toast-content oxd-toast-content--success\"]/p[2]"))
	WebElement successMessage;
	
	public void addEmployeeClick() {
		addEmployee.click();
	}
	
	public void enterNameId(String Fname,String LName,String ID) {
		txtFname.sendKeys(Fname);
		txtLName.sendKeys(LName);
		txtEmpId.sendKeys(String.valueOf(ID));
	}
	
	public void toggleCreateLoginBtn() {
		toggleBtnCreateLoginDetails.click();
	}
	
	public void enterLoginDetails(String username, String pass , String confirmPass) {
		txtUsername.sendKeys(username);
		if(!radioBtnEnabled.isSelected()) {
			radioBtnEnabled.click();
		}
		txtPassword.sendKeys(pass);
		txtConfirmPassword.sendKeys(confirmPass);
		btnSave.click();
	}
	
	
	public String getSuccessMessage(){
		wait.until(ExpectedConditions.visibilityOf(successMessage));
		String msg=successMessage.getText();
		return msg;
	}

	
	
	
		
	
	

	
	
}
