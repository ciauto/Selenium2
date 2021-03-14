package seleniumAdv2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseactionTD {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.td.com");
		
		driver.findElement(By.id("ensCall")).click();
		
		WebElement products_menu=driver.findElement(By.linkText("Products"));
		Actions action=new Actions(driver);
		action.moveToElement(products_menu).build().perform();
		
		
		driver.findElement(By.linkText("Promotions & Offers")).click();
		Thread.sleep(7000);
		driver.close();
	}
}
