package seleniumAdv3;

import java.io.File;
import java.io.IOException;

import javax.mail.MessagingException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenCaptureWhenFailureSendEmail {

	public static void main(String[] args) throws IOException, MessagingException {
		System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		MonitoringMail mail = new MonitoringMail();
		
		driver.get("http://newtours.demoaut.com/");
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {
			driver.findElement(By.name("userNam"));
		} catch (Throwable t) {
			FileUtils.copyFile(scrFile, new File("C:\\screenshot\\error.jpg"));
			mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, TestConfig.subject, TestConfig.messageBody,
					TestConfig.attachmentPath, TestConfig.attachmentName);
			driver.quit();
		}
		driver.quit();
	}
}
