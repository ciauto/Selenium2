package seleniumAdv2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Mouseaction2 {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.gecko.driver", "C:\\driver\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.busyqa.com/");
		WebElement class_menu=driver.findElement(By.xpath("//p[@id='DrpDwnMn02label']"));
		Actions action=new Actions(driver);
		action.moveToElement(class_menu).build().perform();
		driver.findElement(By.xpath("//p[@class='ddm1repeaterButtonlabel']")).click();
		Thread.sleep(6000);
		driver.quit();
	}
}
