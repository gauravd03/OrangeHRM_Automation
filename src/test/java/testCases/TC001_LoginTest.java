package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;

public class TC001_LoginTest extends BaseClass {
	LoginPage  lp;

	@Test(priority = 0)
	public void testInValidLogin() {
		lp = new LoginPage(driver);

        lp.enterUsername(p.getProperty("AdminUser"));
		lp.enterPassword(p.getProperty("Password"));
		lp.clickLogin();
		
		logger.info("Logging with InValid Credential");
		lp.enterUsername(p.getProperty("AdminUser"));
		lp.enterPassword(p.getProperty("InvalidPass"));
		lp.clickLogin();
		
		Assert.assertEquals(lp.loginFail(), "Invalid credentials");
		logger.info("Pass - Login Faild because of Invalid credential!");
	}

	@Test(priority = 1)
	public void testValidLogin() {
		 lp = new LoginPage(driver);

		logger.info("Logging with Valid Credential");
		lp.enterUsername(p.getProperty("AdminUser"));	
		lp.enterPassword(p.getProperty("Password"));
		lp.clickLogin();
		
		try {
			Assert.assertTrue(lp.loginSuccess());
			logger.info("TC Pass - Succesfully logged in !");
		} catch (AssertionError e) {
			logger.error("TC Failed - Login Failed ! " + e.getMessage());
			throw e; // again thrown exception bcoz,if tc failed then still testng will show pass  reports as
						
		}
	}
	

	

}
