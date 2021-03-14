package seleniumAdv2;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DragandDrop {
	private WebDriver driver;
	private String baseUrl;
	private JavascriptExecutor js;

	@BeforeTest
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		js = (JavascriptExecutor) driver;
		
	
		baseUrl = "http://www.dhtmlx.com/docs/products/dhtmlxTree/";
		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Test
	public void testDragAndDrop() throws Exception {
		driver.get(baseUrl);
		Thread.sleep(1000);
		WebElement fromElement1 = driver.findElement(By.xpath("//div[@id='treebox1']//span[text()='James Johns']"));
		WebElement toElement1 = driver.findElement(By.xpath("//div[@id='treebox2']//span[text()='Bestsellers']"));
		//Scroll to an element
		js.executeScript("arguments[0].scrollIntoView(true);", fromElement1);
		
		js.executeScript("window.scrollBy(0, -400);");
		
		
		
		Thread.sleep(4000);
		Actions action = new Actions(driver);
		// Click and hold, move to element, release, build and perform
		action.clickAndHold(fromElement1).perform();
		Thread.sleep(1000);
		action.moveToElement(toElement1).perform();
		Thread.sleep(1000);
		action.release(toElement1).perform();
	}
	@AfterTest
	public void tearDown() throws Exception {
		driver.quit();
	}
}
