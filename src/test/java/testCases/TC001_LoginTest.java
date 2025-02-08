package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;

public class TC001_LoginTest extends BaseClass {

	@Test
	public void testValidLogin() {
		LoginPage lp = new LoginPage(driver);

		logger.info("Logging with Valid Credential");
		lp.enterUsername("Admin");
		lp.enterPassword("admin123");
		lp.clickLogin();

		try {
			Assert.assertTrue(lp.loginSuccess());
			logger.info("TC Pass - Succesfully logged in !");
		} catch (AssertionError e) {
			logger.error("TC Failed - Login Failed ! " + e.getMessage());
			throw e; // again thrown exception bcoz,if tc failed then still testng will show pass in reports as
						// handled assertion
		}
	}

	@Test
	public void testInValidLogin() {
		LoginPage lp = new LoginPage(driver);

		logger.info("Logging with InValid Credential");
		lp.enterUsername("Admin");
		lp.enterPassword("admin1234");
		lp.clickLogin();
		Assert.assertTrue(lp.loginFail());
		logger.info("Pass - Login Faild because of Invalid credential!");
	}

}
