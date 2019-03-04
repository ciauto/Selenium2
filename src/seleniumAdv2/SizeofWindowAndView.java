package seleniumAdv2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SizeofWindowAndView {
	private WebDriver driver;
	private JavascriptExecutor js;

	@BeforeTest
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "C:\\driver\\geckodriver.exe");
		driver = new FirefoxDriver();
		js = (JavascriptExecutor) driver;
		
		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void testJavaScriptExecution() throws Exception {
		// Navigation
		js.executeScript("window.location = 'http://www.twoplugs.com'");
		Thread.sleep(5000);
		//size of Window
		long height = (long)js.executeScript("return window.innerHeight;");
		System.out.println(height);
		long width  = (long)js.executeScript("return window.innerWidth;");
		System.out.println(width);
		
		// Scroll Down
		js.executeScript("window.scrollBy(0, 1400);");
		Thread.sleep(6000);
		
		// Scroll Up
		js.executeScript("window.scrollBy(0, -1400);");
		Thread.sleep(6000);
		
		//argument[0] defines the index of locator on the page. if you have multiple matching nodes then index 0 points to first one
		WebElement element=driver.findElement(By.xpath("//a[@class='btn white']"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		js.executeScript("window.scrollBy(0, -200);");
		Thread.sleep(6000);
		System.out.println(element.getText());
	}
	
	@AfterTest
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}
}
