package testCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.PIMPage;
import utilities.ExcelUtility;

public class TC002_AddEmployee extends BaseClass {
	HomePage home;
	PIMPage pim;
	LoginPage lp;

	@Test(dataProvider = "EmpCreation")
	void createEmployee(String FName, String ID, String Username, String Password) {
		home = new HomePage(driver);
		pim = new PIMPage(driver);
		lp = new LoginPage(driver);

		lp.enterUsername(p.getProperty("AdminUser"));
		lp.enterPassword(p.getProperty("Password"));
		lp.clickLogin();

		boolean flag = false;
		try {
			flag = lp.isCSRFTokenErrorDisplayed();
			System.out.println(flag + ("  --is error display or not"));
		} catch (Exception e) {
			logger.info("Successfully logged in ! ");
			
		}
		if (flag) {
			lp.enterUsername(p.getProperty("AdminUser"));
			lp.enterPassword(p.getProperty("Password"));
			lp.clickLogin();
			
		}

		home.clickOnPIMModule();
		pim.addEmployeeClick();
		
		logger.info("Employee creation start");
		pim.enterNameId(FName, p.getProperty("lname"), ID);
	    logger.info("Name & ID entered successfully!");
		pim.toggleCreateLoginBtn();
		pim.enterLoginDetails(Username, Password, Password);
		logger.info("Username and password entered successfully!");
		String successMessage = pim.getSuccessMessage();
		Assert.assertEquals(successMessage, "Successfully Saved");
		logger.info("Employee Created successfully -Message: " + successMessage);
		home.clickOnProfile();
		home.clickLogout();
	}

	@DataProvider(name = "EmpCreation")
	public Object[][] getData() throws Exception {
		// Provide data from the Excel sheet
		return ExcelUtility.getExcelData("C:\\Users\\gdandekar\\Downloads\\EmpData.xlsx", "Sheet1");
	}
}
