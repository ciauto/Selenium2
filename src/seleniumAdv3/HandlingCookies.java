package seleniumAdv3;

import java.awt.AWTException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HandlingCookies {
	private WebDriver driver;
	private String baseUrl;

	@BeforeClass
	public void beforeClass() throws MalformedURLException {
		baseUrl = "https://www.gmail.com/";
		System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(baseUrl);
		Set<Cookie> cookiesForCurrentURL = driver.manage().getCookies();
		for (Cookie cookie : cookiesForCurrentURL) {
		    System.out.println(" Cookie Name - " + cookie.getName() 
					+ " Cookie Value - "  + cookie.getValue());
		}

	}

	@Test
	public void fileUpload() throws AWTException, InterruptedException, IOException {
		driver.findElement(By.xpath("//*[@id='identifierId']")).sendKeys("nareshpraj@gmail.com");
		driver.findElement(By.xpath("/html//div[@id='identifierNext']")).click();
		String encodepassword= "b01nMjlKb1QhCg==";
		driver.findElement(By.xpath("/html//div[@id='password']//input[@name='password']")).sendKeys(decodestr(encodepassword));
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='T-I J-J5-Ji T-I-KE L3']")).click();
		driver.findElement(By.xpath("/html/body[@class='aAU']/div[7]/div[@class='nH']/div[@class='nH']/div[2]/div[@class='no']/div[1]//div[@class='oo']//div[@class='aic']//div[@role='button']")).click();
		Thread.sleep(3000);
		driver.findElement(By.name("to")).sendKeys("naresh_rp@hotmail.com");
		Thread.sleep(3000);
		driver.findElement(By.name("subjectbox")).sendKeys("Testing File Upload");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='a1 aaA aMZ']")).click();
		Thread.sleep(3000);
		Runtime.getRuntime().exec("C:\\Users\\Naresh\\oxygen-workspace\\Selenium2\\scripts\\fileupload.exe");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='J-J5-Ji btA']")).click();
	}

	@AfterClass
	public void afterClass() {
		driver.quit();

	}
	
	private CharSequence decodestr(String encodepassword) {
		byte[] decodepass = Base64.decodeBase64(encodepassword);
		return new String(decodepass);
	}
}
