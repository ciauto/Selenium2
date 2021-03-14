package seleniumAdv1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class javascriptDemo {


	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
		WebElement element=driver.findElement(By.xpath("//body/div[1]/section[3]/ul[1]/li[1]/div[1]/div[1]/div[1]/div[1]/a[1]/span[1]"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		js.executeScript("window.scrollBy(0, -200);");
		Thread.sleep(6000);
		
		System.out.println(element.getText());
		
		Thread.sleep(3000);
		//driver.quit();
	}
}
