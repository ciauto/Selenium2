package seleniumAdv2;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

	public class HiddenElement {
		WebDriver driver;
		String url;
		@BeforeTest
		public void setUp() throws Exception {
			System.setProperty("webdriver.gecko.driver", "C:\\driver\\geckodriver.exe");
			driver = new FirefoxDriver();
			url = "http://www.expedia.com";
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}
		@Test
		public void testExpedia() throws InterruptedException {
			driver.get(url);
			Select childdrop=new Select(driver.findElement(By.id("package-1-children-hp-package")));
			childdrop.selectByIndex(1);
			WebElement childage = driver.findElement(By.id("package-1-age-select-1-hp-package"));
			System.out.println("Child Age dropdown displayed  " +childage.isDisplayed());
			}
		@AfterTest
		public void tearDown() throws Exception {
			Thread.sleep(2000);
			driver.quit();
			}
}
