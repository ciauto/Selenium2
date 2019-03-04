package seleniumAdv3;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FileUpload_RobotClass {
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
	}

	@Test
	public void fileUpload() throws AWTException, InterruptedException {
		driver.findElement(By.xpath("//*[@id='identifierId']")).sendKeys("youremailaddress@gmail.com");
		driver.findElement(By.xpath("/html//div[@id='identifierNext']")).click();
		String encodepassword= "xxxxxxxxxxxx";
		driver.findElement(By.xpath("/html//div[@id='password']//input[@name='password']")).sendKeys(decodestr(encodepassword));
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='T-I J-J5-Ji T-I-KE L3']")).click();
		driver.findElement(By.xpath("/html/body[@class='aAU']/div[7]/div[@class='nH']/div[@class='nH']/div[2]/div[@class='no']/div[1]//div[@class='oo']//div[@class='aic']//div[@role='button']")).click();
		Thread.sleep(3000);
		driver.findElement(By.name("to")).sendKeys("xxxxxxxx@hotmail.com");
		Thread.sleep(3000);
		driver.findElement(By.name("subjectbox")).sendKeys("Testing File Upload");
		Thread.sleep(3000);
		WebElement v=driver.findElement(By.xpath("//div[@class='a1 aaA aMZ']"));
		v.click();
		Thread.sleep(3000);
		//from this file path we are copying file in clipboard
		// Toolkit is a java AWT package
		StringSelection s = new StringSelection("C:\\Users\\Naresh\\Desktop\\test.txt");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s, null);
		// Ctrl + v (this will attach the file content)
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
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
