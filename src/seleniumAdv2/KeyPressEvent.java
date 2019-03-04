package seleniumAdv2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class KeyPressEvent {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "C:\\driver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://gmail.com");
		//driver.findElement(By.xpath("//a[text()='Sign In']")).click();
		driver.findElement(By.id("identifierId")).sendKeys("naresh.busyQA@gmail.com");
		driver.findElement(By.id("identifierId")).sendKeys(Keys.ENTER); //simulates the key press event of the Enter button
		}
}
