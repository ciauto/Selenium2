package seleniumAdv3;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Chrome_Options_withExtensions {

	public static void main(String[] args) {
		String baseURL="http://www.facebook.com";
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addExtensions(new File("C:\\Users\\Naresh\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\Extensions\\ljngjbnaijcbncmcnjfhigebomdlkcjo\\4.0.0_0.crx"));
		options.addArguments("--disable-infobars");
		options.addArguments("--disable-web-security");
		driver = new ChromeDriver(options);
		driver.get(baseURL);

	}

}
