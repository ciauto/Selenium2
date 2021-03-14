package seleniumAdv2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class HtmlUnitDriverdemo {

	public static void main(String[] args) {
		WebDriver driver = new HtmlUnitDriver();
		driver.get("http://zero.webappsecurity.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		boolean signInBtn=driver.findElement(By.id("signin_button")).isDisplayed();
		/*
		 * driver.findElement(By.name("user_login")).sendKeys("username");
		 * driver.findElement(By.id("user_password")).sendKeys("password");
		 * driver.findElement(By.name("submit")).click();
		 
		boolean lnkTxtSvng=driver.findElement(By.linkText("Savings")).isDisplayed();
		*/
		System.out.println(signInBtn);
		
		if(signInBtn==true){
			System.out.println("Test is passed");
		}
		else{
			System.out.println("Test is failed");
		}
		}
}
