package seleniumAdv2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class HtmlUnitDriverdemo {

	public static void main(String[] args) {
		WebDriver driver = new HtmlUnitDriver();
		driver.get("http://newtours.demoaut.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.name("userName")).sendKeys("tutorial");
		driver.findElement(By.name("password")).sendKeys("tutorial1");
		driver.findElement(By.name("login")).click();
		boolean signoffbtn=driver.findElement(By.xpath("//a[text()='SIGN-OFF']")).isDisplayed();
		System.out.println(signoffbtn);
		
		if(signoffbtn==true){
			System.out.println("Test is passed");
		}
		else{
			System.out.println("Test is failed");
		}
		}
}
