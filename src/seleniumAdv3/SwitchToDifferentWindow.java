package seleniumAdv3;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SwitchToDifferentWindow {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "C:\\driver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		String baseurl = "http://www.msn.ca";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseurl);
		// Get Window Handle
		String MainWindowHandle = driver.getWindowHandle();
		System.out.println("MainWindow Handle is:  " + MainWindowHandle);
		WebElement element = driver.findElement(By.xpath("//h3[contains(.,'Outlook.com')]"));
		element.click();
		Set<String> handles = driver.getWindowHandles();
		for (String handle : handles) {
			System.out.println(handle);
			if (!handle.equals(MainWindowHandle)) {
				driver.switchTo().window(handle);
				Thread.sleep(3000);
				driver.findElement(By.xpath("//div[@class='buttonLargeBlue']")).click();
				Thread.sleep(2000);
				driver.close();
				break;
			}
		}
		driver.switchTo().window(MainWindowHandle);
		driver.findElement(By.xpath("//input[@id='q']")).sendKeys("Selenium Jobs");
		driver.findElement(By.xpath("//button[@id='sb_form_go']")).click();
		Thread.sleep(3000);
		driver.quit();
	}
}
