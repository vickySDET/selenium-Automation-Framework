package testcases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.LoginPage;

public class TC01_Logintest {
	
	public WebDriver driver;
	
	@BeforeClass
	public void setup() throws InterruptedException {
		
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		Thread.sleep(3000);
		
		
	}
      @AfterClass	
      public void teardown() {
	
	      driver.quit();
		
		
	}

         @Test
         public void Logintest() throws InterruptedException {
	
	     LoginPage lp = new LoginPage(driver);
	
	      lp.setUsername("Admin");
	      lp.setPassword("admin123");
	      lp.clickLoginbtn();
	      Thread.sleep(4000);
	
	
	
	
}

}
