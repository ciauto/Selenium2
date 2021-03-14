package seleniumAdv1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstSeleniumScript {

	public static void main(String[] args) {
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
		String path= System.getProperty("user.dir");
		System.out.println(path);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		boolean signInBtn=driver.findElement(By.id("signin_button")).isDisplayed();
	
	}

}
