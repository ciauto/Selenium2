package seleniumAdv3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Chrome_Options_withoutExtensions {

	public static void main(String[] args) {
		String baseURL="http://www.facebook.com";
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(baseURL);

	}

}
