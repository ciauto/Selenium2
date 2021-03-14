package seleniumAdv3;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenCaptureWhenFailure {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.facebook.com");
		
		
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		
		try 
		{
			driver.findElement(By.name("websubmi"));
		} 
		
		catch (Throwable t) 
		{
			FileUtils.copyFile(scrFile, new File("c:\\screenshot\\captureerror1.jpg"));
			driver.quit();
		}
		
		
		driver.quit();
	}
}
