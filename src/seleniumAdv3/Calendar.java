package seleniumAdv3;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Calendar {
	private WebDriver driver;
	private String baseurl = "https://www.nanakflights.com/";

	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(baseurl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	// below method will not run when you execute this script. It is disabled!
	public void testcase1() throws InterruptedException {
		driver.findElement(By.id("DepDate")).click();
		driver.findElement(By.xpath("//div[@id='ui-datepicker-div']//a[text()='31']")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("ArrDate")).click();
		driver.findElement(By.xpath("//div[@id='ui-datepicker-div']//div[1]//a[text()=20]")).click();
		Thread.sleep(3000);
	}

	@Test
	public void testcase2() throws InterruptedException {
		driver.findElement(By.id("DepDate")).click();
		driver.findElement(By.xpath("//div[@id='ui-datepicker-div']//a[text()='31']")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("ArrDate")).click();
		List<WebElement> dates = driver.findElements(By.xpath("//div[@id='ui-datepicker-div']//div[1]//tr/td"));
		int totaldates = dates.size();
		for (int i = 0; i < totaldates; i++) {
			String date = dates.get(i).getText();
			if (date.equals("20")) {
				dates.get(i).click();
				break;
			}
		}
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}