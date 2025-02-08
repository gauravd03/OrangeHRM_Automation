package testCases;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {
	WebDriver driver;
	public Logger logger;
	
	@BeforeClass
	public void setup() {
	driver=new ChromeDriver();
	logger=LogManager.getLogger(this.getClass());
	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	//driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
	}

	@AfterClass
	void TearDown() {
		driver.quit();
		
	}

}
