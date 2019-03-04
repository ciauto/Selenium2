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
		WebElement products_menu=driver.findElement(By.xpath("html/body/div[3]/div[3]/header[1]/div[3]/div/div[1]/nav/ul/li[3]"));
		Actions action=new Actions(driver);
		action.moveToElement(products_menu).perform();
		driver.findElement(By.xpath("html/body/div[3]/div[3]/header[1]/div[3]/div/div[1]/nav/ul/li[3]/ul/li[3]/a")).click();
		Thread.sleep(7000);
		driver.close();;
	}
}
